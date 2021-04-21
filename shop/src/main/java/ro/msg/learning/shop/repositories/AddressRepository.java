package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByCountryAndCityAndCountyAndStreet(String country, String county, String city, String street);
}
