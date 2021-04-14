package ro.msg.learning.shop.dtos;

import lombok.Data;
import ro.msg.learning.shop.entities.BaseEntity;

@Data
public class AddressDto extends BaseEntity {
    private String country;
    private String city;
    private String county;
    private String street;
}
