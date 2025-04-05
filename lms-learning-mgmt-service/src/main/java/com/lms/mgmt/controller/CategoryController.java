package com.lms.mgmt.controller;



import com.lms.mgmt.dto.CategoryDTO;
import com.lms.mgmt.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category-mgmt/v1")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/Categorys")
    public List<CategoryDTO> getCategorys() {
        return  categoryService.getCategorys();
    }

    @GetMapping("/Categorys/{id}")
    public CategoryDTO getCategory(@RequestParam Integer id) {
        return categoryService.getCategoryById(id).orElse(new CategoryDTO());
    }

    @PostMapping("/Categorys")
    public CategoryDTO addCategory(@RequestBody CategoryDTO CategoryDTO) {
        return categoryService.saveCategory(CategoryDTO);
    }

    @DeleteMapping("/Categorys/{id}")
    public void addCategory(@RequestParam Integer id) {
        categoryService.deleteCategory(id);
    }


}
