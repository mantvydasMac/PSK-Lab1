package org.example.psklab1.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.psklab1.entities.Student;
import org.example.psklab1.entities.StudentCourseDAO;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named("studentCourseController")
public class StudentCourseController {

    @Getter @Setter
    private List<Long> selectedCourses;

    @Inject
    private StudentCourseDAO studentCourseDAO;

    public StudentCourseController() {
        selectedCourses = new ArrayList<>();
    }

    public void enrollStudent() {
        String studentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Student ID: " + studentId + ", Selected: " + selectedCourses));

        if(studentId != null) {
            studentCourseDAO.insertMultiple(Long.parseLong(studentId), selectedCourses);
        }
    }
}
