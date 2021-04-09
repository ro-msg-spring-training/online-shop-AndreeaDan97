package ro.msg.learning.shop.entities;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable @NoArgsConstructor @EqualsAndHashCode
public class StockId implements Serializable {
    private int id_product;
    private int id_location;
}
