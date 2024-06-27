package com.assembleyourpc.app.service;

import com.assembleyourpc.app.dto.CategoryRequestDTO;
import com.assembleyourpc.app.dto.CategoryResponseDTO;
import com.assembleyourpc.app.mapper.CategoryMapper;
import com.assembleyourpc.app.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public String saveCategory(CategoryRequestDTO requestDTO) {
        final var category = CategoryMapper.INSTANCE.fromCategoryRequestDtoToCategoryObj(requestDTO);
        category.setCategoryCreationDT(LocalDateTime.now());
        return Optional.of(categoryRepository.save(category)).orElseThrow(() -> new RuntimeException("Unable to Save Category.")).getCategoryName() + " is added successfully.";
    }

    public List<CategoryResponseDTO> getListOfCategories() {
        return CategoryMapper.INSTANCE.fromListOfCategoryObjToListOfCategoryResponseDto(categoryRepository.findAll());
    }

    public CategoryResponseDTO getCategoryByID(Long categoryId) {
        return CategoryMapper.INSTANCE.fromCategoryObjToCategoryResponseDto(categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found.")));
    }

    public CategoryResponseDTO getCategoryByName(String categoryName) {
        return CategoryMapper.INSTANCE.fromCategoryObjToCategoryResponseDto(categoryRepository.findByCategoryName(categoryName).orElseThrow(() -> new RuntimeException("Category Not found.")));
    }
}
