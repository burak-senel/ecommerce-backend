package ecommerce.service;

import ecommerce.entity.Address;
import ecommerce.exceptions.Exception;
import ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findAddressByID(Long id) {
        return addressRepository.findAddressByID(id).orElseThrow(() -> new Exception("hata", HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<Address> getAllAddress() {
        return List.of();
    }

    @Override
    public String saveAddress(Address address) {
        return "";
    }
}
