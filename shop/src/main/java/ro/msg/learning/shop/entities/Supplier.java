package ro.msg.learning.shop.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="supplier")
public class Supplier extends BaseEntity implements Serializable {

    @Column(name="name", unique = true)
    private @NotNull String name;
}
