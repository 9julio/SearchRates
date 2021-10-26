package com.jafernandez.searchrates.repositories;

import com.jafernandez.searchrates.models.entity.Price;

import java.util.Date;
import java.util.List;

public interface PriceRepository {

    public List<Price> findPricesByCriteria(Date appDate, Integer productId, Integer brandId);

}
