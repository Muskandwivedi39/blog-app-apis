package com.blog.blogappapis.services;

import com.blog.blogappapis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    void  deleteCategory(Integer categoryId);
    public CategoryDto getCategory(Integer categoryId);
     List<CategoryDto> getCategories();


}
