package multiwarehouse.ecommerce;


import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.event.OrderFailedEvent;
import multiwarehouse.ecommerce.event.OrderPaidEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public void initializeOrder(Order order) {
        order.initializeOrder();
    }
    @Override
    public OrderPaidEvent payOrder(Order order, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher) {
        order.paid();
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of("UTC")), orderPaidEventDomainEventPublisher);
    }

    @Override
    public OrderFailedEvent failOrder(Order order, DomainEventPublisher<OrderFailedEvent> orderFailedEventDomainEventPublisher) {
        order.fail();
        return new OrderFailedEvent(order, ZonedDateTime.now(ZoneId.of("UTC")), orderFailedEventDomainEventPublisher);
    }
}
