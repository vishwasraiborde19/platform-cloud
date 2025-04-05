package com.lms.mgmt.service;



import com.lms.mgmt.dto.CategoryDTO;
import com.lms.mgmt.entity.Category;
import com.lms.mgmt.mapper.GenericModelMapper;
import com.lms.mgmt.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final GenericModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, GenericModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<CategoryDTO> getCategoryById(Integer id) {
        Optional<Category> Category = categoryRepository.findById(id);
        if (Category.isPresent()) {
            CategoryDTO categoryDTO = modelMapper.map(Category.get(), CategoryDTO.class);
            return Optional.of(categoryDTO);
        }
        return Optional.empty();
    }

    public List<CategoryDTO> getCategorys() {
        List<Category> Categorys = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = modelMapper.map(Categorys, List.class);
        return categoryDTOS;
    }

    public CategoryDTO saveCategory(CategoryDTO CategoryDTO) {
        Category Category = modelMapper.map(CategoryDTO, Category.class);
        Category = categoryRepository.save(Category);
        CategoryDTO = modelMapper.map(Category, CategoryDTO.class);
        return CategoryDTO;
    }

    public void deleteCategory(Integer id) {
        Category category = new Category();
        category.setCategoryId(id);
        categoryRepository.delete(category);
    }

}
