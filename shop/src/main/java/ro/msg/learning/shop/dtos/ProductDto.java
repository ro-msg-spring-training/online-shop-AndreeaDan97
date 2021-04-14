package ro.msg.learning.shop.dtos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ro.msg.learning.shop.entities.BaseEntity;
import ro.msg.learning.shop.entities.ProductCategory;

@Data
public class ProductDto extends BaseEntity {
    private String name;
    private String description;
    private long price;
    private double weight;
    private String imageURL;
    private String nameOfCategory;
    private String descriptionOfCategory;
    private String nameOfSupplier;
}
