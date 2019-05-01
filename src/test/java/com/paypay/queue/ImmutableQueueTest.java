package com.paypay.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ImmutableQueueTest {

    private ImmutableQueue<String> emptyImmutableQueue;
    private ImmutableQueue<Integer> immutableQueue;
    private List<Integer> queueDataList;

    @Before
    public void init() {
        emptyImmutableQueue = new ImmutableQueue<>(new ArrayList<>());
        queueDataList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        immutableQueue = new ImmutableQueue<>(queueDataList);
    }

    @Test
    public void testEmptyCheck_EmptyQueue() {
        assertTrue(emptyImmutableQueue.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void testDequeue_EmptyQueue() {
        emptyImmutableQueue.deQueue();
    }

    @Test(expected = RuntimeException.class)
    public void testHeadCheck_EmptyQueue() {
        emptyImmutableQueue.head();
    }

    @Test
    public void testEmptyCheck_NonEmptyQueue() {
        assertFalse(immutableQueue.isEmpty());
    }

    //Check initial state persists after enqueue, dequeue
    @Test
    public void testInitialStatePersists_NonEmptyQueue() {
        immutableQueue.enQueue(9);
        immutableQueue.deQueue();
        assertEquals(immutableQueue.head(), queueDataList.get(0));
        immutableQueue.enQueue(10);
        immutableQueue.deQueue();
        immutableQueue.deQueue();
        immutableQueue.deQueue();
        assertEquals(immutableQueue.head(), queueDataList.get(0));
    }

}
