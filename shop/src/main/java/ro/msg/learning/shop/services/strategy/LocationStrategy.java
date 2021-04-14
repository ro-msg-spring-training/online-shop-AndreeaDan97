package ro.msg.learning.shop.services.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.StockDto;

@Component
public interface LocationStrategy {

    StockDto getStock(OrderDetailsDto orderDetailsDto);
}

