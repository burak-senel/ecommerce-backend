package ecommerce.mapper;

import ecommerce.dto.UserRequestDto;
import ecommerce.dto.UserResponseDto;
import ecommerce.entity.Role;
import ecommerce.entity.User;
import ecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {

    private final RoleRepository roleRepository;
    @Autowired
    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public User toEntity(UserRequestDto userRequestDto) {
        if (userRequestDto == null) {
            return null;
        }

        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());

        Role role = roleRepository.findById(userRequestDto.getRole_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid role ID: " + userRequestDto.getRole_id()));
        user.setRole(role);

        return user;
    }


    public UserResponseDto userToUserResponseDto(User user) {
        if (user == null) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());

        return userResponseDto;
    }
}
