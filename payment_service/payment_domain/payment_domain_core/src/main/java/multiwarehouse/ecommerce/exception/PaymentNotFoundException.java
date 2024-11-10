package multiwarehouse.ecommerce.exception;

public class PaymentNotFoundException extends DomainException {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
