package de.wilms.springtest.processors;

import de.wilms.springtest.entities.Citizen;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

@Component
public class CitizenResourcesProcessor implements ResourceProcessor<Resources<Citizen>> {

    public static boolean GOT_CALLED = false;

    @Override
    public Resources<Citizen> process(Resources<Citizen> citizens) {
        System.out.println("Hello from the ResourceSSSSProcessor!");
        GOT_CALLED = true;
        return citizens;
    }
}
