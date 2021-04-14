package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity @Data @EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Order extends BaseEntity implements Serializable {
    private LocalDate creation_date;

    @ManyToOne
    @JoinColumn(name="id_customer", nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="id_shipped_from", nullable=false)
    private Location location;

    @ManyToOne
    @JoinColumn(name="id_address", nullable = false)
    private Address address;

}
