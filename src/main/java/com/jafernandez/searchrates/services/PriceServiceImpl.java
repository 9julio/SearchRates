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
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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

            if (repositoryResult.size() > 1) {

                Map<String, List<Price>> mapByPriceList = repositoryResult.stream().collect(groupingBy(Price::getPrice_list, Collectors.toList()));

                for (String key : mapByPriceList.keySet()) {
                    List<Price> priceList = mapByPriceList.get(key);

                    Price price = priceList.get(0);

                    for (Price p : priceList) {
                        if (price.getPriority() < p.getPriority()) {
                            price = p;
                        }
                    }

                    result.add(MapperUtils.mapPriceEntityToDTO(price, appDate));
                }

            } else {
                result.add(MapperUtils.mapPriceEntityToDTO(repositoryResult.get(0), appDate));
            }

            return result;
        }
    }

}
