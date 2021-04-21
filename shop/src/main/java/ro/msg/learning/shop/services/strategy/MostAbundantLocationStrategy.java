package ro.msg.learning.shop.services.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.StockDto;
import ro.msg.learning.shop.dtos.builders.StockBuilder;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.services.exceptions.NotEnoughStock;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class MostAbundantLocationStrategy implements LocationStrategy {

    private final StockRepository stockRepository;

    /**
     *
     * @param orderDetailsDto
     * @return the stockDto corresponding to the stock we've updated
     */
    @Override
    public StockDto getStock(OrderDetailsDto orderDetailsDto) {
        log.info("Entering the getStock(orderDetailsDto) method in MostAbundantLocationStrategy...");
        log.info("Currently at product " + orderDetailsDto.getIdProduct());

        System.out.print(orderDetailsDto.getIdProduct());
        int idProduct = orderDetailsDto.getIdProduct();
        int quantity = orderDetailsDto.getQuantity();
        int newQuantity = -1;
        StockDto stockDto = new StockDto();
        List<Stock> foundStocks = stockRepository.retrieveFirstMaxQuantityByProductId(idProduct);
        Stock foundStock = foundStocks.get(0);
        if (foundStock.getQuantity() >= quantity) {
            newQuantity = foundStock.getQuantity() - quantity;
            stockDto = StockBuilder.toStockDto(foundStock);
        }

        if (newQuantity != -1) {
            stockDto.setQuantity(newQuantity);
            Stock updatedStock = StockBuilder.toStockEntity(stockDto);
            stockRepository.save(updatedStock);
        } else {
            throw new NotEnoughStock(idProduct);
        }

        return stockDto;
    }
}
