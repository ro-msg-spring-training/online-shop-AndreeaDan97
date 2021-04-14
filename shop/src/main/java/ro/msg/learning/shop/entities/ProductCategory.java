package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_category")
public class ProductCategory extends BaseEntity implements Serializable {

    @Column(name="name", unique = true)
    private String name;
    private String description;
}
