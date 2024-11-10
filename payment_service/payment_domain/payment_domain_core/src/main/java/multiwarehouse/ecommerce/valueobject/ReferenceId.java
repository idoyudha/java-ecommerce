package multiwarehouse.ecommerce.valueobject;

import java.util.UUID;

public class ReferenceId extends BaseId<UUID> {
    public ReferenceId(UUID value) {
        super(value);
    }
}
