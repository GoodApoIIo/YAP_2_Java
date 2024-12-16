package ru.rybyakowa.zadanie_3;

import java.util.Collection;
import java.util.List;
import java.util.function.*;

public class Collector {
    public static <T, P extends Collection<T>> P collect(List<T> sourceList, Supplier<P> collectionSupplier, Function<T, Boolean> classifier) {
        P collection = collectionSupplier.get();
        for (T element : sourceList) {
            if (classifier.apply(element)) {collection.add(element);}
        }
        return collection;
    }
}