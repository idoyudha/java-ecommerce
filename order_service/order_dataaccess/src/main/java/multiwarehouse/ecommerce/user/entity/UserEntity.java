package multiwarehouse.ecommerce.user.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_user_m_view", schema = "user")
public class UserEntity {
    @Id
    private UUID id;
}
