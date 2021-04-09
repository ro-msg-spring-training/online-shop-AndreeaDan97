package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity @Data @EqualsAndHashCode(callSuper = true)
@Table(name="orders")
public class Order extends BaseEntity implements Serializable {
    private Date creation_date;
    private String address_country;
    private String address_city;
    private String address_county;
    private String address_street;

    @ManyToOne
    @JoinColumn(name="id_customer", nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="id_shipped_from", nullable=false)
    private Location location;

}
