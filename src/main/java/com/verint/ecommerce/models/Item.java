package com.verint.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Item {

    @JsonProperty("item_id")
    private Integer id;
    private String picture;
    private String name;
    private String description;
    private Float price;
    private Float discount;

    public Item() {
    }

    public Item(Integer id, String picture, String name, String description, Float price, Float discount) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }
}
