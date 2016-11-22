package com.jrdev.imagerepository.server.repositories;


import com.jrdev.imagerepository.server.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    @Override
    Iterable<Doctor> findAll();


}
