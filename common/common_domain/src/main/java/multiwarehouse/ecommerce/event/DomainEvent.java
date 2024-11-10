package multiwarehouse.ecommerce.event;

public interface DomainEvent<T> {
    void fire();
}
