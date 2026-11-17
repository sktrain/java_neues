package other.samples.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class MyPublisher {

    private SubmissionPublisher<Integer> publisher;

    public MyPublisher(SubmissionPublisher<Integer> publisher) {
        this.publisher = publisher;

    }

    public void register(Flow.Subscriber<Integer> subscriber) {
        publisher.subscribe(subscriber);
    }

    public void start()  {
        for (int i = 0; i < 10; i++) {
            publisher.submit(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
