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

    public static AddressDto toDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setCounty(address.getCounty());
        addressDto.setStreet(address.getStreet());
        return addressDto;
    }
}
