package org.example.psklab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.psklab1.entities.Course;
import org.example.psklab1.entities.CourseDAO;

import java.util.List;

@RequestScoped
@Named("courseController")
public class CourseController {

    @Inject
    private CourseDAO courseDAO;

    @Getter
    @Setter
    private String courseTitle;

    @Getter @Setter
    private Long courseId;

    public List<Course> getCourses() {
        return courseDAO.getAll();
    }

    public void addCourse() {
        Course course = new Course();
        course.setTitle(courseTitle);

        courseDAO.create(course);
    }

    public void deleteCourse() {
        courseDAO.deleteById(courseId);
    }
}
