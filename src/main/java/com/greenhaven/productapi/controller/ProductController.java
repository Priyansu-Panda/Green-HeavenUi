package com.greenhaven.productapi.controller;

import com.greenhaven.productapi.model.Product;
import com.greenhaven.productapi.repository.ProductRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepo;

    //    It allows Spring to automatically connect the ProductRepository with this controller.
    //    dependency injection
    public ProductController(ProductRepository productRepo){    // constructor
        this.productRepo = productRepo;
    }

    @GetMapping
    public  List<Product> getAllProducts(){
        return productRepo.findAll();   //It fetches all products from the database using findAll() and returns them as a list
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepo.save(product);   // saves the entity
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
        return productRepo.findById(id).map(product -> {
            product.setTitle(newProduct.getTitle());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            product.setImage(newProduct.getImage());
            return productRepo.save(product);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Long id){
        productRepo.deleteById(id);
        return true;
    }
}
