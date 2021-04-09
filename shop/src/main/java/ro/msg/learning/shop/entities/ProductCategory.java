package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@Table(name="product_category")
public class ProductCategory extends BaseEntity implements Serializable {
    private String name;
    private String description;
}
