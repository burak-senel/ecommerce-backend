package ecommerce.service;

import ecommerce.entity.Address;

import java.util.List;

public interface AddressService {
    Address findAddressByID(Long id);
    List<Address> getAllAddress();
    String saveAddress(Address address);
}
