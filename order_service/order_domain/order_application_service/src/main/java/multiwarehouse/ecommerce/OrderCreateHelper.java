package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.dto.create.CreateOrderCommand;
import multiwarehouse.ecommerce.dto.create.CreateOrderResponse;
import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.mapper.OrderDataMapper;
import multiwarehouse.ecommerce.ports.output.repository.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrderCreateHelper {
    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final OrderDataMapper orderDataMapper;

    public OrderCreateHelper(OrderDomainService orderDomainService, OrderRepository orderRepository, OrderDataMapper orderDataMapper) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        log.info("create order: {}", createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        log.info("order mapped: {}", order);
        orderDomainService.initializeOrder(order);
        log.info("order initialized: {}", order);
        saveOrder(order);
        log.info("order saved: {}", order);
        return orderDataMapper.orderToCreateOrderResponse(order);
    }

    private void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
