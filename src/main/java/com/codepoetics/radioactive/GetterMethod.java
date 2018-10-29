package com.codepoetics.radioactive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

class GetterMethod<T, V> implements Function<T, V> {

    final Method method;

    GetterMethod(final Method method) {
        this.method = method;
    }

    @Override
    public V apply(T bean) {
        try {
            return (V) method.invoke(bean);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }
    }
}