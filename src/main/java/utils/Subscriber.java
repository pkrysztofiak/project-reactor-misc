package utils;

import org.reactivestreams.Subscription;

public class Subscriber<T> implements org.reactivestreams.Subscriber<T> {

    private final String name;

    public Subscriber() {
        this("Subscriber");
    }

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T next) {
        System.out.println(name + " - Next: " + next);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " - Error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " - Completed");
    }
}