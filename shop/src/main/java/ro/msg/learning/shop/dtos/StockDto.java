package ro.msg.learning.shop.dtos;

import lombok.Data;
import ro.msg.learning.shop.entities.StockId;

@Data
public class StockDto {
    StockId stockId;
    int quantity;
}
