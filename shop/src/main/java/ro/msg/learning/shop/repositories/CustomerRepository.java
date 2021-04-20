package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByFirstNameAndLastNameAndUsernameAndEmailAndPassword(String firstName, String lastName, String username, String email, String password);

    Customer findByUsername(String username);
}
