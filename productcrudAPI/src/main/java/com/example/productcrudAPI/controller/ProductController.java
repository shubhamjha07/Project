package com.example.productcrudAPI.controller;
import java.util.List;
import com.example.productcrudAPI.exception.ResourceNotFoundException;
import com.example.productcrudAPI.model.Product;
import com.example.productcrudAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List <Product> getAllproduct()
    {
        return productRepository.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductId(@PathVariable long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()  -> new ResourceNotFoundException("Product not exist with id :" + id));
        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product ProductDetails){
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
        updateProduct.setPname(ProductDetails.getPname());
        updateProduct.setPdescription(ProductDetails.getPdescription());


        productRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id" +id));
        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
