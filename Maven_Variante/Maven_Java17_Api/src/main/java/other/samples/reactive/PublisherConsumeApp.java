package other.samples.reactive;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SubmissionPublisher;

@SuppressWarnings("resource")
public class PublisherConsumeApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TimedLogger timedLogger = new TimedLogger();
        var publisher = new SubmissionPublisher<String>();
        var future = publisher.consume((i) -> timedLogger.log("Received %s", i));

        for (int n = 0; n < 5; n++) {
            String item = "item" + n;
            timedLogger.log("Submitting %s", item);
            publisher.submit(item);
        }
        publisher.close();

        future.get();   // makes publisher consume all items
    }
}
