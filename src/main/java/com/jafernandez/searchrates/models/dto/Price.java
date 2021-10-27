package com.jafernandez.searchrates.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {

    private int productId;
    private int brandId;
    private String priceList;
    private String date;
    private double price;
    private String currency;

}
