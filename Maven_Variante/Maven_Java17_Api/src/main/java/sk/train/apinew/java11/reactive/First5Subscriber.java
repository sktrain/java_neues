package sk.train.apinew.java11.reactive;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.Consumer;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
class First5Subscriber implements Subscriber<String>
{
    private final Consumer<String> consumer;

    private Subscription           subscription;

    private int                    count = 1;

    First5Subscriber(Consumer<String> consumer)
    {
        this.consumer = consumer;
    }

    @Override
    public void onSubscribe(final Subscription subscription)
    {
        System.err.println("F5 Subscription: " + subscription);
        this.subscription = subscription;
        this.subscription.request(7);
    }

    @Override
    public void onError(final Throwable throwable)
    {
        throwable.printStackTrace();
    }

    @Override
    public void onNext(final String item)
    {
        System.err.println("F5 " + count + "x onNext(): " + item);
        consumer.accept(item);

        count++;
        if (count >= 5)
        {
            subscription.cancel();
        }
    }

    @Override
    public void onComplete()
    {
        System.err.println("onComplete()");
    }
}