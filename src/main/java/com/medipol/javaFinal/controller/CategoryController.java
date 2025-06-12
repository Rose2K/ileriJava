package com.medipol.javaFinal.controller;

import com.medipol.javaFinal.model.Category;
import com.medipol.javaFinal.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category API", description = "Operations related to product categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Operation(summary = "Get all categories", description = "Returns a list of all categories in the system")
    public ResponseEntity<List<Category>> getAllCategories() {
        System.out.println("GET METHOD CALLED: getAllCategories");
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Operation(summary = "Get category by ID", description = "Returns a single category by its ID")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        System.out.println("GET METHOD CALLED: getCategoryById");
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.POST)
    @Operation(summary = "Create a new category", description = "Creates a new category in the system")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
        System.out.println("POST METHOD CALLED: createCategory");
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Update a category", description = "Updates an existing category by ID")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @Valid @RequestBody Category category) {
        System.out.println("PUT METHOD CALLED: updateCategory");
        return categoryService.getCategoryById(id)
                .map(existingCategory -> {
                    category.setId(id);
                    return ResponseEntity.ok(categoryService.saveCategory(category));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Delete a category", description = "Deletes an existing category by ID")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        System.out.println("DELETE METHOD CALLED: deleteCategory");
        if (categoryService.getCategoryById(id).isPresent()) {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @Operation(summary = "Search categories by name", description = "Returns categories that contain the search term in their name")
    public ResponseEntity<List<Category>> searchCategories(@RequestParam String name) {
        System.out.println("GET METHOD CALLED: searchCategories");
        return ResponseEntity.ok(categoryService.searchCategoriesByName(name));
    }

    @RequestMapping(value = "/enabled", method = RequestMethod.GET)
    @Operation(summary = "Get enabled categories", description = "Returns all enabled categories")
    public ResponseEntity<List<Category>> getEnabledCategories() {
        System.out.println("GET METHOD CALLED: getEnabledCategories");
        return ResponseEntity.ok(categoryService.findEnabledCategories());
    }

    @RequestMapping(value = "/{id}/enable", method = RequestMethod.PATCH)
    @Operation(summary = "Enable a category", description = "Enables a category")
    public ResponseEntity<Category> enableCategory(@PathVariable Long id) {
        System.out.println("PATCH METHOD CALLED: enableCategory");
        return categoryService.getCategoryById(id)
                .map(category -> {
                    category.setEnabled(true);
                    return ResponseEntity.ok(categoryService.saveCategory(category));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/{id}/disable", method = RequestMethod.PATCH)
    @Operation(summary = "Disable a category", description = "Disables a category")
    public ResponseEntity<Category> disableCategory(@PathVariable Long id) {
        System.out.println("PATCH METHOD CALLED: disableCategory");
        return categoryService.getCategoryById(id)
                .map(category -> {
                    category.setEnabled(false);
                    return ResponseEntity.ok(categoryService.saveCategory(category));
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 