package multiwarehouse.ecommerce.valueobject;

public abstract class BaseTimeStamp<T> {
    private final T value;

    public BaseTimeStamp(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseTimeStamp<?> baseTimeStamp = (BaseTimeStamp<?>) o;
        return value.equals(baseTimeStamp.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
