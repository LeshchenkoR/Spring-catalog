package me.leshchenkor.springcatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.leshchenkor.springcatalog.entity.Product;
import me.leshchenkor.springcatalog.entity.SearchQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testWhenAddNewProductsShouldCheckThatWasAdded() throws Exception {
        Product product = new Product();
        product.setCategory("Books");
        product.setDescription("How to program in 10 minutes");
        product.setName("Best book");
        product.setQuantity(30);
        product.setPrice(new BigDecimal("200"));

        mockMvc.perform(post("/api/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andDo(print());

        SearchQuery searchQuery = new SearchQuery(1l, "Best book");

        mockMvc.perform(post("/api/findByName")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(searchQuery )))
                .andDo(print());
    }

}