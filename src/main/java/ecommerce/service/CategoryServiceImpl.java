package ecommerce.service;

import ecommerce.dto.CategoryRequestDto;
import ecommerce.dto.CategoryResponseDto;
import ecommerce.entity.Category;
import ecommerce.exceptions.CommerceException;
import ecommerce.mapper.CategoryMapper;
import ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByID(long id) {
        return categoryRepository.findById(id).orElseThrow(()->new CommerceException("Category id not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Category save(CategoryRequestDto categoryRequestDto) {
        Category existingCategory = categoryRepository.findByNameAndGender(categoryRequestDto.getName(),categoryRequestDto.getGender());
        if (existingCategory != null) {
            throw new CommerceException("Category already exists", HttpStatus.BAD_REQUEST);
        }
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category.setGender(categoryRequestDto.getGender());
        category.setImage_url(categoryRequestDto.getImage_url());

        Category savedCategory = categoryRepository.save(category);

        return savedCategory;


    }
}
