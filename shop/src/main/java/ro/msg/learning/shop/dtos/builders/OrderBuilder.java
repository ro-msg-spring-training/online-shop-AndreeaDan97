package ro.msg.learning.shop.dtos.builders;

import lombok.extern.slf4j.Slf4j;
import ro.msg.learning.shop.dtos.OrderDto;
import ro.msg.learning.shop.entities.Address;
import ro.msg.learning.shop.entities.Order;

@Slf4j
public class OrderBuilder {

    public static Order toEntity(OrderDto orderDto){
        Order order = new Order();
        order.setCreation_date(orderDto.getTimestamp());
        return order;
    }
}
