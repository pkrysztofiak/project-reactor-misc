import reactor.core.publisher.Flux;
import utils.Subscriber;

public class Example02Take {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(new Subscriber<>());
    }

}
