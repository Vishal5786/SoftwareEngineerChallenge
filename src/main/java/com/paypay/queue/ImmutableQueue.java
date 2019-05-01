package com.paypay.queue;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableQueue<T> implements Queue<T> {

    private final List<T> elementList;

    private List<T> newElementList;
    private static final String EMPTY_MESSAGE = "Queue is empty.";

    public ImmutableQueue(List<T> elementList) {
        this.elementList = elementList;
    }

    @Override
    public Queue<T> enQueue(T t) {
        newElementList = new ArrayList<>(elementList);
        newElementList.add(t);

        return new ImmutableQueue<>(newElementList);
    }

    @Override
    public Queue<T> deQueue() {

        if (elementList.isEmpty()) {
            throw new RuntimeException(EMPTY_MESSAGE);
        }

        newElementList = new ArrayList<>(elementList);
        newElementList.remove(0);
        return new ImmutableQueue<>(newElementList);
    }

    @Override
    public T head() {

        if (elementList.isEmpty()) {
            throw new RuntimeException(EMPTY_MESSAGE);
        }

        return elementList.get(0);
    }

    @Override
    public boolean isEmpty() {
        return elementList.isEmpty();
    }

}
