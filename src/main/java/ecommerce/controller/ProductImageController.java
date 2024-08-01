package ecommerce.controller;

import ecommerce.dto.ProductImagesRequestDto;
import ecommerce.dto.ProductImagesResponseDto;
import ecommerce.service.ProductImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-images")
public class ProductImageController {
   private final ProductImageService productImageService;
    @Autowired
    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }
    @PostMapping("/add")
    public ProductImagesResponseDto saveProductImage(@Valid @RequestBody ProductImagesRequestDto productImagesRequestDto) {
        return productImageService.saveProductImage(productImagesRequestDto);
    }

    @GetMapping("/{id}")
    public ProductImagesResponseDto getProductImageById(@PathVariable Long id) {
        return productImageService.getProductImageById(id);
    }

    @GetMapping
    public List<ProductImagesResponseDto> getAllProductImages() {
        return productImageService.getAllProductImages();
    }

    @PutMapping("/{id}")
    public ProductImagesResponseDto updateProductImage(@PathVariable Long id, @Valid @RequestBody ProductImagesRequestDto productImagesRequestDto) {
        return productImageService.updateProductImage(id, productImagesRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductImage(@PathVariable Long id) {
        productImageService.deleteProductImage(id);
    }
}
