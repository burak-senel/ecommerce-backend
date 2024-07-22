package ecommerce.repository;

import ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query("SELECT a FROM Address a WHERE a.id=:id")
    Optional<Address> findAddressByID(Long id);

}
