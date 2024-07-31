package ecommerce.controller;

import ecommerce.dto.CategoryRequestDto;
import ecommerce.dto.CategoryResponseDto;
import ecommerce.entity.Category;
import ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/")
    public Category save(@RequestBody @Valid CategoryRequestDto categoryRequestDto){
    return categoryService.save(categoryRequestDto);
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryByID(id);
    }
    @GetMapping("/")
    public List<Category> getAllCategories(){
       return categoryService.getAllCategories();
    }
}
