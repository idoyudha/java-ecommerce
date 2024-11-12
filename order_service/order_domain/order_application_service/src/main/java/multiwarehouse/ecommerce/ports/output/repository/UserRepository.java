package multiwarehouse.ecommerce.ports.output.repository;

import multiwarehouse.ecommerce.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findUser(UUID userId);
}
