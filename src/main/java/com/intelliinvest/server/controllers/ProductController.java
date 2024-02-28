package com.intelliinvest.server.controllers;

import com.intelliinvest.server.payloads.ProductDto;
import com.intelliinvest.server.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/add")
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto){
        return new ResponseEntity<>(this.productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> UpdateProduct(ProductDto productDto){
        return new ResponseEntity<>(this.productService.updateProduct(productDto), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{productId}/")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
        this.productService.DeleteProduct(Integer.valueOf(productId));
        return new ResponseEntity<>(Map.of("Message","Deleted successfully"),HttpStatus.CREATED);
    }


}
