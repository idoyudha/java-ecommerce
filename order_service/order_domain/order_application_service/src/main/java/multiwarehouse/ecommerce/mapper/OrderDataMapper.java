package multiwarehouse.ecommerce.mapper;

import jakarta.validation.constraints.NotNull;
import multiwarehouse.ecommerce.dto.create.CreateOrderCommand;
import multiwarehouse.ecommerce.dto.create.CreateOrderResponse;
import multiwarehouse.ecommerce.dto.create.OrderItem;
import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.valueobject.Money;
import multiwarehouse.ecommerce.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDataMapper {
    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .userId(new UserId(createOrderCommand.getUserId()))
                .address(createOrderCommand.getAddress())
                .totalPrice(createOrderCommand.getTotalPrice())
                .orderItems(orderItemToOrderItems(createOrderCommand.getOrderItems()))
                .build();
    }

    private List<multiwarehouse.ecommerce.entity.OrderItem> orderItemToOrderItems(@NotNull List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItem -> multiwarehouse.ecommerce.entity.OrderItem.builder()
                        .product(new multiwarehouse.ecommerce.entity.Product(OrderItem.getProductId()))
                        .quantity(OrderItem.getQuantity())
                        .price(new Money(OrderItem.getPrice()))
                        .subTotal(new Money(OrderItem.getSubtotal()))
                        .build())
                .toList();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order) {
        return new CreateOrderResponse(order.getId(), order.getOrderStatus(), order.getTotalPrice(), order.getCreatedAt());
    }
}
