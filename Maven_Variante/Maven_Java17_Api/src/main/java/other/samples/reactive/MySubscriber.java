package other.samples.reactive;

import java.util.concurrent.Flow;

public class MySubscriber implements Flow.Subscriber<Integer> {

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println(item);
    }

    @Override
    public void onError(Throwable throwable) {
            throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Kommt nichts mehr");
    }
}
