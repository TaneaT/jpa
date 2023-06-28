package com.example.jpa.Hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping("/add")
    void addProduct (@RequestBody Product product){
        productRepository.save(product);
    }

    @GetMapping("/all")
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/id/{id}")
    Optional<Product> getProductById(@PathVariable Long id){
        return productRepository.findById(id);
    }

    @DeleteMapping("/delete/all")
    void deleteAllProduct(){
        productRepository.deleteAll();
    }
    @GetMapping("/name/{name}")
    List<Product> getProductsByName(@PathVariable String name){
        return productRepository.getProductByName(name);
    }
    @DeleteMapping("/delete/{id}")
    void deleteProductById(@PathVariable Long id){
        productRepository.deleteById(id);
    }


}
