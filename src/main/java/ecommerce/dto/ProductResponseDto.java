package ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private Long category_id;

    private List<ProductImagesResponseDto> images;

}
