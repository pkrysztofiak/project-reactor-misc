import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import utils.Subscriber;

public class Example03FluxCreateCancelled {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Faker.instance().country().name();
                        System.out.println("Emitting: " + country);
                        fluxSink.next(country);
                    }
                    while (!country.equalsIgnoreCase("canada"));
//                    while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(new Subscriber<>());
    }
}
