package ro.msg.learning.shop.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_details")
public class OrderDetails implements Serializable {
    @EmbeddedId OrderDetailsId orderDetailsId;

    private int quantity;

    @ManyToOne
    @MapsId("id_order")
    @JoinColumn(name = "id_order", nullable = false)
    private Order orders;

    @ManyToOne
    @MapsId("id_product")
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;
}
