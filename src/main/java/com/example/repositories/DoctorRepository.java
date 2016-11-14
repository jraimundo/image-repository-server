package com.example.repositories;


import com.example.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    @Override
    Iterable<Doctor> findAll();


}
