package ecommerce.repository;

import ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :productName, '%'))")
    Optional<Product> findByProductName(String productName);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryID")
    List<Product> getProductsByCategoryId(Long categoryID);

    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> getProductById(Long id);


}

