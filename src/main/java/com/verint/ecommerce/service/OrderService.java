package com.verint.ecommerce.service;

import com.verint.ecommerce.models.Item;
import com.verint.ecommerce.models.OrderData;
import com.verint.ecommerce.models.OrderRequestModel;

public interface OrderService {
    String orderItem(OrderRequestModel orderRequestModel);

    OrderData getOrder(String orderId);
}
