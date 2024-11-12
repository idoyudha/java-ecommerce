package multiwarehouse.ecommerce.ports.output.repository;

import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.valueobject.OrderId;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(OrderId orderId);
}
