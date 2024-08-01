package ecommerce.service;

import ecommerce.dto.ProductImagesRequestDto;
import ecommerce.dto.ProductImagesResponseDto;
import ecommerce.entity.Product;
import ecommerce.entity.ProductImages;
import ecommerce.exceptions.CommerceException;
import ecommerce.mapper.ImageMapper;
import ecommerce.repository.ProductImagesRepository;
import ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService{
    private final ProductImagesRepository productImagesRepository;
    private final ProductRepository productRepository;


    @Autowired
    public ProductImageServiceImpl(ProductImagesRepository productImagesRepository, ProductRepository productRepository) {
        this.productImagesRepository = productImagesRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductImagesResponseDto saveProductImage(ProductImagesRequestDto productImagesRequestDto) {
        Product product = productRepository.findById(productImagesRequestDto.getProduct_id())
                .orElseThrow(() -> new CommerceException("Product not found with id: " + productImagesRequestDto.getProduct_id(), HttpStatus.NOT_FOUND));

        ProductImages productImages = ImageMapper.imageRequestDtoToImage(productImagesRequestDto);
        productImages.setProduct(product);

        ProductImages savedProductImages = productImagesRepository.save(productImages);
        return ImageMapper.toProductImagesResponseDto(savedProductImages);
    }
    @Override
    public ProductImagesResponseDto getProductImageById(Long id) {
        return productImagesRepository.findById(id)
                .map(ImageMapper::toProductImagesResponseDto)
                .orElseThrow(() -> new CommerceException("ProductImage not found with id: " + id, HttpStatus.NOT_FOUND));
    }
    @Override
    public List<ProductImagesResponseDto> getAllProductImages() {
        return ImageMapper.toProductImagesResponseDtoList(productImagesRepository.findAll());
    }

    @Override
    public ProductImagesResponseDto updateProductImage(Long id, ProductImagesRequestDto productImagesRequestDto) {
        ProductImages existingProductImages = productImagesRepository.findById(id)
                .orElseThrow(() -> new CommerceException("ProductImage not found with id: " + id, HttpStatus.NOT_FOUND));

        existingProductImages.setUrl(productImagesRequestDto.getUrl());

        ProductImages updatedProductImages = productImagesRepository.save(existingProductImages);
        return ImageMapper.toProductImagesResponseDto(updatedProductImages);
    }

    @Override
    public void deleteProductImage(Long id) {
        ProductImages productImages = productImagesRepository.findById(id)
                .orElseThrow(() -> new CommerceException("ProductImage not found with id: " + id, HttpStatus.NOT_FOUND));
        productImagesRepository.delete(productImages);
    }
}


