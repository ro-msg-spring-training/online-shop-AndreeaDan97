package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dtos.OrderDetailsDto;
import ro.msg.learning.shop.dtos.OrderDto;
import ro.msg.learning.shop.dtos.ProductDto;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.entities.OrderDetails;
import ro.msg.learning.shop.services.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value="/insert")
    public ResponseEntity<List<OrderDetails>> addOrder(@RequestBody OrderDto orderDto) {
        log.info("Entering the addOrder(orderDto) method in OrderController...");
        List<OrderDetails> orderDetails = orderService.createOrder(orderDto);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }
}
