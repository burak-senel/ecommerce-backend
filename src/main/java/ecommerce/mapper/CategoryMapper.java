package ecommerce.mapper;

import ecommerce.dto.CategoryResponseDto;
import ecommerce.entity.Category;

public class CategoryMapper {
    public static CategoryResponseDto categoryToCategoryResponseDto(Category c){
        CategoryResponseDto res=new CategoryResponseDto();
        res.setName(c.getName());
        return res;
    }

}
