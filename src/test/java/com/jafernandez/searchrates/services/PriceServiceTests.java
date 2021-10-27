package com.jafernandez.searchrates.services;

import com.jafernandez.searchrates.models.dto.Price;
import com.jafernandez.searchrates.repositories.PriceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceServiceTests {

    @InjectMocks
    PriceServiceImpl priceService;

    @Mock
    PriceRepository priceRepositoryMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_OK() throws ParseException {

        when(this.priceRepositoryMock.findPricesByCriteria(
                nullable(Date.class),
                nullable(Integer.class),
                nullable(Integer.class)
        )).thenReturn(Arrays.asList(new com.jafernandez.searchrates.models.entity.Price()));

        List<Price> result = this.priceService.findPricesByCriteria(null, null, null);
        assertNotNull(result);
    }

    @Test
    public void test_EmptyResult() throws ParseException {

        when(this.priceRepositoryMock.findPricesByCriteria(
                nullable(Date.class),
                nullable(Integer.class),
                nullable(Integer.class)
        )).thenReturn(null);

        List<Price> result = this.priceService.findPricesByCriteria(null, null, null);
        assertNull(result);
    }

}
