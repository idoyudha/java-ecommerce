package multiwarehouse.ecommerce.exeception;

import multiwarehouse.ecommerce.exception.DomainException;

public class OrderNotFoundException extends DomainException {
    public OrderNotFoundException(String message) {
        super(message);
    }
    public OrderNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
