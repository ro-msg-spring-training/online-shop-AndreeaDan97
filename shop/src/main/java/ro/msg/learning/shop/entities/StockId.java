package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockId implements Serializable {

    @Column(name="id_product", nullable=false)
    private int idProduct;

    @Column(name="id_location", nullable=false)
    private int idLocation;
}
