package ecommerce.service;

import ecommerce.dto.AddressRequestDto;
import ecommerce.dto.AddressResponseDto;
import ecommerce.entity.Address;

import java.util.List;

public interface AddressService {
    AddressResponseDto findAddressByID(Long id);
    List<AddressResponseDto> getAllAddress();
    AddressResponseDto saveAddress(AddressRequestDto addressRequestDto);
}
