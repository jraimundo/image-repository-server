package com.jrdev.imagerepository.server.jersey;

import com.jrdev.imagerepository.server.entities.Configuration;
import com.jrdev.imagerepository.server.repositories.ConfigurationsRepository;
import com.jrdev.imagerepository.server.utils.ConfigurationsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Controller
@Path("/rest")
public class ConfigurationsController {

    private static final Logger logger = LoggerFactory.getLogger(TestOneController.class);

    @Autowired
    private ConfigurationsRepository configurationsRepository;
    @Autowired
    private ConfigurationsUtils configurationsUtils;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/configurations")
    public Iterable<Configuration> getAllConfigurations() {
        Iterable<Configuration> allConfigurations = configurationsRepository.findAll();

        logger.info("performed configurations get request", allConfigurations);

        return allConfigurations;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/configurationvalueone")
    public String getConfigurationValueOne(@QueryParam("configurationkey") String configurationKey) {

        logger.info("performed configuration value get request. Configuration key: ", configurationKey);

        Configuration configuration = configurationsRepository.findByConfigurationKey(configurationKey);
        String result;
        if (configuration != null) {
            result = configuration.configurationValue;
        } else {
            result = "";
        }

        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/configurationvaluetwo")
    public String getConfigurationValueTwo(@QueryParam("configurationkey") String configurationKey) {

        logger.info("performed configuration value get request. Configuration key: ", configurationKey);

        return configurationsUtils.getConfigurationValue(configurationKey);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/configurationsupdate")
    public String updateConfigurations() {

        logger.info("performed configurations update");

        configurationsUtils.updateConfigurations();

        return Response.Status.OK.toString();
    }
}
