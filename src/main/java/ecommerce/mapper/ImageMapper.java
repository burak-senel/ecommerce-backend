package ecommerce.mapper;

import ecommerce.dto.ProductImagesRequestDto;
import ecommerce.dto.ProductImagesResponseDto;
import ecommerce.dto.ProductRequestDto;
import ecommerce.entity.ProductImages;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ImageMapper {
    public static ProductImages imageRequestDtoToImage(ProductImagesRequestDto productImageRequestDto){
        ProductImages image = new ProductImages();
        image.setUrl(productImageRequestDto.getUrl());
        return image;
    }

    public static ProductImagesResponseDto toProductImagesResponseDto(ProductImages image){
        return new ProductImagesResponseDto(image.getUrl(),image.getProduct().getId());
    }
    public static List<ProductImagesResponseDto> toProductImagesResponseDtoList(List<ProductImages> productImagesList) {
        return productImagesList.stream()
                .map(ImageMapper::toProductImagesResponseDto)
                .collect(Collectors.toList());
    }
}
