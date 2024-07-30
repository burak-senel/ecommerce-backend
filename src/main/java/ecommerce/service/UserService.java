package ecommerce.service;

import ecommerce.entity.User;

public interface UserService {
    User findByEmail(String email);
    User findById(Long id);


}
