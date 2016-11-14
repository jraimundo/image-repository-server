package com.example.jersey;

import com.example.entities.Doctor;
import com.example.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/rest")
public class TestOneController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/array")
    public int[] getArray() {
        return new int[] {1,2,3,4,5};
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<String> getList() {
        List<String> list = new ArrayList<String>(10);
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/alldoctors")
    public Iterable<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
