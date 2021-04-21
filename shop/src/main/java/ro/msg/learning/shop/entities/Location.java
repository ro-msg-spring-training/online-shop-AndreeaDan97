package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


@Entity @Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="location")
public class Location extends BaseEntity implements Serializable {
    private String name;

    @ManyToOne
    @JoinColumn(name="id_address", nullable = false)
    private Address address;
}
