package zx.app.web.model.common;

import org.springframework.util.Assert;

import java.util.stream.Stream;

/**
 * @author chenk
 * @description 功能
 */
public interface ValueEnum<T> {

    /**
     * 将值装换成枚举Enum
     *
     * @param enumType enum type
     * @param value    database value
     * @param <V>      value generic
     * @param <E>      enum generic
     * @return corresponding enum
     */
    //
    static <V, E extends ValueEnum<V>> E valueToEnum(Class<E> enumType, V value) {
        Assert.notNull(enumType, "enum type must not be null");
        Assert.notNull(value, "value must not be null");
        Assert.isTrue(enumType.isEnum(), "type must be an enum type");

        return Stream.of(enumType.getEnumConstants())
                .filter(item -> item.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown database value: " + value));
    }
    /**
     * Gets enum value.
     *
     * @return enum value
     */
    T getValue();

}
