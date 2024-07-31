package ecommerce.mapper;

import ecommerce.dto.ProductImagesRequestDto;
import ecommerce.dto.ProductImagesResponseDto;
import ecommerce.dto.ProductRequestDto;
import ecommerce.dto.ProductResponseDto;
import ecommerce.entity.Category;
import ecommerce.entity.Product;
import ecommerce.entity.ProductImages;
import ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProductMapper {
    private final CategoryService categoryService;

    @Autowired
    public ProductMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public  ProductResponseDto ProductToProductResponseDto(Product pr){
        ProductResponseDto res=new ProductResponseDto();
        res.setId(pr.getId());
        res.setName(pr.getName());
        res.setPrice(pr.getPrice());
        res.setStock(pr.getStock());
        res.setCategory_id(pr.getCategory().getId());
        res.setDescription(pr.getDescription());
        List<ProductImagesResponseDto>images=new ArrayList<>();
        for(ProductImages img: pr.getProductImages()){
            ProductImagesResponseDto imgResponse= new ProductImagesResponseDto();
            imgResponse.setUrl(img.getUrl());
            imgResponse.setProduct_id(pr.getId());
            images.add(imgResponse);
        }
        res.setImages(images);
        return res;
    }

    public  Product productRequestDtoToProduct(ProductRequestDto p){
        Product pr = new Product();
        pr.setName(p.getName());
        pr.setDescription(p.getDescription());
        pr.setPrice(p.getPrice());
        pr.setStock(p.getStock());
        Category c = categoryService.getCategoryByID(p.getCategory_id());
        pr.setCategory(c);
        List<ProductImages> images = new ArrayList<>();
        for(ProductImagesRequestDto img : p.getImages()){
            ProductImages newImg = new ProductImages();
            newImg.setUrl(img.getUrl());
            newImg.setProduct(pr);
            images.add(newImg);
        }
        pr.setProductImages(images);
        return pr;
    }

}
