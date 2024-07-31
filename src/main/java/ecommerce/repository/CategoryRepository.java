package ecommerce.repository;

import ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c FROM Category c WHERE c.id=:id")
    Category getCategoryByID(Long id);
    @Query("SELECT c FROM Category c WHERE c.name = :name AND c.gender=:gender")
    Category findByNameAndGender(String name,String gender);
}
