package multiwarehouse.ecommerce.mapper;

import jakarta.validation.constraints.NotNull;
import multiwarehouse.ecommerce.dto.create.CreateOrderCommand;
import multiwarehouse.ecommerce.dto.create.CreateOrderResponse;
import multiwarehouse.ecommerce.dto.create.OrderAddress;
import multiwarehouse.ecommerce.dto.create.OrderItem;
import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.valueobject.Address;
import multiwarehouse.ecommerce.valueobject.Money;
import multiwarehouse.ecommerce.valueobject.ProductId;
import multiwarehouse.ecommerce.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OrderDataMapper {
    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .userId(new UserId(createOrderCommand.getUserId()))
                .address(orderAddressToAddress(createOrderCommand.getAddress()))
                .totalPrice(new Money(createOrderCommand.getTotalPrice()))
                .orderItems(orderItemToOrderItems(createOrderCommand.getOrderItems()))
                .build();
    }

    private List<multiwarehouse.ecommerce.entity.OrderItem> orderItemToOrderItems(@NotNull List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItem -> multiwarehouse.ecommerce.entity.OrderItem.builder()
                        .product(new multiwarehouse.ecommerce.entity.Product(new ProductId(OrderItem.getProductId())))
                        .quantity(OrderItem.getQuantity())
                        .price(new Money(OrderItem.getPrice()))
                        .subTotal(new Money(OrderItem.getSubtotal()))
                        .build())
                .toList();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order) {
        return new CreateOrderResponse(
                order.getId().getValue(),
                order.getOrderStatus(),
                order.getTotalPrice().getAmount(),
                order.getCreatedAt().getValue().toInstant()
        );
    }

    public Address orderAddressToAddress(OrderAddress orderAddress) {
        return new Address(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getCity(),
                orderAddress.getState(),
                orderAddress.getCountry(),
                orderAddress.getZipCode()
        );
    }
}
