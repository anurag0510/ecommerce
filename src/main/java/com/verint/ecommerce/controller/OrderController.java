package com.verint.ecommerce.controller;

import com.verint.ecommerce.models.Item;
import com.verint.ecommerce.models.OrderConfirmationResponseModel;
import com.verint.ecommerce.models.OrderData;
import com.verint.ecommerce.models.OrderRequestModel;
import com.verint.ecommerce.service.OrderService;
import com.verint.ecommerce.exceptions.EcommerceServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order")
@Validated
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderConfirmationResponseModel> getItems(@Valid @RequestBody OrderRequestModel orderRequestModel) {
        OrderConfirmationResponseModel orderConfirmationResponseModel = new OrderConfirmationResponseModel();
        orderConfirmationResponseModel.setOrderId(orderService.orderItem(orderRequestModel));
        if(orderConfirmationResponseModel.getOrderId() == null) {
            throw new EcommerceServiceException("No such item is present/active in system with item_id : " + orderRequestModel.getItemId());
        }
        return new ResponseEntity<>(orderConfirmationResponseModel, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderData> getItem(
            @PathVariable(value = "orderId", required = true) String orderId
    ) {
        OrderData orderData = orderService.getOrder(orderId);
        if(orderData == null)
            throw new EcommerceServiceException("no such order exists within the system for order id : " + orderId);
        return new ResponseEntity<>(orderData, HttpStatus.OK);

    }
}
