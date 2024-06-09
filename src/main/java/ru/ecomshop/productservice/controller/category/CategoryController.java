package ru.ecomshop.productservice.controller.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ecomshop.productservice.model.dto.category.request.CreateCategoryRequest;
import ru.ecomshop.productservice.model.dto.category.request.UpdateCategoryRequest;
import ru.ecomshop.productservice.model.dto.category.response.CategoryResponse;
import ru.ecomshop.productservice.service.category.CategoryService;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Collection<CategoryResponse>> getAllCategories() {
        return ok(categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long categoryId) {
        return ok(categoryService.getCategoryById(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return ResponseEntity
                .status(CREATED)
                .body(categoryService.createCategory(createCategoryRequest));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> updateCategoryById(@PathVariable Long categoryId,
                                                               @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return ok(categoryService.updateCategoryById(categoryId, updateCategoryRequest));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return ok().build();
    }
}
