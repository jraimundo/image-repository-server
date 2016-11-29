package com.jrdev.imagerepository.server.utils;


import com.jrdev.imagerepository.server.entities.Configuration;
import com.jrdev.imagerepository.server.repositories.ConfigurationsRepository;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.Map;

@Service
public class ConfigurationsUtils {

    @Autowired
    private ConfigurationsRepository configurationsRepository;

    private static ConfigurationsUtils instance;

    private Map<String, String> configurations;

    private ConfigurationsUtils() {
//        ConfigurationsRepository configurationsRepository = applicationContext.getBean(ConfigurationsRepository.class);
//        this.configurations = new Hashtable<>();
//        for (Configuration configuration : configurationsRepository.findAll()) {
//            this.configurations.put(configuration.configurationKey, configuration.configurationValue);
//        }
    }

    public static ConfigurationsUtils getInstance() {
        if (instance == null) {
            instance = new ConfigurationsUtils();
        }

        return instance;
    }

    public String getConfigurationValue(String configurationKey) {
        return "Test...";
    }

}
