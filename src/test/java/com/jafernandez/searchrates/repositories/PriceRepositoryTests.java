package com.jafernandez.searchrates.repositories;

import com.jafernandez.searchrates.models.entity.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceRepositoryTests {

    @Autowired
    PriceRepository priceRepository;

    @Test
    public void test_OK() {
        List<Price> result = this.priceRepository.findPricesByCriteria(null, 35455, 1);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

}
