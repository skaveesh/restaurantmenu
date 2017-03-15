package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.Category;
import net.codegen.restaurantmenu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("categories/getall")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
