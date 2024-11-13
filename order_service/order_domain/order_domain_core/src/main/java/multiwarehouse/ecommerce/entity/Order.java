package multiwarehouse.ecommerce.entity;

import multiwarehouse.ecommerce.valueobject.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Order extends AggregateRoot<OrderId> {
    private final UserId userId;
    private final Address address;
    private final Money totalPrice;
    private final List<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private Payment payment;
    private CreatedAt createdAt;

    public void initializeOrder() {
        setId(new OrderId(UUID.randomUUID()));
        orderStatus = OrderStatus.PENDING;
        createdAt = new CreatedAt(ZonedDateTime.now());
        initializeOrderItems();
    }

    private void initializeOrderItems(){
        orderItems.forEach(orderItem -> orderItem.initializeOrderItem(getId(), new OrderItemId(UUID.randomUUID())));
    }

    public void paid() {
        if (orderStatus != OrderStatus.PENDING) {
            throw new IllegalStateException("Order is not pending");
        }
        orderStatus = OrderStatus.PAID;
    }

    public void fail() {
        if (orderStatus != OrderStatus.PENDING) {
            throw new IllegalStateException("Order is not pending");
        }
        orderStatus = OrderStatus.FAILED;
    }

    private Order(Builder builder) {
        super.setId(builder.orderId);
        userId = builder.userId;
        address = builder.address;
        totalPrice = builder.totalPrice;
        orderItems = builder.orderItems;
        orderStatus = builder.orderStatus;
        payment = builder.payment;
        createdAt = builder.createdAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UserId getUserId() {
        return userId;
    }

    public Address getAddress() {
        return address;
    }

    public Money getTotalPrice() {
        return totalPrice;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    public static final class Builder {
        private OrderId orderId;
        private UserId userId;
        private Address address;
        private Money totalPrice;
        private List<OrderItem> orderItems;
        private OrderStatus orderStatus;
        private Payment payment;
        private CreatedAt createdAt;

        private Builder() {
        }

        public Builder orderId(OrderId val) {
            orderId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder address(Address val) {
            address = val;
            return this;
        }

        public Builder totalPrice(Money val) {
            totalPrice = val;
            return this;
        }

        public Builder orderItems(List<OrderItem> val) {
            orderItems = val;
            return this;
        }

        public Builder orderStatus(OrderStatus val) {
            orderStatus = val;
            return this;
        }

        public Builder payment(Payment val) {
            payment = val;
            return this;
        }

        public Builder createdAt(CreatedAt val) {
            createdAt = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
