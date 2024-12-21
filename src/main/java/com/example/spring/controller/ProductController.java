package com.example.spring.controller;


import com.example.spring.dbo.req.ProductReq;
import com.example.spring.dbo.res.ProductRes;
import com.example.spring.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.DoubleStream;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping
    public List<ProductRes> getAllProduct(){
        return productService.all();
    }
    @PostMapping
    public ResponseEntity<ProductRes> createProduct(@RequestBody ProductReq product){
        return ResponseEntity.ok(productService.create(product));
    }

    @PostMapping("search")
    public List<ProductRes> search( @RequestBody(required = false) String name,
                                    @RequestBody(required = false) Double minPrice,
                                    @RequestBody(required = false) Double maxPrice){
        return productService.filter(name,minPrice,maxPrice);
    }
}
