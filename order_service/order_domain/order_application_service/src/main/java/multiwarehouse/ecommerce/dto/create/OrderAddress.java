package multiwarehouse.ecommerce.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@AllArgsConstructor
@Builder
@Jacksonized
public class OrderAddress {
    @NotNull
    private final String street;
    @NotNull
    private final String city;
    @NotNull
    private final String state;
    @NotNull
    private final String country;
    @NotNull
    private final String zipCode;
}
