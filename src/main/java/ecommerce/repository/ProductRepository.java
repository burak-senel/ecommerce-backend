package ecommerce.repository;

import ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :productName, '%'))")
    Optional<Product> findByProductName(String productName);

    @Query("SELECT p FROM Product p WHERE p.category_id = :categoryID")
    List<Product> getProductsByCategoryId(long categoryID);

    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> getProductById(long id);

    @Query("SELECT p FROM Product p WHERE p.category_id = :categoryID AND LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY p.price DESC")
    List<Product> searchAndDescSortAndCategory(long categoryID, String name);

    @Query("SELECT p FROM Product p WHERE p.category_id = :categoryID AND LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY p.price ASC")
    List<Product> searchAndAscSortAndCategory(long categoryID, String name);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY p.price DESC")
    List<Product> searchAndHighestSorting(String name);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) ORDER BY p.price ASC")
    List<Product> searchAndLowestSorting(String name);

    @Query("SELECT p FROM Product p ORDER BY p.price DESC")
    List<Product> highestToLowestSorting();

    @Query("SELECT p FROM Product p WHERE p.category_id = :categoryID ORDER BY p.price DESC")
    List<Product> highestToLowestSortingAndCategory(long categoryID);

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> lowestToHighestSorting();

    @Query("SELECT p FROM Product p WHERE p.category_id = :categoryID ORDER BY p.price ASC")
    List<Product> lowestToHighestSortingAndCategory(long categoryID);


}

