package multiwarehouse.ecommerce.order.mapper;

import multiwarehouse.ecommerce.entity.Order;
import multiwarehouse.ecommerce.entity.OrderItem;
import multiwarehouse.ecommerce.entity.Product;
import multiwarehouse.ecommerce.order.entity.OrderAddressEntity;
import multiwarehouse.ecommerce.order.entity.OrderEntity;
import multiwarehouse.ecommerce.order.entity.OrderItemEntity;
import multiwarehouse.ecommerce.valueobject.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDataAccessMapper {
    public OrderEntity orderToOrderEntity(Order order) {
        return OrderEntity.builder()
                .id(order.getId().getValue())
                .userId(order.getUserId().getValue())
                .totalPrice(order.getTotalPrice().getAmount())
                .orderStatus(order.getOrderStatus())
                .address(addressToOrderAddressEntity(order.getAddress()))
                .items(orderItemsToOrderItemEntities(order.getOrderItems()))
                .build();
    }

    public Order orderEntityToOrder(OrderEntity orderEntity) {
        return Order.builder()
                .orderId(new OrderId(orderEntity.getId()))
                .userId(new UserId(orderEntity.getUserId()))
                .address(orderAddressEntityToAddress(orderEntity.getAddress()))
                .totalPrice(new Money(orderEntity.getTotalPrice()))
                .orderItems(orderItemEntitiesToOrderItems(orderEntity.getItems()))
                .build();
    }

    private List<OrderItem> orderItemEntitiesToOrderItems(List<OrderItemEntity> orderItemEntities) {
        return orderItemEntities.stream()
                .map(orderItemEntity -> OrderItem.builder()
                        .orderItemId(new OrderItemId(orderItemEntity.getId()))
                        .product(new Product(new ProductId(orderItemEntity.getProductId())))
                        .quantity(orderItemEntity.getQuantity())
                        .price(new Money(orderItemEntity.getPrice()))
                        .subTotal(new Money(orderItemEntity.getSubTotal()))
                        .build())
                .toList();
    }

    private List<OrderItemEntity> orderItemsToOrderItemEntities(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem -> OrderItemEntity.builder()
                        .id(orderItem.getId().getValue())
                        .productId(orderItem.getProduct().getId().getValue())
                        .quantity(orderItem.getQuantity())
                        .price(orderItem.getPrice().getAmount())
                        .subTotal(orderItem.getSubTotal().getAmount())
                        .build())
                .toList();
    }

    private Address orderAddressEntityToAddress(OrderAddressEntity orderAddressEntity) {
        return new Address(
                orderAddressEntity.getId(),
                orderAddressEntity.getAddress(),
                orderAddressEntity.getCity(),
                orderAddressEntity.getState(),
                orderAddressEntity.getCountry(),
                orderAddressEntity.getZipCode()
        );
    }

    private OrderAddressEntity addressToOrderAddressEntity(Address address) {
        return OrderAddressEntity.builder()
                .id(address.getId())
                .address(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .build();
    }
}