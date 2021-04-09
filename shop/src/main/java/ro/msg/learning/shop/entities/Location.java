package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity @Data @EqualsAndHashCode(callSuper = true)
@Table(name="location")
public class Location extends BaseEntity implements Serializable {
    private String name;
    private String address_country;
    private String address_city;
    private String address_county;
    private String address_street;
}
