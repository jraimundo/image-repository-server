package com.jrdev.imagerepository.server.jersey;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(TestOneController.class);
        register(ConfigurationsController.class);
        register(MultiPartFeature.class);
    }
}
