package ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {
    private Long id;
    private String title;
    private String city;
    private String district;
    private String address;
    private String zipcode;
    private List<UserResponseDto> users;

}
