package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@Table(name="customer")
public class Customer extends BaseEntity implements Serializable {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name="customer", nullable=false)
    private Customer customer;

}
