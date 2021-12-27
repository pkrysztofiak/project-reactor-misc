import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Example06OverflowBuffer {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 100; i++) {
                        System.out.println("Push: " + i);
                        fluxSink.next(i);
                    }
                })
                .log() //request(16)
                .publishOn(Schedulers.single())
                .log() //request(unbounded)
                .subscribe(next -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        TimeUnit.SECONDS.sleep(60);
    }
}
