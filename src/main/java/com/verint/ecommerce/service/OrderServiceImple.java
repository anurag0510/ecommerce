package com.verint.ecommerce.service;

import com.verint.ecommerce.models.Item;
import com.verint.ecommerce.models.OrderData;
import com.verint.ecommerce.models.OrderRequestModel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderServiceImple implements OrderService {

    Map<String, OrderData> map;
    ItemService itemService;

    public OrderServiceImple(ItemService itemService) {
        this.itemService = itemService;
        this.map = new HashMap<>();
    }
    @Override
    public String orderItem(OrderRequestModel orderRequestModel) {
        String orderId = null;
        if(itemService.getItem(orderRequestModel.getItemId()) != null) {
            orderId = UUID.randomUUID().toString();
            map.put(orderId, new OrderData(itemService.getItem(orderRequestModel.getItemId()), orderRequestModel));
        }
        return orderId;
    }

    @Override
    public OrderData getOrder(String orderId) {
        if(map.containsKey(orderId))
            return map.get(orderId);
        return null;
    }
}
