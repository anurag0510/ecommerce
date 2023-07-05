package com.verint.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequestModel {

    @JsonProperty("item_id")
    @NotNull(message = "item_id cannot be empty and is required field.")
    private Integer itemId;
    @JsonProperty("full_name")
    @NotNull(message = "full_name cannot be empty and is required field.")
    @Pattern(regexp = "^[a-zA-Z \\\\s]*$", message = "Failed to match full_name pattern.")
    private String fullName;
    @NotNull(message = "address cannot be empty and is required field.")
    private String address;
    @NotNull(message = "email cannot be empty and is required field.")
    @Email
    private String email;
    @NotNull(message = "phone_number cannot be empty and is required field.")
    @JsonProperty("phone_number")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Failed to match phone_number pattern.")
    private String phoneNumber;
    @JsonProperty("credit_card_number")
    @NotNull(message = "credit_card_number cannot be empty and is required field.")
    @Pattern(regexp = "^\\d{19}$", message = "Failed to match credit_card_number pattern.")
    private String creditCardNumber;


}
