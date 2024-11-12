package multiwarehouse.ecommerce.user.mapper;

import multiwarehouse.ecommerce.entity.User;
import multiwarehouse.ecommerce.user.entity.UserEntity;
import multiwarehouse.ecommerce.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper {
    public User userEntityToUser(UserEntity userEntity) {
        return new User(new UserId(userEntity.getId()));
    }
}
