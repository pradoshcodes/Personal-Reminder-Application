package com.reminder.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reminder.auth.dto.RegisterRequest;
import com.reminder.category.entity.Category;
import com.reminder.category.service.CategoryService;
import com.reminder.common.dto.ResponseData;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @GetMapping
//    public List<Category> getAllCategories() {
//        return categoryService.getAllCategories();
//    }
    
    
    @GetMapping
    public ResponseData getAllCategories() {

        ResponseData response = new ResponseData();

        List<Category> categories = categoryService.getAllCategories();

        if (categories.isEmpty()) {
            response.setResponseStatus("failed");
            response.setResponseMessage("No categories found");
            response.setData(null);
        } else {
            response.setResponseStatus("success");
            response.setResponseMessage("Categories fetched successfully");
            response.setData(categories);
        }

        return response;
    }
    
    
   

}