package multiwarehouse.ecommerce;

import lombok.extern.slf4j.Slf4j;
import multiwarehouse.ecommerce.dto.create.OrderItem;
import multiwarehouse.ecommerce.ports.output.repository.OrderItemRepository;
import multiwarehouse.ecommerce.valueobject.OrderItemId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrderItemUpdateHelper {
    private final OrderItemRepository orderItemRepository;

    public OrderItemUpdateHelper(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    List<OrderItem> findOrderItem(OrderItemId orderItemId) {
        Optional<List<OrderItem>> orderItemResponse = orderItemRepository.findById(orderItemId);
        if (orderItemResponse.isEmpty()) {
            log.error("Order item not found");
            throw new RuntimeException("Order item not found");
        }
        return orderItemResponse.get();
    }
}
