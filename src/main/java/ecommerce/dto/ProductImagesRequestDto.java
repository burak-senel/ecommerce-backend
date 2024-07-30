package ecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImagesRequestDto {
    @NotEmpty
    @Pattern(regexp = "^(http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?$",
            message = "Invalid URL format")
    private String url;
    @NotNull
    @Min(0)
    private Long product_id;
}
