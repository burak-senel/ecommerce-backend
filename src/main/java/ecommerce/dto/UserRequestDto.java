package ecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    @NotEmpty(message="name cannot empty or null")
    @Size(min=3, message = "name size have to min 3 char.")
    private String name;
    @NotEmpty(message="surname cannot empty or null")
    @Size(min=3, message = "surname size have to min 3 char.")
    private String surname;
    @NotEmpty(message="email cannot empty or null")
    @Email(message="Wrong e-mail format")
    private String email;
    @NotEmpty(message="password cannot empty or null")
    @Size(min=8, message = "name size have to min 8 cha.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase and one lowercase letter, one digit, one special character, and must not contain any spaces or tabs."
    )
    private String password;
    @NotNull
    private Long role_id;
}
