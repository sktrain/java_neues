package other.samples.reactive;

import org.testng.annotations.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;


public class SimpleReactiveStreamsApp {

/**
* Demonstrates SubmissionPublisher instantiations
*/
//    void instantiateSubmissionPublisher() {
//        // has default buffer size of 256
//        var pub1 = new SubmissionPublisher<String>();
//
//        // custom executor and buffer size
//        var pub2 = new SubmissionPublisher<String>(
//                ForkJoinPool.commonPool(),
//                0
//        );
//
//        // custom executor, buffer size and error-handler
//        var pub3 = new SubmissionPublisher<String>(
//                Runnable::run,
//                0,
//                (subscr, err) -> err.printStackTrace()
//        );
//    }
	
	public static void main(String[] args) {
		
		try {
			subscribe();
			submitNoSubscribers();
			submit();
			submitUnbuffered();
			offer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * Shows that subscription occurs in a separate thread -- without sleep no output
     */
    static void subscribe() throws InterruptedException {
        MethodLogger.logMethodCall();
        var publisher = new SubmissionPublisher<String>();
        var subscriber = new SimpleSubscriber("subscriber", new TimedLogger());
        publisher.subscribe(subscriber);
        Thread.sleep(1000);
    }


    /**
     * A publisher without subscribers basically discards all items.
     */
   static void submitNoSubscribers() throws InterruptedException {
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
   static void submit() throws InterruptedException {
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
   static void submitUnbuffered() throws InterruptedException {
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
   static void offer() throws InterruptedException {
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
