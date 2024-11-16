package multiwarehouse.ecommerce.order.adapter;

import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.order.mapper.OrderDataAccessMapper;
import multiwarehouse.ecommerce.order.repository.OrderJpaRepository;
import multiwarehouse.ecommerce.ports.output.repository.OrderRepository;
import multiwarehouse.ecommerce.valueobject.OrderId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl (OrderJpaRepository orderJpaRepository, OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJpaRepository.save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return orderJpaRepository.findById(orderId.getValue()).map(orderDataAccessMapper::orderEntityToOrder);
    }
}
