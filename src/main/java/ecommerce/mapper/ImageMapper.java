package ecommerce.mapper;

import ecommerce.dto.ProductImagesRequestDto;
import ecommerce.dto.ProductImagesResponseDto;
import ecommerce.dto.ProductRequestDto;
import ecommerce.entity.ProductImages;

public class ImageMapper {
    public static ProductImages imageRequestDtoToImage(ProductImagesRequestDto productImageRequestDto){
        ProductImages image = new ProductImages();
        image.setUrl(productImageRequestDto.getUrl());
        return image;
    }

    public static ProductImagesResponseDto productImagesResponseDto(ProductImages image){
        return new ProductImagesResponseDto(image.getUrl(),image.getId());
    }
}
