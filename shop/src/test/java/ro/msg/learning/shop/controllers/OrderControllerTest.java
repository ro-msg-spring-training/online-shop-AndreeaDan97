package ro.msg.learning.shop.controllers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.OrderDto;
import ro.msg.learning.shop.dtos.builders.AddressBuilder;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addOrderSuccessfully() {
        Address a = new Address("address2", "a", "a", "a");
        Supplier s= new Supplier("s");
        ProductCategory pc = new ProductCategory("pc", "pc");
        Product p = new Product("product1","p",10,10,"p",pc,s);
        Location l = new Location("location1", a);

        addressRepository.save(a);
        productCategoryRepository.save(pc);
        supplierRepository.save(s);
        productRepository.save(p);
        locationRepository.save(l);
        Product product = productRepository.findByName("product1");
        Location location = locationRepository.findByName("location1");
        StockId si = new StockId(product.getId(),location.getId());
        Stock stock = new Stock(si, 5000, p, l);
        stockRepository.save(stock);

        Set<OrderDetailsDto> set = new HashSet<OrderDetailsDto>();
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        orderDetailsDto.setQuantity(100);
        orderDetailsDto.setIdProduct(product.getId());

        OrderDetailsDto orderDetailsDto2 = new OrderDetailsDto();
        orderDetailsDto2.setQuantity(1000);
        orderDetailsDto2.setIdProduct(product.getId());

        set.add(orderDetailsDto);
        set.add(orderDetailsDto2);

        OrderDto orderDto = new OrderDto();
        orderDto.setAddressDto(AddressBuilder.toDto(a));
        LocalDate localDate = LocalDate.now();
        orderDto.setTimestamp(localDate);
        orderDto.setOrderDetailsDtoSet(set);

        ResponseEntity<List<OrderDetails>> response = orderController.addOrder(orderDto);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void unableToAddOrderDueToInsufficientStock() {
        Address a = new Address("address1", "a", "a", "a");
        Supplier s = new Supplier("s2");
        ProductCategory pc = new ProductCategory("pc2", "pc2");
        Product p = new Product("product2", "p", 10, 10, "p", pc, s);
        Location l = new Location("location2", a);


        addressRepository.save(a);
        productCategoryRepository.save(pc);
        supplierRepository.save(s);
        productRepository.save(p);
        locationRepository.save(l);
        Product product = productRepository.findByName("product2");
        Location location = locationRepository.findByName("location2");
        StockId si = new StockId(product.getId(), location.getId());
        Stock stock = new Stock(si, 10000, p, l);
        stockRepository.save(stock);

        Set<OrderDetailsDto> set = new HashSet<OrderDetailsDto>();
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        orderDetailsDto.setQuantity(6000);
        orderDetailsDto.setIdProduct(product.getId());

        OrderDetailsDto orderDetailsDto2 = new OrderDetailsDto();
        orderDetailsDto2.setQuantity(8000);
        orderDetailsDto2.setIdProduct(product.getId());
        set.add(orderDetailsDto);
        set.add(orderDetailsDto2);

        OrderDto orderDto = new OrderDto();
        orderDto.setAddressDto(AddressBuilder.toDto(a));
        LocalDate localDate = LocalDate.now();
        orderDto.setTimestamp(localDate);
        orderDto.setOrderDetailsDtoSet(set);

        Exception exception = assertThrows(RuntimeException.class, () ->
                orderController.addOrder(orderDto));
        String expectedMessage = "Insufficient stock!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}