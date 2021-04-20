package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.OrderDto;
import ro.msg.learning.shop.dtos.StockDto;
import ro.msg.learning.shop.dtos.builders.AddressBuilder;
import ro.msg.learning.shop.dtos.builders.OrderBuilder;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.*;
import ro.msg.learning.shop.services.strategy.LocationStrategy;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final LocationStrategy locationStrategy;
    private final LocationRepository locationRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    /**
     *
     * @param orderDto
     * @return a list of all the OrderDetails, for each product found in OrderDto
     */
    public List<OrderDetails> createOrder(OrderDto orderDto) {
        log.info("Entering the createOrder(orderDto) in OrderService...");

        List<OrderDetails> list= new ArrayList<OrderDetails>();
        for(OrderDetailsDto orderDetailsDto : orderDto.getOrderDetailsDtoSet()) {
            StockDto stockDto = locationStrategy.getStock(orderDetailsDto);
            Order order = OrderBuilder.toEntity(orderDto);
            Location location = locationRepository.findById(stockDto.getStockId().getIdLocation()).get();
            Address address = AddressBuilder.toEntity(orderDto.getAddressDto());
            Customer customer = new Customer("def","default","default","default","default");

            Address searchAddress=addressRepository.findByCountryAndCityAndCountyAndStreet(address.getCountry(), address.getCity(), address.getCounty(), address.getStreet());
            if(searchAddress!=null){
                order.setAddress(searchAddress);
            }else{
                addressRepository.save(address);
                order.setAddress(address);
            }

            Customer searchCustomer = customerRepository.findByFirstNameAndLastNameAndUsernameAndEmailAndPassword(customer.getFirstName(), customer.getLastName(), customer.getUsername(), customer.getEmail(), customer.getPassword());
            if(searchCustomer!=null){
                order.setCustomer(searchCustomer);
            }else{
                customerRepository.save(customer);
                order.setCustomer(customer);
            }
            order.setLocation(location);
            orderRepository.save(order);

            Product product = productRepository.findById(orderDetailsDto.getIdProduct()).get();
            OrderDetails orderDetails = new OrderDetails();
            OrderDetailsId orderDetailsId = new OrderDetailsId();
            orderDetailsId.setIdOrder(order.getId());
            orderDetailsId.setIdProduct(product.getId());
            orderDetails.setOrderDetailsId(orderDetailsId);
            orderDetails.setOrders(order);
            orderDetails.setProduct(product);
            orderDetails.setQuantity(orderDetailsDto.getQuantity());

            orderDetailsRepository.save(orderDetails);
            list.add(orderDetails);
        }
        return list;
    }
}
