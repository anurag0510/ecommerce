package com.verint.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderConfirmationResponseModel {

    @JsonProperty("order_id")
    private String orderId;
}
