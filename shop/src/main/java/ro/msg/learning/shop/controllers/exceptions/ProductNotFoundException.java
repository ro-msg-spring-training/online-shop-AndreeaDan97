package ro.msg.learning.shop.controllers.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(int id){
        super("Product with id = "+id+" was not found!");
    }
    public ProductNotFoundException(String name){ super("Product with name = "+name+" was not found!");}
}
