package ecommerce.service;

import ecommerce.dto.CategoryRequestDto;
import ecommerce.dto.CategoryResponseDto;
import ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryByID(long id);
    Category save(CategoryRequestDto categoryRequestDto);

    boolean isCategoryExist(Long categoryId);
}
