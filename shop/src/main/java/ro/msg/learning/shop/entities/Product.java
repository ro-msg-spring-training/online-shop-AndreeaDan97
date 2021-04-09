package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity implements Serializable {
    private String name;
    private String description;
    private long price;
    private double weight;
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "product_product_category", nullable = false)
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name="id_supplier", nullable=false)
    private Supplier supplier;
}
