package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Objects.requireNonNull(stream);
        Objects.requireNonNull(order);
        Objects.requireNonNull(minMaxConsumer);

        Iterator<? extends T> iterator = stream.iterator();
        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        T min = iterator.next();
        T max = min;
        while (iterator.hasNext()) {
            T value = iterator.next();
            if (order.compare(value, min) < 0) {
                min = value;
            }
            if (order.compare(value, max) > 0) {
                max = value;
            }
        }
        minMaxConsumer.accept(min, max);
    }
}
