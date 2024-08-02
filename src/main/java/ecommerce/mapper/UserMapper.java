package ecommerce.mapper;

import ecommerce.dto.UserRequestDto;
import ecommerce.dto.UserResponseDto;
import ecommerce.entity.Role;
import ecommerce.entity.User;
import ecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final RoleRepository roleRepository;
    @Autowired
    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public User userRequestDtoToUser(UserRequestDto userRequestDto) {
        if (userRequestDto == null) {
            return null;
        }

        User user = new User();
        user.setName(userRequestDto.getName());
        user.setSurname(userRequestDto.getSurname());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }


    public UserResponseDto userToUserResponseDto(User user) {
        if (user == null) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setLastname(user.getSurname());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());

        return userResponseDto;
    }
}
