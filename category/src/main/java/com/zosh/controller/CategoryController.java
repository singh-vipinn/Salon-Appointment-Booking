package com.zosh.controller;

import com.zosh.exception.UserException;
import com.zosh.modal.Category;
import com.zosh.payload.dto.SalonDTO;
import com.zosh.payload.dto.UserDTO;
import com.zosh.service.CategoryService;
import com.zosh.service.clients.SalonFeignClient;
import com.zosh.service.clients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final UserFeignClient userService;
    private final SalonFeignClient salonService;

    // Get all Categories
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Get all Categories by Salon ID
    @GetMapping("/salon/{id}")
    public ResponseEntity<Set<Category>> getCategoriesBySalon(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {
        UserDTO user=userService.getUserFromJwtToken(jwt).getBody();
        SalonDTO salon=salonService.getSalonById(id).getBody();

        Set<Category> categories = categoryService
                .getAllCategoriesBySalon(salon.getId());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Get a Category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long id,
            @RequestBody Category category
    ) throws Exception {
            Category updatedCategory = categoryService.updateCategory(id,category);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    // Delete a Category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
