package ecommerce.repository;

import ecommerce.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImagesRepository extends JpaRepository<ProductImages,Long> {
}
