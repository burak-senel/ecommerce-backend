package ecommerce.controller;

import ecommerce.dto.ProductRequestDto;
import ecommerce.entity.Product;
import ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> save(@Valid @RequestBody ProductRequestDto productRequestDto) {
        Product savedProduct = productService.save(productRequestDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long categoryId) {
        List<Product> products = productService.getProductsByCategoryId(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/adds")
    public ResponseEntity<List<Product>> saveProducts(@Valid @RequestBody List<ProductRequestDto> productRequestDtos) {
        List<Product> savedProducts = productService.save(productRequestDtos);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }
}
