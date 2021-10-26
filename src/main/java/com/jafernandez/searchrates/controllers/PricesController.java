package com.jafernandez.searchrates.controllers;

import com.jafernandez.searchrates.models.dto.Price;
import com.jafernandez.searchrates.services.PriceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PricesController {

    @Autowired
    PriceService priceService;

    @GetMapping("/prices")
    private List<Price> getPrices(@RequestParam(required = false, name = "appDate") String appDate,
                                  @RequestParam(required = false, name = "productId") String productId,
                                  @RequestParam(required = false, name = "brandId") String brandId) throws NumberFormatException, ParseException {

        Date date = null;
        Integer product = null;
        Integer brand = null;

        if (StringUtils.isNotEmpty(appDate)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
            date = simpleDateFormat.parse(appDate);
        }

        if (StringUtils.isNotEmpty(productId)) {
            product = Integer.parseInt(productId);
        }

        if (StringUtils.isNotEmpty(brandId)) {
            brand = Integer.parseInt(brandId);
        }

        return this.priceService.findPricesByCriteria(date, product, brand);
    }

}
