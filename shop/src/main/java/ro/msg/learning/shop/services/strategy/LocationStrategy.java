package ro.msg.learning.shop.services.strategy;

import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.StockDto;

public interface LocationStrategy {

    StockDto getStock(OrderDetailsDto orderDetailsDto);
}

