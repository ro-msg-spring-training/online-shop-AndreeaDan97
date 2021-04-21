package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer extends BaseEntity implements Serializable {

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="username", unique = true)
    private String username;
    private String password;
    private String email;
}
