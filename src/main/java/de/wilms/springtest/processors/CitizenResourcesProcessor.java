package de.wilms.springtest.processors;

import de.wilms.springtest.entities.Citizen;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

/**
 * Because Spring Data REST wraps things as {@literal Resources<Resource<T>>}, that is the type you must
 * match when writing a custom {@link ResourceProcessor}. --Greg Turnquist
 */
@Component
public class CitizenResourcesProcessor implements ResourceProcessor<Resources<Resource<Citizen>>> {

    public static boolean GOT_CALLED = false;

    @Override
    public Resources<Resource<Citizen>> process(Resources<Resource<Citizen>> citizens) {
        System.out.println("Hello from the ResourceSSSSProcessor!");
        GOT_CALLED = true;
        return citizens;
    }
}
