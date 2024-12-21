package com.example.spring.controller;

import com.example.spring.dbo.req.CategoryReq;
import com.example.spring.dbo.res.CategoryRes;
import com.example.spring.entity.Category;
import com.example.spring.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping()
    public List<CategoryRes> getAllCategory(){
        return categoryService.all();
    }

    @PostMapping()
    public ResponseEntity<CategoryRes> createCategory(@RequestBody CategoryReq category){
        return ResponseEntity.ok(categoryService.create(category));
    }

    @GetMapping("search")
    public List<CategoryRes> search(@RequestBody String s){
        return categoryService.searchByName(s);
    }

}
