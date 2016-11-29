package com.jrdev.imagerepository.server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="configurations")
public class Configuration {

    @Id
    public final String configurationKey;
    public final String configurationValue;
    public final String configurationDescription;


    public Configuration() {
        configurationKey = null;
        configurationValue = null;
        configurationDescription = null;
    }

    public Configuration(String configurationKey, String configurationValue, String configurationDescription) {
        this.configurationKey = configurationKey;
        this.configurationValue = configurationValue;
        this.configurationDescription = configurationDescription;
    }

}
