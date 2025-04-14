package org.example.psklab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.psklab1.entities.Course;
import org.example.psklab1.entities.CourseDAO;

import java.util.List;

@RequestScoped
@Named("courseController")
public class CourseController {

    @Inject
    private CourseDAO courseDAO;

    public List<Course> getCourses() {
        return courseDAO.getAll();
    }
}
