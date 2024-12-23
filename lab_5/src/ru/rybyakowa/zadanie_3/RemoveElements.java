package ru.rybyakowa.zadanie_3;

import java.util.Iterator;
import java.util.List;

public class RemoveElements {

    public static <T> void removeElements(List<T> list, T valueToRemove) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(valueToRemove)) {
                iterator.remove();
            }
        }
    }
}