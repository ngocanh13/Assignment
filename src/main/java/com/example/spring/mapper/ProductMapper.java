package com.example.spring.mapper;

import com.example.spring.dbo.req.ProductReq;
import com.example.spring.dbo.res.ProductRes;
import com.example.spring.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductReq productReq);
    ProductRes toDBO(Product product);
}
