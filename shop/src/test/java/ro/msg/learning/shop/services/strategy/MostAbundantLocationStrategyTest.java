package ro.msg.learning.shop.services.strategy;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.StockDto;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.entities.StockId;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.services.exceptions.NotEnoughStock;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MostAbundantLocationStrategyTest {

    @Mock
    private StockRepository stockRepository;

    private MostAbundantLocationStrategy mostAbundantLocationStrategy;

    @BeforeAll
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        mostAbundantLocationStrategy = new MostAbundantLocationStrategy(stockRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStockWhenMultipleAvailableMax() {
        List<Stock> stocks = new ArrayList<>();

        Stock s1 = new Stock(new StockId(1,2),3000,null, null);
        Stock s2 = new Stock(new StockId(1,3), 3000, null, null);
        Stock s3 = new Stock(new StockId(1, 4), 3000, null, null);
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);

        when(stockRepository.retrieveFirstMaxQuantityByProductId(1)).thenReturn(stocks);
        when(stockRepository.save(any(Stock.class))).thenReturn(null);
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(1,500);
        System.out.print(orderDetailsDto.getIdProduct());
        StockDto stockDto = mostAbundantLocationStrategy.getStock(orderDetailsDto);
        assertEquals(2500, stockDto.getQuantity());
    }

    @Test
    void getStockWhenNoStockAvailableWithEnoughQuantity() {
        List<Stock> stocks = new ArrayList<>();

        Stock s1 = new Stock(new StockId(1,2),300,null, null);
        Stock s2 = new Stock(new StockId(1,3), 300, null, null);
        Stock s3 = new Stock(new StockId(1, 4), 300, null, null);
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);

        when(stockRepository.retrieveFirstMaxQuantityByProductId(1)).thenReturn(stocks);
        when(stockRepository.save(any(Stock.class))).thenReturn(null);
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(1,500);
        Exception exception = assertThrows(NotEnoughStock.class, () ->
                mostAbundantLocationStrategy.getStock(orderDetailsDto));
        String expectedMessage = "Not enough stock for the product with id = 1!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}