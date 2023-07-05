package com.verint.ecommerce.controller;

import com.verint.ecommerce.models.Item;
import com.verint.ecommerce.models.Items;
import com.verint.ecommerce.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@Validated
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<Items> getItems(@RequestParam(defaultValue = "1") @Min(value = 1, message = "page value should be greater than 1") int page,
                                          @RequestParam(defaultValue = "10") @Min(value = 0, message = "size value should be greater than 0") int size) {
        List<Item> list = itemService.getItems(page, size);
        Items items = new Items(page, size, list);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
