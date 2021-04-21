package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entities.OrderDetails;
import ro.msg.learning.shop.entities.OrderDetailsId;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsId> {
}
