package com.jafernandez.searchrates.utils;

import com.jafernandez.searchrates.models.dto.Price;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MapperUtils {

    public static Price mapPriceEntityToDTO(com.jafernandez.searchrates.models.entity.Price price, Date date) throws ParseException {
        return price == null ? null : new Price(
                price.getProduct_id(),
                price.getBrand_id(),
                price.getPrice_list(),
                date == null ? new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").format(new Date()) : new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").format(date),
                price.getPrice(),
                price.getCurrency()
        );
    }

}
