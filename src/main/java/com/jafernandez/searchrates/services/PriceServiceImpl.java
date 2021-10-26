package com.jafernandez.searchrates.services;

import com.jafernandez.searchrates.models.entity.Price;
import com.jafernandez.searchrates.repositories.PriceRepository;
import com.jafernandez.searchrates.utils.MapperUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public List<com.jafernandez.searchrates.models.dto.Price> findPricesByCriteria(Date appDate, Integer productId, Integer brandId) throws ParseException {

        List<Price> repositoryResult = this.priceRepository.findPricesByCriteria(appDate, productId, brandId);

        if (CollectionUtils.isEmpty(repositoryResult)) {
            return null;
        } else {

            List<com.jafernandez.searchrates.models.dto.Price> result = new ArrayList<com.jafernandez.searchrates.models.dto.Price>();

            for (Price price : repositoryResult) {
                result.add(MapperUtils.mapPriceEntityToDTO(price, appDate));
            }

            return result;
        }
    }

}
