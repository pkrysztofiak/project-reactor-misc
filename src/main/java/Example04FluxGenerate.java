import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import utils.Subscriber;

public class Example04FluxGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            synchronousSink.next(Faker.instance().country().name());
            synchronousSink.next(Faker.instance().country().name());
        }).subscribe(new Subscriber<>());

    }
}
