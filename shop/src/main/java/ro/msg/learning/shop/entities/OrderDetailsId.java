package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable @NoArgsConstructor @EqualsAndHashCode
@Data
public class OrderDetailsId implements Serializable {
    @Column(name="id_order", nullable=false)
    private int idOrder;

    @Column(name="id_product", nullable = false)
    private int idProduct;
}
