package other.samples.reactive;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class SimpleReactiveStreamsAppTest {

	 /**
     * Shows that subscription occurs in a separate thread -- without sleep no output
     */
    @Test
    void subscribe() throws InterruptedException {
        MethodLogger.logMethodCall();
        var publisher = new SubmissionPublisher<String>();
        var subscriber = new SimpleSubscriber("subscriber", new TimedLogger());
        publisher.subscribe(subscriber);
        Thread.sleep(1000);
    }


    /**
     * A publisher without subscribers basically discards all items.
     */
    @Test
    void submitNoSubscribers() throws InterruptedException {
        MethodLogger.logMethodCall();
        TimedLogger log = new TimedLogger();

        var publisher = new SubmissionPublisher<String>();

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            log.log("Submitting %s", item);
            publisher.submit(item);
        }

        publisher.close();
        log.log("Publisher closed");

        Thread.sleep(1000);
    }


    /**
     * Demos that submitted items and a closed publisher are received by the subscriber.
     */
    @Test
    void submit() throws InterruptedException {
        MethodLogger.logMethodCall();
        TimedLogger log = new TimedLogger();

        var publisher = new SubmissionPublisher<String>(
                ForkJoinPool.commonPool(),
                1
        );
        var subscriber = new SimpleSubscriber("subscriber", log);
        publisher.subscribe(subscriber);

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            log.log("Submitting %s", item);
            publisher.submit(item);
        }

        publisher.close();
        log.log("Publisher closed");

        Thread.sleep(2000);
    }


    /**
     * Demos that an unbuffered publisher blocks on subscribers when using {@code submit()}.
     */
    @Test
    void submitUnbuffered() throws InterruptedException {
        MethodLogger.logMethodCall();
        TimedLogger log = new TimedLogger();

        var publisher = new SubmissionPublisher<String>(ForkJoinPool.commonPool(), 1);
        var subscriber = new SimpleSubscriber("subscriber", log);
        publisher.subscribe(subscriber);

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            log.log("Submitting %s", item);
            publisher.submit(item);
        }

        publisher.close();
        log.log("Publisher closed");

        Thread.sleep(1000);
    }


    /**
     * Demonstrates that {@code offer()} does not block but discards items that cannot be received.
     */
    @Test
    void offer() throws InterruptedException {
        MethodLogger.logMethodCall();
        TimedLogger log = new TimedLogger();

        var publisher = new SubmissionPublisher<String>(
                ForkJoinPool.commonPool(),
                1
        );
        var subscriber = new SimpleSubscriber("subscriber", log);
        publisher.subscribe(subscriber);

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            log.log("Offering %s", item);
            publisher.offer(item, 100, TimeUnit.MILLISECONDS, null);
        }

        publisher.close();
        log.log("Publisher closed");

        Thread.sleep(1000);
    }
}
