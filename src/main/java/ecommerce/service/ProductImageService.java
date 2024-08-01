package ecommerce.service;

import ecommerce.dto.ProductImagesRequestDto;
import ecommerce.dto.ProductImagesResponseDto;

import java.util.List;

public interface ProductImageService {
    ProductImagesResponseDto saveProductImage(ProductImagesRequestDto productImagesRequestDto);
    ProductImagesResponseDto getProductImageById(Long id);
    List<ProductImagesResponseDto> getAllProductImages();
    ProductImagesResponseDto updateProductImage(Long id, ProductImagesRequestDto productImagesRequestDto);
    void deleteProductImage(Long id);
}