package ecommerce.service;

import ecommerce.dto.UserRequestDto;
import ecommerce.entity.User;

public interface UserService {
    User findByEmail(String email);
    User findById(Long id);
    User registerUser(UserRequestDto userRequestDto);

}
