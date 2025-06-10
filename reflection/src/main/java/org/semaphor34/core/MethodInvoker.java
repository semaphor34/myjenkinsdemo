package org.semaphor34.core;

import org.semaphor34.annotation.ArgumentFallback;
import org.semaphor34.annotation.Mapper;
import org.semaphor34.dummy.MethodExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class MethodInvoker<E extends MethodExtension> {
    @NotNull
    public Object invoke(@Nullable Mapper mapper,
                         @NotNull String text,
                         @NotNull AnnotatedCommandExecutor<E> executor) {

        List<Method> methodList = Optional.ofNullable(mapper)
                .map(x -> getFallbackMethods(x.value(), executor))
                .orElse(Collections.emptyList());

        return methodList.stream()
                .limit(1)
                .map(method -> invokeMethod(method, executor, text))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    protected List<Method> getFallbackMethods(@NotNull String argument,
                                              @NotNull AnnotatedCommandExecutor<E> executor) {
        return Arrays.stream(executor.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(ArgumentFallback.class))
                .filter(method -> Arrays.asList(method.getAnnotation(ArgumentFallback.class).value()).contains(argument))
                .filter(method -> method.getParameterCount() == 1)
                .sorted((o1, o2) -> o2.getAnnotation(ArgumentFallback.class).priority().getSlot()
                        - o1.getAnnotation(ArgumentFallback.class).priority().getSlot())
                .collect(Collectors.toList());
    }

    private Object invokeMethod(@NotNull Method method,
                         @NotNull AnnotatedCommandExecutor<E> executor,
                         @NotNull String text) {
        try {
            return method.invoke(executor, text);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
