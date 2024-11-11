package multiwarehouse.ecommerce.entity;

import multiwarehouse.ecommerce.valueobject.UserId;

public class User extends AggregateRoot<UserId> {
    public User() {
    }

    public User(UserId userId) {
        super.setId(userId);
    }
}
