package ro.msg.learning.shop.dtos.builders;

import ro.msg.learning.shop.dtos.StockDto;
import ro.msg.learning.shop.entities.Stock;

public class StockBuilder {

    public static StockDto toStockDto(Stock stock){
        StockDto stockDto = new StockDto();
        stockDto.setStockId(stock.getStockId());
        stockDto.setQuantity(stock.getQuantity());
        return stockDto;
    }

    public static Stock toStockEntity(StockDto stockDto){
        Stock stock = new Stock();
        stock.setStockId(stockDto.getStockId());
        stock.setQuantity(stockDto.getQuantity());
        return stock;
    }
}
