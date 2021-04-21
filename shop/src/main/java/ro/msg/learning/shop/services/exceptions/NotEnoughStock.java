package ro.msg.learning.shop.services.exceptions;

public class NotEnoughStock extends RuntimeException{
    public NotEnoughStock(int id){
        super("Not enough stock for the product with id = "+id+"!");
    }
}
