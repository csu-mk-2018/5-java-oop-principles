package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {

    /**
     * Конвертирует интервал в секундах в интервал в миллисекундах
     *
     * @param seconds интервал в секундах
     * @return интервал в миллисекундах
     */
    public static Milliseconds toMillis(Seconds seconds) {
        return new Milliseconds(seconds.toMillis());
    }

    /**
     * Конвертирует интервал в миллисекундах в интервал в секундах
     *
     * @param millis интервал в миллисекундах
     * @return интервал в секундах
     */
    public static Seconds toSeconds(Milliseconds millis) {
        return new Seconds(millis.toSeconds());
    }

    /**
     * Конвертирует интервал в секундах в интервал в минутах
     *
     * @param millis интервал в секундах
     * @return интервал в минутах
     */
    public static Minutes toMinutes(Milliseconds millis) {
        return new Minutes(millis.toMinutes());
    }

    /**
     * Конвертирует интервал в милнутах в интервал в секундах
     *
     * @param millis интервал в минутах
     * @return интервал в секундах
     */
    public static Hours toHours(Milliseconds millis) {
        return new Hours(millis.toHours());
    }


}
