package com.example.spring.service;

import com.example.spring.dbo.req.ProductReq;
import com.example.spring.dbo.res.ProductRes;
import com.example.spring.mapper.ProductMapper;
import com.example.spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductRes> all(){
        return productRepository.findAll().stream().map(productMapper::toDBO).toList();
    }

    public ProductRes create(ProductReq product){
        return productMapper.toDBO(
                productRepository.save(
                        productMapper.toEntity(product)));
    }

    public List<ProductRes> filter(String name, Double minPrice, Double maxPrice){
        return productRepository.filter(name, minPrice, maxPrice).stream().map(productMapper::toDBO).toList();
    }


}
