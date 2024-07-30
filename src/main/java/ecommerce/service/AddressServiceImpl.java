package ecommerce.service;

import ecommerce.dto.AddressRequestDto;
import ecommerce.dto.AddressResponseDto;
import ecommerce.entity.Address;
import ecommerce.exceptions.CommerceException;
import ecommerce.mapper.AddressMapper;
import ecommerce.repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;




    @Override
    public AddressResponseDto findAddressByID(Long id) {
        Optional<Address> optionalAddress=addressRepository.findById(id);
        if(optionalAddress.isPresent()){
            return AddressMapper.addressToAddressResponseDto(optionalAddress.get());
        }
        throw new CommerceException("Address is not found, id:"+ id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<AddressResponseDto> getAllAddress() {
        return List.of();
    }

    @Override
    public AddressResponseDto saveAddress(AddressRequestDto addressRequestDto) {
        return null;
    }
/*
    @Override
    public List<AddressResponseDto> getAllAddress() {
        return addressRepository.findAll().stream().map((address)-> AddressMapper.add)
    }

    @Override
    @Transactional
    public AddressResponseDto saveAddress(AddressRequestDto address) {
return s;
    }*/
}
