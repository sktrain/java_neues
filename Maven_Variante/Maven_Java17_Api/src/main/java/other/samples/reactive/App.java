package other.samples.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class App {

    public static void main(String[] args) {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        MyPublisher myPublisher = new MyPublisher(publisher);
        myPublisher.register(new MySubscriber());
        myPublisher.start();
    }
}
