package com.verint.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderData {

    @JsonProperty("item_details")
    Item item;
    @JsonProperty("user_details")
    @JsonIgnoreProperties({"item_id", "credit_card_number"})
    OrderRequestModel orderData;
}
