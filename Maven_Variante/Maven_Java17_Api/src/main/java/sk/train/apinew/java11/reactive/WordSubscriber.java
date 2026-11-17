package sk.train.apinew.java11.reactive;

import java.time.LocalDateTime;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class WordSubscriber implements Subscriber<String>
{
    @Override
    public void onSubscribe(final Subscription subscription)
    {
        System.out.println(LocalDateTime.now() + " onSubscribe()");
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(final String item)
    {
        System.out.println(LocalDateTime.now() + " onNext(): " + item);
    }

    @Override
    public void onComplete()
    {
        System.out.println(LocalDateTime.now() + " onComplete()");
    }

    @Override
    public void onError(final Throwable throwable)
    {
        throwable.printStackTrace();
    }
}