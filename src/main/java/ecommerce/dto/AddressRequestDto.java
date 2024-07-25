package ecommerce.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
