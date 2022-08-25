package me.leshchenkor.springcatalog.service;

import me.leshchenkor.springcatalog.entity.Product;
import me.leshchenkor.springcatalog.entity.SearchQuery;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void TestWhenAddNewProductsShouldSaved() {

        Product product = new Product();
        product.setCategory("Books");
        product.setDescription("How to program in 10 minutes");
        product.setName("Best book");
        product.setQuantity(30);
        product.setPrice(new BigDecimal("200"));

        productService.addProduct(product);

        Optional<Product> bestBook = productService.findProductByName(new SearchQuery(1L, "Best book"));
        Assertions.assertTrue(bestBook.isPresent());
    }

}