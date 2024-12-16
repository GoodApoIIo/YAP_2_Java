package ru.rybyakowa.zadanie_6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public static <T> Queue<T> reverseQueue(Queue<T> queue1) {
        Stack<T> stack = new Stack<>();
        Queue<T> queue2 = new LinkedList<>();

        // 1. Перекладываем элементы из queue1 в stack
        while (!queue1.isEmpty()) {
            stack.push(queue1.remove());
        }
        // 2. Перекладываем элементы из stack в queue2
        while (!stack.isEmpty()) {
            queue2.add(stack.pop());
        }

        return queue2;
    }
}