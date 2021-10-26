package com.jafernandez.searchrates.services;

import com.jafernandez.searchrates.models.dto.Price;
import com.jafernandez.searchrates.repositories.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTests {

    @InjectMocks
    PriceService priceService = new PriceServiceImpl();

    @Mock
    PriceRepository priceRepository;

    @Test
    public void test_OK() throws ParseException {

        MockitoAnnotations.openMocks(this);

        when(this.priceRepository.findPricesByCriteria(
                nullable(Date.class),
                nullable(Integer.class),
                nullable(Integer.class)
        )).thenReturn(Arrays.asList(new com.jafernandez.searchrates.models.entity.Price()));

        List<Price> result = this.priceService.findPricesByCriteria(null, null, null);
        assertNotNull(result);
    }

    @Test
    public void test_EmptyResult() throws ParseException {

        MockitoAnnotations.openMocks(this);

        when(this.priceRepository.findPricesByCriteria(
                nullable(Date.class),
                nullable(Integer.class),
                nullable(Integer.class)
        )).thenReturn(null);

        List<Price> result = this.priceService.findPricesByCriteria(null, null, null);
        assertNull(result);
    }

}
