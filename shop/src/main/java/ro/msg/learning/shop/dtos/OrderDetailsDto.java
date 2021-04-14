package ro.msg.learning.shop.dtos;

import lombok.Data;

@Data
public class OrderDetailsDto {
    private int idProduct;
    private int quantity;
}
