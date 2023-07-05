package com.verint.ecommerce.service;

import com.verint.ecommerce.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> getItems(int page, int size);

    Item getItem(Integer itemId);
}
