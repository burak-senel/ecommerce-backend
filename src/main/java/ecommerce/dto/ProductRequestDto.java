package ecommerce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    @Min(0)
    private Double price;

    @NotNull
    @Min(0)
    private Integer stock;

    @NotNull
    @Min(0)
    private Long category_id;

    @Valid
    @NotNull
    private List<ProductImagesRequestDto> images;

}
