package ecommerce.mapper;

import ecommerce.dto.CategoryResponseDto;
import ecommerce.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static CategoryResponseDto categoryToCategoryResponseDto(Category c){
        if (c == null) {
            return null;
        }
        CategoryResponseDto res = new CategoryResponseDto();
        res.setId(c.getId());
        res.setName(c.getName());
        res.setGender(c.getGender());
        res.setImage_url(c.getImage_url());
        return res;
    }

    public static List<CategoryResponseDto> categoryToCategoryResponseDto(List<Category> categories) {
        List<CategoryResponseDto> responseList = new ArrayList<>();

        for (Category category : categories) {
            responseList.add(categoryToCategoryResponseDto(category));
        }

        return responseList;
    }

}
