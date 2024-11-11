package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.Address;
import multiwarehouse.ecommerce.valueobject.Money;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateOrderCommand {
    @NotNull
    private final UUID userId;
    @NotNull
    private final Address address;
    @NotNull
    private final Money totalPrice;
    @NotNull
    private final List<OrderItem> orderItems;
}
