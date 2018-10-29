package com.codepoetics.radioactive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;

class SetterMethod<T, V> implements BiConsumer<T, V> {

    final Method method;

    SetterMethod(final Method method) {
        this.method = method;
    }

    @Override
    public void accept(T t, V v) {
        try {
            method.invoke(t,v);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
