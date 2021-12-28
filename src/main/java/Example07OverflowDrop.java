import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import utils.Sleep;

public class Example07OverflowDrop {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 100; i++) {
                        System.out.println("Push: " + i);
                        fluxSink.next(i);
                    }
                })
                .onBackpressureDrop()
                .log() //request(16)
                .publishOn(Schedulers.single())
                .log() //request(unbounded)
                .subscribe(next -> {
                    Sleep.millis(10);
                });

        Sleep.seconds(60);
    }
}