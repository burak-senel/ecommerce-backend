package ecommerce.controller;

import ecommerce.dto.ProductRequestDto;
import ecommerce.entity.Product;
import ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product save(@Valid @RequestBody ProductRequestDto productRequestDto){
        return productService.save(productRequestDto);
    }
}
