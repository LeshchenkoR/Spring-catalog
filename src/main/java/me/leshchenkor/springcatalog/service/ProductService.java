package me.leshchenkor.springcatalog.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.leshchenkor.springcatalog.entity.Product;
import me.leshchenkor.springcatalog.entity.SearchQuery;
import me.leshchenkor.springcatalog.exceptions.NotFoundProductException;
import me.leshchenkor.springcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        this.productRepository.delete(product);
    }

    public void editProduct(Product product) {
        this.productRepository.save(product);
    }

    public Optional<Product> findProductByName(SearchQuery searchQuery) {
        Optional<Product> product = this.productRepository.findByName(searchQuery.getName());
        if (product.isEmpty()) {
          //  throw new NotFoundProductException("Could not find the product);
            product = this.productRepository.findById(searchQuery.getId());
        }
        return product;
    }

}
