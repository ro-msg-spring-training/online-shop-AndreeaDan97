package ro.msg.learning.shop.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@Table(name="revenue")
public class Revenue extends  BaseEntity implements Serializable {
    private Date date;
    private long sum;

    @ManyToOne
    @JoinColumn(name = "id_location", nullable = false)
    private Location location;
}
