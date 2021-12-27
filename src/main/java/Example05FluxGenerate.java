import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import utils.Subscriber;

public class Example05FluxGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String country = Faker.instance().country().name();
            synchronousSink.next(country);
            if (country.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
            }
        }).subscribe(new Subscriber<>());
    }
}
