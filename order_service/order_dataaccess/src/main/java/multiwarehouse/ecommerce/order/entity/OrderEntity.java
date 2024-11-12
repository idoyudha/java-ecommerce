package multiwarehouse.ecommerce.order.entity;

import jakarta.persistence.*;
import lombok.*;
import multiwarehouse.ecommerce.valueobject.CreatedAt;
import multiwarehouse.ecommerce.valueobject.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class OrderEntity {
    @Id
    private UUID id;
    private UUID userId;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private UUID paymentId;
    private BigDecimal totalPrice;
    private String note;
    private Instant createdAt;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private OrderAddressEntity address;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
