package ecommerce.service;

import ecommerce.dto.ProductRequestDto;
import ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(ProductRequestDto productRequestDto);
    List<Product> save(List<ProductRequestDto> products);
    Product findById(Long id);
    List<Product> getProductsByCategoryId(Long categoryId);

}
