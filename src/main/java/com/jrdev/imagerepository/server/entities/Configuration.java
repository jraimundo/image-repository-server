package com.jrdev.imagerepository.server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="configurations")
public class Configuration {

    @Id
    private String configurationKey;
    private String configurationName;
    private String configurationDescription;


    public Configuration() {}

    public Configuration(String configurationKey, String configurationName, String configurationDescription) {
        this.configurationKey = configurationKey;
        this.configurationName = configurationName;
        this.configurationDescription = configurationDescription;
    }


    public String getConfigurationKey() {
        return configurationKey;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public String getConfigurationDescription() {
        return configurationDescription;
    }

}
