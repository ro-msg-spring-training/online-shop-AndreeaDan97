package ro.msg.learning.shop.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {
    private @Id int id;
}