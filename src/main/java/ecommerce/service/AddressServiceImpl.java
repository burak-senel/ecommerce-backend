package ecommerce.service;

import ecommerce.dto.AddressRequestDto;
import ecommerce.dto.AddressResponseDto;
import ecommerce.entity.Address;
import ecommerce.entity.User;
import ecommerce.exceptions.CommerceException;
import ecommerce.mapper.AddressMapper;
import ecommerce.repository.AddressRepository;
import ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AddressResponseDto findAddressByID(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            return AddressMapper.addressToAddressResponseDto(optionalAddress.get());
        }
        throw new CommerceException("Address is not found, id:" + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<AddressResponseDto> getAllAddress() {
        return AddressMapper.addressListToAddressResponseList(addressRepository.findAll());
    }

    @Override
    public AddressResponseDto saveAddress(AddressRequestDto addressRequestDto, String userEmail) {
        // Find the user by email
        User user = userRepository.findUserByEmail(userEmail)
                .orElseThrow(() -> new CommerceException("User not found with email: " + userEmail, HttpStatus.NOT_FOUND));

        Address address = AddressMapper.addressRequestToAddress(addressRequestDto);

        address.setUsers(List.of(user));

        Address savedAddress = addressRepository.save(address);

        return AddressMapper.addressToAddressResponseDto(savedAddress);
    }
    @Override
    public AddressResponseDto updateAddress(Long id, AddressRequestDto addressRequestDto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new CommerceException("Address not found with id: " + id, HttpStatus.NOT_FOUND));

        address.setTitle(addressRequestDto.getTitle());
        address.setCity(addressRequestDto.getCity());
        address.setDistrict(addressRequestDto.getDistrict());
        address.setAddress(addressRequestDto.getAddress());
        address.setZipcode(addressRequestDto.getZipcode());

        Address updatedAddress = addressRepository.save(address);

        return AddressMapper.addressToAddressResponseDto(updatedAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new CommerceException("Address not found with id: " + id, HttpStatus.NOT_FOUND));
        addressRepository.delete(address);
    }
}
