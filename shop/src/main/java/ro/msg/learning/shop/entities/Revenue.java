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
import java.time.LocalDate;

@Entity @Data @EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="revenue")
public class Revenue extends  BaseEntity implements Serializable {
    private LocalDate date;
    private long sum;

    @ManyToOne
    @JoinColumn(name = "id_location", nullable = false)
    private Location location;
}
