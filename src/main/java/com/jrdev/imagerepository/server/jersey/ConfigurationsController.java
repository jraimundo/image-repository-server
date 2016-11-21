package com.jrdev.imagerepository.server.jersey;

import com.jrdev.imagerepository.server.entities.Configuration;
import com.jrdev.imagerepository.server.repositories.ConfigurationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Component
@Path("/rest")
public class ConfigurationsController {

    private static final Logger logger = LoggerFactory.getLogger(TestOneController.class);

    @Autowired
    private ConfigurationsRepository configurationsRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/configurations")
    public Iterable<Configuration> getAllConfigurations() {
        Iterable<Configuration> allConfigurations = configurationsRepository.findAll();

        logger.info("performed configurations get request", allConfigurations);

        return allConfigurations;
    }
}
