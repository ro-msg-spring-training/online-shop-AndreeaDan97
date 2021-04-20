package ro.msg.learning.shop.services.strategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.StockDto;
import ro.msg.learning.shop.dtos.builders.StockBuilder;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.services.exceptions.NotEnoughStock;

@Slf4j
@RequiredArgsConstructor
public class SingleLocationStrategy implements LocationStrategy {


    private final StockRepository stockRepository;

    /**
     *
     * @param orderDetailsDto
     * @return the stockDto corresponding to the stock we've updated
     */
    @Override
    public StockDto getStock(OrderDetailsDto orderDetailsDto) {
        log.info("Entering the getStock() method in SingleLocationStrategy...");
        log.info("Currently at product "+orderDetailsDto.getIdProduct());

        int idProduct = orderDetailsDto.getIdProduct();
        int quantity = orderDetailsDto.getQuantity();
        int newQuantity = -1;
        StockDto stockDto = new StockDto();
        for(Stock s: stockRepository.findAll()){
            if(s.getStockId().getIdProduct() == idProduct) {
                if (s.getQuantity() >= quantity) {
                    newQuantity = s.getQuantity() - quantity;
                    stockDto = StockBuilder.toStockDto(s);
                    break;
                }
            }
        }

        if(newQuantity!=-1) {
            stockDto.setQuantity(newQuantity);
            Stock updatedStock = StockBuilder.toStockEntity(stockDto);
            stockRepository.save(updatedStock);
        }else{
            throw new NotEnoughStock(idProduct);
        }

        return stockDto;
    }
}
