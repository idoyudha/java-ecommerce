package multiwarehouse.ecommerce.valueobject;

public abstract class BaseString<T> {
    private final T value;

    public BaseString(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseString<?> baseString = (BaseString<?>) o;
        return value.equals(baseString.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
