package multiwarehouse.ecommerce.event;

import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class OrderFailedEvent extends OrderEvent {
    private final DomainEventPublisher<OrderFailedEvent> orderFailedEventDomainEventPublisher;

    public OrderFailedEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderFailedEvent> orderFailedEventDomainEventPublisher) {
        super(order, createdAt);
        this.orderFailedEventDomainEventPublisher = orderFailedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        orderFailedEventDomainEventPublisher.publish(this);
    }
}
