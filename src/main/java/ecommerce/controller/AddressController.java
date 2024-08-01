package ecommerce.controller;

import ecommerce.dto.AddressRequestDto;
import ecommerce.dto.AddressResponseDto;
import ecommerce.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public AddressResponseDto saveAddress(@Valid @RequestBody AddressRequestDto addressRequestDto, Principal principal) {
        String userMail = principal.getName(); // Get the email of the logged-in user
        return addressService.saveAddress(addressRequestDto, userMail);
    }
    @GetMapping("/{id}")
    public AddressResponseDto findAddressById(@PathVariable Long id) {
        return addressService.findAddressByID(id);
    }

    @GetMapping
    public List<AddressResponseDto> getAllAddresses() {
        return addressService.getAllAddress();
    }

    @PutMapping("/{id}")
    public AddressResponseDto updateAddress(@PathVariable Long id, @Valid @RequestBody AddressRequestDto addressRequestDto) {
        return addressService.updateAddress(id, addressRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
