package com.example.task03;

/**
 * Интервал в миллисекундах
 */
public class Milliseconds implements TimeUnit {

    private final long amount;

    public Milliseconds(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return amount;
    }

    @Override
    public long toSeconds() {
        return (long) Math.round((float) amount / 1000);
    }

    @Override
    public long toMinutes() {
        return (long) Math.round((float) amount / 60000);
    }

    @Override
    public long toHours() {
        return (long) Math.round((float) toMinutes() / 60);
    }
}
