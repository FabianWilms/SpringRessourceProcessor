package de.wilms.springtest.processors;

import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class ResourceSupportResourceProcessor implements ResourceProcessor<ResourceSupport> {

    public static boolean GOT_CALLED = false;

    @Override
    public ResourceSupport process(ResourceSupport resourceSupport) {
        System.out.println("Hello from the ResourceSupportResourceProcessor!");
        GOT_CALLED = true;
        return resourceSupport;
    }

}
