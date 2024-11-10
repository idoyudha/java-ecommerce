package multiwarehouse.ecommerce.valueobject;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CreatedAt extends BaseTimeStamp<ZonedDateTime> {
    public CreatedAt(ZonedDateTime value) {
        super(value);
    }

    public static CreatedAt now(ZoneId zoneId) {
        return new CreatedAt(ZonedDateTime.now(zoneId));
    }
}
