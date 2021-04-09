package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@Table(name="supplier")
public class Supplier extends BaseEntity implements Serializable {
    private String name;
}
