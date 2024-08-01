package ecommerce.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AddressRequestDto {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "City cannot be empty")
    private String city;
    @NotEmpty(message = "District cannot be empty")
    private String district;
    @NotEmpty(message = "Address cannot be empty")
    private String address;
    @NotEmpty(message = "Zipcode cannot be empty")
    private String zipcode;
}
