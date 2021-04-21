package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class Product extends BaseEntity implements Serializable {

    @Column(name="name")
    private String name;
    private String description;
    private long price;
    private double weight;
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "id_product_category", nullable = false)
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name="id_supplier", nullable=false)
    private Supplier supplier;
}
