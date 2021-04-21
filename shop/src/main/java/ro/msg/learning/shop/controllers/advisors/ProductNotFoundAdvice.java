package ro.msg.learning.shop.controllers.advisors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ro.msg.learning.shop.controllers.exceptions.ProductNotFoundException;

@ControllerAdvice
@Slf4j
public class ProductNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFoundException(ProductNotFoundException e){
        log.info("Entering the productNotFoundException(e) method in ProductNotFoundAdvice...");
        return e.getMessage();
    }
}
