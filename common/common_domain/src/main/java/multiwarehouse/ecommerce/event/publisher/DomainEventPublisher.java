package multiwarehouse.ecommerce.event.publisher;

import multiwarehouse.ecommerce.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
