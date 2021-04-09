package ro.msg.learning.shop.entities;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable @NoArgsConstructor @EqualsAndHashCode
public class OrderDetailsId implements Serializable {
    private int id_order;
    private int id_product;
}
