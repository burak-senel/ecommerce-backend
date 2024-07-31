package ecommerce.service;

import ecommerce.dto.ProductRequestDto;
import ecommerce.entity.Product;
import ecommerce.exceptions.CommerceException;
import ecommerce.mapper.ProductMapper;
import ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public Product save(ProductRequestDto productRequestDto) {
        if(productRepository.findByProductName(productRequestDto.getName()).isPresent()){
            throw new CommerceException("Product name: " + productRequestDto.getName() + " exist. Try different product.", HttpStatus.BAD_REQUEST);
        }
        Product pro = productMapper.productRequestDtoToProduct(productRequestDto);
        return productRepository.save(pro);
    }

    @Override
    public List<Product> save(List<ProductRequestDto> products) {
        return List.of();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return List.of();
    }

}
