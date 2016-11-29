package com.jrdev.imagerepository.server.repositories;


import com.jrdev.imagerepository.server.entities.Configuration;
import org.springframework.data.repository.CrudRepository;

public interface ConfigurationsRepository extends CrudRepository<Configuration, Long> {

    @Override
    Iterable<Configuration> findAll();

    Configuration findByConfigurationKey(String configurationKey);
}
