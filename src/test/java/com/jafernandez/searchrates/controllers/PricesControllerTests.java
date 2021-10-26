package com.jafernandez.searchrates.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jafernandez.searchrates.models.dto.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_OK() throws Exception {

        MvcResult mvcResult = mvc.perform(get("/prices"))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertNotNull(response);
        assertNotNull(response.getContentAsString());

        List<Price> prices = this.objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Price>>() {});
        assertNotNull(prices);
        assertEquals(4, prices.size());
    }

    @Test
    public void test_OK_withParams1() throws Exception {

        String brandId = "1";
        String productId = "35455";
        String appDate = "2020-06-14-10.00.00";

        MvcResult mvcResult = mvc.perform(get(String.format("/prices?brandId=%s&productId=%s&appDate=%s", brandId, productId, appDate)))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertNotNull(response);
        assertNotNull(response.getContentAsString());

        List<Price> prices = this.objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Price>>() {});
        assertNotNull(prices);
        assertEquals(1, prices.size());
    }

    @Test
    public void test_OK_withParams2() throws Exception {

        String brandId = "1";
        String productId = "35455";
        String appDate = "2020-06-14-16.00.00";

        MvcResult mvcResult = mvc.perform(get(String.format("/prices?brandId=%s&productId=%s&appDate=%s", brandId, productId, appDate)))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertNotNull(response);
        assertNotNull(response.getContentAsString());

        List<Price> prices = this.objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Price>>() {});
        assertNotNull(prices);
        assertEquals(2, prices.size());
    }

    @Test
    public void test_OK_withParams3() throws Exception {

        String brandId = "1";
        String productId = "35455";
        String appDate = "2020-06-14-21.00.00";

        MvcResult mvcResult = mvc.perform(get(String.format("/prices?brandId=%s&productId=%s&appDate=%s", brandId, productId, appDate)))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertNotNull(response);
        assertNotNull(response.getContentAsString());

        List<Price> prices = this.objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Price>>() {});
        assertNotNull(prices);
        assertEquals(1, prices.size());
    }

    @Test
    public void test_OK_withParams4() throws Exception {

        String brandId = "1";
        String productId = "35455";
        String appDate = "2020-06-15-10.00.00";

        MvcResult mvcResult = mvc.perform(get(String.format("/prices?brandId=%s&productId=%s&appDate=%s", brandId, productId, appDate)))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertNotNull(response);
        assertNotNull(response.getContentAsString());

        List<Price> prices = this.objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Price>>() {});
        assertNotNull(prices);
        assertEquals(2, prices.size());
    }

    @Test
    public void test_OK_withParams5() throws Exception {

        String brandId = "1";
        String productId = "35455";
        String appDate = "2020-06-16-21.00.00";

        MvcResult mvcResult = mvc.perform(get(String.format("/prices?brandId=%s&productId=%s&appDate=%s", brandId, productId, appDate)))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        assertNotNull(response);
        assertNotNull(response.getContentAsString());

        List<Price> prices = this.objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Price>>() {});
        assertNotNull(prices);
        assertEquals(2, prices.size());
    }

    @Test
    public void test_BadRequest() throws Exception {

        mvc.perform(get(String.format("/prices?appDate=%s", "fakeDate")))
                .andExpect(status().isBadRequest());
    }

}
