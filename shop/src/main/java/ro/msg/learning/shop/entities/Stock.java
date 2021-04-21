package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stock")
public class Stock implements Serializable {
    @EmbeddedId StockId stockId;
    private int quantity;

    @ManyToOne
    @MapsId("id_product")
    @JoinColumn(name="id_product", nullable=false)
    private Product product;

    @ManyToOne
    @MapsId("id_location")
    @JoinColumn(name="id_location", nullable=false)
    private Location location;
}
