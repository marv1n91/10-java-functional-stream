package com.example.task01;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task01Main {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength.apply(null));
        System.out.println(safeStringLength.apply("hello"));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        Objects.requireNonNull(condition);
        Objects.requireNonNull(ifTrue);
        Objects.requireNonNull(ifFalse);

        return value -> {
            if (condition.test(value)) {
                return ifTrue.apply(value);
            }
            return ifFalse.apply(value);
        };

    }
}
