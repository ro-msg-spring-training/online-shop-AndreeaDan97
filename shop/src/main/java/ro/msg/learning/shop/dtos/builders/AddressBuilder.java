package ro.msg.learning.shop.dtos.builders;

import ro.msg.learning.shop.dtos.AddressDto;
import ro.msg.learning.shop.entities.Address;

public class AddressBuilder {

    public static Address toEntity(AddressDto addressDto){
        Address address= new Address();
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setCounty(addressDto.getCounty());
        address.setStreet(addressDto.getStreet());
        return address;
    }
}
