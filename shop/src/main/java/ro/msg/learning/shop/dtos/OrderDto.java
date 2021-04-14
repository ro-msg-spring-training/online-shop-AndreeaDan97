package ro.msg.learning.shop.dtos;

import lombok.Data;
import ro.msg.learning.shop.entities.Address;
import ro.msg.learning.shop.entities.BaseEntity;
import ro.msg.learning.shop.services.strategy.LocationStrategy;

import java.time.LocalDate;
import java.util.Set;

@Data
public class OrderDto extends BaseEntity {
    private LocalDate timestamp;
    private AddressDto addressDto;
    private Set<OrderDetailsDto> orderDetailsDtoSet;
}
