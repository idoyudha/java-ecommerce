package multiwarehouse.ecommerce.user.adapter;

import multiwarehouse.ecommerce.entity.User;
import multiwarehouse.ecommerce.ports.output.repository.UserRepository;
import multiwarehouse.ecommerce.user.mapper.UserDataAccessMapper;
import multiwarehouse.ecommerce.user.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserDataAccessMapper userDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public Optional<User> findUser(UUID userId) {
        return userJpaRepository.findById(userId).map(userDataAccessMapper::userEntityToUser);
    }
}
