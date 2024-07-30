package ecommerce.service;

import ecommerce.entity.User;
import ecommerce.exceptions.CommerceException;
import ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow( () -> new CommerceException("User not exist. Email: " + email, HttpStatus.BAD_REQUEST ));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new CommerceException("User not exist. Id: "+id,HttpStatus.BAD_REQUEST));
    }
}
