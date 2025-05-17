package org.example.psklab1.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.psklab1.entities.Student;
import org.example.psklab1.daos.StudentDAO;

import java.util.List;

@RequestScoped
@Named("studentController")
public class StudentController {

    @Getter @Setter
    private String studentName;

    @Getter @Setter
    private String groupNumber;

    @Inject
    private StudentDAO studentDAO;

    public List<Student> getStudents() {
        return studentDAO.getAll();
    }

    public void createStudent() {
        Student student = new Student();
        student.setName(studentName);
        student.setGroupNumber(groupNumber);
        studentDAO.create(student);
    }

    public Student getStudent() {
        String studentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        if (studentId != null) {
            Long id = Long.parseLong(studentId);
            return studentDAO.findById(id);  // Fetch the student by id
        }
        else {
            return null;
        }
    }

    public void deleteStudent() {
        String studentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Student ID: " + studentId));

        if (studentId != null) {
            Long id = Long.parseLong(studentId);
            studentDAO.deleteById(id);  // Fetch the student by id
        }
    }
}
