package com.example.spring.mapper;

import com.example.spring.dbo.req.CategoryReq;
import com.example.spring.dbo.res.CategoryRes;
import com.example.spring.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryReq categoryReq);
    CategoryRes toDTO(Category category);


}
