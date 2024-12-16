package ru.rybyakowa.zadanie_3;

import java.util.Iterator;
import java.util.List;

public class RemoveElements {

    public static void removeElements(List<Integer> list, int valueToRemove) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(valueToRemove)) {
                iterator.remove();
            }
        }
    }
}
