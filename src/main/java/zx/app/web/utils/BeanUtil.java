package zx.app.web.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenk
 */
public class BeanUtil {
    // 拷贝源对象相同的字段，到目标Class中 并将目标对象返回
    @Nullable
    public static <T> T transform(@Nullable Object source, @NonNull Class<T> targetClass) {
        Assert.notNull(targetClass, "Target class must not be null");
        if (source == null) {
            return null;
        }
        // new the instance
        try {
            // 构造器 创建对象
            T targetInstance = targetClass.getDeclaredConstructor().newInstance();
            // Copy properties
            BeanUtils.copyProperties(source, targetInstance, getNullPropertyNames(source));
            // Return the target instance
            return targetInstance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to new " + targetClass.getName() + " instance or copy properties", e);
        }

    }

    /**
     * 更新源对象的属性
     */
    public static void updateProperties(@NonNull Object source, @NonNull Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }
    // 得到源对象为空的属性数组
    private static String[] getNullPropertyNames(Object source) {
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String propertyName = propertyDescriptor.getName();
            Object propertyValue = beanWrapper.getPropertyValue(propertyName);

            // if property value is equal to null, add it to empty name set
            if (propertyValue == null) {
                emptyNames.add(propertyName);
            }
        }
        return emptyNames.toArray(new String[0]);
    }

}
