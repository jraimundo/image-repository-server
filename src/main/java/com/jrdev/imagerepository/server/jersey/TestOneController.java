package com.jrdev.imagerepository.server.jersey;

import com.jrdev.imagerepository.server.entities.Doctor;
import com.jrdev.imagerepository.server.repositories.DoctorRepository;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/rest")
public class TestOneController {

    private static final Logger logger = LoggerFactory.getLogger(TestOneController.class);

    @Autowired
    private DoctorRepository doctorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/array")
    public int[] getArray() {
        int[] array = new int[] {1,2,3,4,5};

        logger.info("performed array get request", array);

        return array;
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

        logger.info("performed list get request", list);

        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/alldoctors")
    public Iterable<Doctor> getAllDoctors() {
        Iterable<Doctor> allDoctors = doctorRepository.findAll();

        logger.info("performed alldoctors get request", allDoctors);

        return allDoctors;
    }


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/upload")
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {

        String uploadedFileLocation = "/home/jrdev/temp/" + fileDetail.getFileName();

        // save it
        try {
            writeToFile(uploadedInputStream, uploadedFileLocation);
        } catch (FileNotFoundException e) {
            logger.error("Could not save file.", e);
        }

        String output = "File uploaded to : " + uploadedFileLocation;

        logger.info("performed upload post request");

        return Response.status(200).entity(output).build();
    }


    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
                             String uploadedFileLocation) throws FileNotFoundException {

        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
