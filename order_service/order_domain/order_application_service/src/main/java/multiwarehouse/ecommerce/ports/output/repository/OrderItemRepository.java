package multiwarehouse.ecommerce.ports.output.repository;

import multiwarehouse.ecommerce.dto.create.OrderItem;
import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.valueobject.OrderItemId;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository {
    public OrderItem save(OrderItem orderItem);
    public Optional<List<OrderItem>> findById(OrderItemId orderItemId);
    public Order calculateFinalPrice(Order order);
}
