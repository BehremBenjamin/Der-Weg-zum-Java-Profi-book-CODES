package org.example;

public class Counter {
    private int value = 0;

    public Counter() {
    }

    public int currentValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void reset() {
        value = 0;
    }
}

class CounterWithOverflow extends Counter {
    private static final int COUNTER_MAX = 100;

    private final Counter overflowCount = new Counter();

    public int overflowCount() {
        return overflowCount.currentValue();
    }

    public void reset() {
        super.reset();
        overflowCount.reset();
    }

    public void increment() {
        if (currentValue() == COUNTER_MAX - 1) {
            super.reset();
            overflowCount.increment();
        } else {
            super.increment();
        }
    }
}