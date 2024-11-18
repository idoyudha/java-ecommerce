package multiwarehouse.ecommerce.dto.get;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import multiwarehouse.ecommerce.valueobject.ReferenceId;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class GetPaymentByRefIdQuery {
    @NotNull
    private final UUID referenceId;
}
