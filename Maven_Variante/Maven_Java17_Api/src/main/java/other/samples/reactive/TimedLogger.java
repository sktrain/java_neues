package other.samples.reactive;

public class TimedLogger {

    private final long startMillis;

    public TimedLogger() {
        this.startMillis = System.currentTimeMillis();
    }

    public void log(String pattern, Object... args) {
        float secondsSince = (System.currentTimeMillis() - this.startMillis) / 1000.0f;
        String message = String.format(pattern, args);
        System.out.printf(
                "[%40s] %.3f %s\n",
                Thread.currentThread().getName(),
                secondsSince,
                message);
    }

}
