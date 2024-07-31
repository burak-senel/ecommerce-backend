package ecommerce.service;

import ecommerce.dto.ProductRequestDto;
import ecommerce.entity.Product;
import ecommerce.exceptions.CommerceException;
import ecommerce.mapper.ProductMapper;
import ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService=categoryService;
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
List<Product> savedProducts=new ArrayList<>();
    for(ProductRequestDto pr:products){
        Product savedProduct=save(pr);
        savedProducts.add(savedProduct);
    }
    return savedProducts;
    }

    @Override
    public Product findById(Long id) {
    return productRepository.getProductById(id).orElseThrow(()->new CommerceException("Product is not exist or wrong id",HttpStatus.BAD_REQUEST));
        }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        if (!categoryService.isCategoryExist(categoryId)) { // Check if category exists
            throw new CommerceException("Category with ID " + categoryId + " does not exist.", HttpStatus.BAD_REQUEST);
        }
        return productRepository.getProductsByCategoryId(categoryId);
    }

}
