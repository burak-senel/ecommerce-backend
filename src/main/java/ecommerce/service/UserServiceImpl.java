package ecommerce.service;

import ecommerce.dto.UserRequestDto;
import ecommerce.entity.Role;
import ecommerce.entity.User;
import ecommerce.exceptions.CommerceException;
import ecommerce.mapper.UserMapper;
import ecommerce.repository.RoleRepository;
import ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow( () -> new CommerceException("User not exist. Email: " + email, HttpStatus.BAD_REQUEST ));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new CommerceException("User not exist. Id: "+id,HttpStatus.BAD_REQUEST));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User credentials are not valid"));
    }
    @Override
    public User registerUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new CommerceException("Email already in use", HttpStatus.BAD_REQUEST);
        }

        Role role = roleRepository.findById(userRequestDto.getRole_id())
                .orElseThrow(() -> new CommerceException("Role not found", HttpStatus.NOT_FOUND));

        User user = userMapper.userRequestDtoToUser(userRequestDto);
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setRole(role);

        return userRepository.save(user);
    }

}
