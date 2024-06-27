package com.assembleyourpc.app.controller;

import com.assembleyourpc.app.dto.CategoryResponseDTO;
import com.assembleyourpc.app.dto.CategoryRequestDTO;
import com.assembleyourpc.app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@Validated @RequestBody CategoryRequestDTO requestResponseDTO) {
        return new ResponseEntity<>(categoryService.saveCategory(requestResponseDTO), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponseDTO>> listOfCategories() {
        return ResponseEntity.ok(categoryService.getListOfCategories());
    }

    @GetMapping("/{CategoryId}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("CategoryId") Long CategoryId) {
        return ResponseEntity.ok(categoryService.getCategoryByID(CategoryId));
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<CategoryResponseDTO> getCategoryByName(@PathVariable("categoryName") String categoryName){
        return ResponseEntity.ok(categoryService.getCategoryByName(categoryName));
    }

}
