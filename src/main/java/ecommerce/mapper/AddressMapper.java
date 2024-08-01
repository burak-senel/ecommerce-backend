package ecommerce.mapper;

import ecommerce.dto.AddressRequestDto;
import ecommerce.dto.AddressResponseDto;
import ecommerce.dto.UserResponseDto;
import ecommerce.entity.Address;
import ecommerce.entity.User;
import ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    private static UserMapper userMapper;
    private static UserService userService;

    @Autowired
    public AddressMapper(UserMapper userMapper,UserService userService) {
        AddressMapper.userMapper = userMapper;
        AddressMapper.userService =userService;
    }

    public static Address addressRequestToAddress(AddressRequestDto a)
    {
        Address res=new Address();
        res.setAddress(a.getAddress());
        res.setCity(a.getCity());
        res.setTitle(a.getTitle());
        res.setZipcode(a.getZipcode());
        res.setDistrict(a.getDistrict());

        return res;
    }
    public static AddressResponseDto addressToAddressResponseDto(Address a){
        AddressResponseDto res=new AddressResponseDto();
        res.setAddress(a.getAddress());
        res.setId(a.getId());
        res.setCity(a.getCity());
        res.setTitle(a.getTitle());
        res.setZipcode(a.getZipcode());
        res.setDistrict(a.getDistrict());
        return res;
    }
    public static List<AddressResponseDto> addressListToAddressResponseList(List<Address> all) {

        List<AddressResponseDto> responses = new ArrayList<>();

        for(Address a: all){
            AddressResponseDto res = addressToAddressResponseDto(a);
            responses.add(res);
        }

        return responses;
    }
}
