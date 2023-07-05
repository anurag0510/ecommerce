package com.verint.ecommerce.data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.verint.ecommerce.models.Item;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {

    List<Item> items;

    @PostConstruct
    void populateItemList() throws CsvValidationException, IOException {
        items = new ArrayList<Item>();
        try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/items.csv"));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                if(values[0].equals("ItemId")) continue;
                items.add(new Item(Integer.parseInt(values[0]), values[1], values[2], values[3], Float.parseFloat(values[4]), Float.parseFloat(values[5])));
            }
        }
    }

    public List<Item> getItems(int page, int size) {
        return items.stream().skip((long) (page - 1) * size).limit(size).collect(Collectors.toList());
    }

    public Item getItem(Integer itemId) {
        List<Item> list = items.stream().filter(item -> Objects.equals(item.getId(), itemId)).collect(Collectors.toList());
        return list.size() != 0 ? list.get(0) : null;
    }
}
