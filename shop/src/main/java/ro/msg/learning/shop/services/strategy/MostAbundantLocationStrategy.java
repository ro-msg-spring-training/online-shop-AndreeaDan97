package ro.msg.learning.shop.services.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.StockDto;
import ro.msg.learning.shop.dtos.builders.StockBuilder;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.StockRepository;

@Slf4j
public class MostAbundantLocationStrategy implements LocationStrategy {

    @Autowired
    private StockRepository stockRepository;

    /**
     *
     * @param orderDetailsDto
     * @return the stockDto corresponding to the stock we've updated
     */
    @Override
    public StockDto getStock(OrderDetailsDto orderDetailsDto) {
        log.info("Entering the getStock(orderDetailsDto) method in MostAbundantLocationStrategy...");
        log.info("Currently at product "+orderDetailsDto.getIdProduct());

        int idProduct = orderDetailsDto.getIdProduct();
        int quantity = orderDetailsDto.getQuantity();
        int newQuantity = -1;
        StockDto stockDto = new StockDto();
        Stock foundStock = stockRepository.retrieveFirstMaxQuantityByProductId(idProduct, PageRequest.of(0,1)).getContent().get(0);
        if (foundStock.getQuantity() >= quantity) {
            newQuantity = foundStock.getQuantity() - quantity;
            stockDto = StockBuilder.toStockDto(foundStock);
        }

        if(newQuantity!=-1) {
            stockDto.setQuantity(newQuantity);
            Stock updatedStock = StockBuilder.toStockEntity(stockDto);
            stockRepository.save(updatedStock);
        }else{
            throw new RuntimeException("Insufficient stock!");
        }

        return stockDto;
    }
}
