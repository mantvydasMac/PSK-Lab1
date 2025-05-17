package org.example.psklab1.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.psklab1.dtos.TeacherDTO;
import org.example.psklab1.entities.Teacher;
import org.example.psklab1.daos.TeacherDAO;

import java.util.List;
import java.util.stream.Collectors;

@Path("/teachers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherControllerREST {

    @Inject
    private TeacherDAO teacherDAO;

    @POST
    public TeacherDTO createTeacher(Teacher teacher) {
        return new TeacherDTO(teacherDAO.create(teacher));
    }

    @GET
    public List<TeacherDTO> getTeachers() {
        return teacherDAO.getAll()
                .stream()
                .map(TeacherDTO::new)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public TeacherDTO getTeacherById(@PathParam("id") Long id) {
        return new TeacherDTO(teacherDAO.findById(id));
    }

    @DELETE
    @Path("/{id}")
    public void deleteTeacher(@PathParam("id") Long id) {
        teacherDAO.deleteById(id);
    }
}
