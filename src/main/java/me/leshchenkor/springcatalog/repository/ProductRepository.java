package me.leshchenkor.springcatalog.repository;

import me.leshchenkor.springcatalog.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {

    Optional<Product> findByName(String name);

}
