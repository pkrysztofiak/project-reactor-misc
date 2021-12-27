import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import utils.Subscriber;

public class Example01FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String country;
            do {
                country = Faker.instance().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada"));
            fluxSink.complete();
        }).subscribe(new Subscriber<>());
    }
}
