package multiwarehouse.ecommerce.event;

import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent {
    private final DomainEventPublisher<OrderPaidEvent> OrderPaidEventDomainEventPublisher;

    public OrderPaidEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderPaidEvent> OrderPaidEventDomainEventPublisher) {
        super(order, createdAt);
        this.OrderPaidEventDomainEventPublisher = OrderPaidEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        OrderPaidEventDomainEventPublisher.publish(this);
    }
}
