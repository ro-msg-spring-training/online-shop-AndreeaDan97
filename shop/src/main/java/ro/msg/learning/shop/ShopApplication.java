package ro.msg.learning.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.msg.learning.shop.entities.Customer;
import ro.msg.learning.shop.services.OrderService;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
		System.out.println("Online-shop application is working...");
	}
}
