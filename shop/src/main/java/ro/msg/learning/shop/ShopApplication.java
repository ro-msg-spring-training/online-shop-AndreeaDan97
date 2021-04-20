package ro.msg.learning.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ro.msg.learning.shop.entities.Customer;
import ro.msg.learning.shop.services.OrderService;
import ro.msg.learning.shop.utils.StrategyType;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShopApplication.class, args);
		System.out.println("Online-shop application is working...");
		System.out.println(StrategyType.SINGLE);
		System.out.println(new BCryptPasswordEncoder().encode("default"));
	}
}
