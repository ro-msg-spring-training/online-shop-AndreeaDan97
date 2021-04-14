package ro.msg.learning.shop.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.entities.StockId;

public interface StockRepository extends JpaRepository<Stock, StockId> {
    @Query("SELECT s FROM Stock s WHERE s.product.id = :id AND s.quantity = (SELECT MAX(s.quantity) FROM Stock s)")
    Page<Stock> retrieveFirstMaxQuantityByProductId(@Param("id") int id, Pageable pageable);
}
