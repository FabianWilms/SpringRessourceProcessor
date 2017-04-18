package de.wilms.springtest.processors;

import de.wilms.springtest.entities.Citizen;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class CitizenResourceProcessor implements ResourceProcessor<Resource<Citizen>> {

    public static boolean GOT_CALLED = false;

    @Override
    public Resource<Citizen> process(Resource<Citizen> citizenResource) {
        System.out.println("Hello from the ResourceProcessor!");
        GOT_CALLED = true;
        return citizenResource;
    }

}
