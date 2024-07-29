package ecommerce.mapper;

import ecommerce.dto.ProductImagesResponseDto;
import ecommerce.dto.ProductRequestDto;
import ecommerce.dto.ProductResponseDto;
import ecommerce.entity.Product;
import ecommerce.entity.ProductImages;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static ProductResponseDto ProductToProductResponseDto(Product pr){
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

    public static Product productRequestDtoToProduct(ProductRequestDto p){
        Product pr=new Product();
        pr.setName(p.getName());
        pr.setDescription(p.getDescription());
        pr.setPrice(p.getPrice());
        pr.setStock(p.getStock());
        return pr;
    }
}
