package com.example.spring.service;

import com.example.spring.dbo.req.CategoryReq;
import com.example.spring.dbo.res.CategoryRes;
import com.example.spring.entity.Category;
import com.example.spring.mapper.CategoryMapper;
import com.example.spring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryRes> all(){
        return categoryRepository.findAll().stream().map(categoryMapper::toDTO).toList();
    }

    public CategoryRes create(CategoryReq category){
        return categoryMapper.toDTO(
                categoryRepository.save(
                        categoryMapper.toEntity(category)));
    }

    public List<CategoryRes> searchByName(String s){
        return categoryRepository.findAllByNameContains(s).stream().map(categoryMapper::toDTO).toList();
    }
}
