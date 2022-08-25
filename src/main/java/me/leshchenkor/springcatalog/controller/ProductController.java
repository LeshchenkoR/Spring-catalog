package me.leshchenkor.springcatalog.controller;

import lombok.RequiredArgsConstructor;
import me.leshchenkor.springcatalog.entity.Product;
import me.leshchenkor.springcatalog.entity.SearchQuery;
import me.leshchenkor.springcatalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteProduct(@RequestBody Product product) {
        this.productService.deleteProduct(product);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void editProduct(@RequestBody Product product) {
        this.productService.editProduct(product);
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public Optional<Product> findByName(@RequestBody SearchQuery searchQuery) {
        return this.productService.findProductByName(searchQuery);
    }

}
