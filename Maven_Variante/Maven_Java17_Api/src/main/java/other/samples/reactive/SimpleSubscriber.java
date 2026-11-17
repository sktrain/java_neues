package other.samples.reactive;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class SimpleSubscriber implements Subscriber<String> {

	private final String id;
    private final TimedLogger logger;
    private Subscription subscription;

    public SimpleSubscriber(String id, TimedLogger logger) {
        this.id = id;
        this.logger = logger;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.logger.log("%s: onSubscribe(..)", this.id);
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        logger.log("%s: onNext(%s)", this.id, item);
        this.subscription.request(1);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        this.logger.log("%s: onError(%s:%s)",
                this.id, throwable.getClass().getSimpleName(), throwable.getMessage());
    }

    @Override
    public void onComplete() {
        this.logger.log("%s: onComplete()", this.id);
    }

}
