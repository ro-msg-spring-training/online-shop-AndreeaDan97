package ro.msg.learning.shop.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.SupplierRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(SupplierRepository supplierRepository, ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        return args -> {};
    }
}
