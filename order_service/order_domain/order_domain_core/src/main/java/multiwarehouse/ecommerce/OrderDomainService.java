package multiwarehouse.ecommerce;

import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.event.OrderFailedEvent;
import multiwarehouse.ecommerce.event.OrderPaidEvent;
import multiwarehouse.ecommerce.event.publisher.DomainEventPublisher;

public interface OrderDomainService {
    OrderPaidEvent payOrder(Order order, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher);

    OrderFailedEvent failOrder(Order order, DomainEventPublisher<OrderFailedEvent> orderFailedEventDomainEventPublisher);
}
