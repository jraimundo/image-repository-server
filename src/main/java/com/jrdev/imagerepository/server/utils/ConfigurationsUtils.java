package com.jrdev.imagerepository.server.utils;


import com.jrdev.imagerepository.server.entities.Configuration;
import com.jrdev.imagerepository.server.repositories.ConfigurationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.Map;

@Service
public class ConfigurationsUtils {

    @Autowired
    private ConfigurationsRepository configurationsRepository;

    private Map<String, String> configurations;

    private ConfigurationsUtils() {}

    public String getConfigurationValue(String configurationKey) {

        checkConfigurations();

        String configurationValue = this.configurations.get(configurationKey);

        return configurationValue != null ? configurationValue : "";
    }

    private void checkConfigurations() {
        if (this.configurations == null) {
            updateConfigurations();
        }
    }

    public void updateConfigurations() {
        this.configurations = new Hashtable<>();
        for (Configuration configuration : this.configurationsRepository.findAll()) {
            this.configurations.put(configuration.configurationKey, configuration.configurationValue);
        }
    }

}
