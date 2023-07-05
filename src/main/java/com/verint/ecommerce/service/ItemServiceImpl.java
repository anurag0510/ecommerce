package com.verint.ecommerce.service;

import com.verint.ecommerce.data.ItemRepository;
import com.verint.ecommerce.models.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems(int page, int size) {
        return itemRepository.getItems(page, size);
    }

    @Override
    public Item getItem(Integer itemId) {
        return itemRepository.getItem(itemId);
    }
}
