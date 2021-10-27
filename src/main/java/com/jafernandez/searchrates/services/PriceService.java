package com.jafernandez.searchrates.services;

import com.jafernandez.searchrates.models.dto.Price;

import java.util.Date;
import java.util.List;

public interface PriceService {

    public List<Price> findPricesByCriteria(Date appDate, Integer productId, Integer brandId);

}
