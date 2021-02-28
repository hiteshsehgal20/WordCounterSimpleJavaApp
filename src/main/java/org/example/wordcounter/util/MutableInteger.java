package org.example.wordcounter.util;

/**
 * Mutable integer class to wrap around primitive int to avoid autoboxing.
 */
public class MutableInteger {
    int count;

    public MutableInteger(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        this.count++;
    }

    @Override
    public String toString() {
        return "MutableInteger{" +
                "count=" + count +
                '}';
    }
}
