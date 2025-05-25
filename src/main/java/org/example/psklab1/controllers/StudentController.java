package org.example.psklab1.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.OptimisticLockException;
import lombok.Getter;
import lombok.Setter;
import org.example.psklab1.entities.Student;
import org.example.psklab1.daos.StudentDAO;
import org.example.psklab1.util.ExceptionInterceptorBinding;

import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named("studentController")
public class StudentController implements Serializable {

    @Getter @Setter
    private String studentName;

    @Getter @Setter
    private String groupNumber;

    @Getter @Setter
    private Student editStudent;

    @Inject
    private StudentDAO studentDAO;

    @Getter @Setter
    private String studentId;

    @PostConstruct
    public void init() {
        studentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        if (studentId != null) {
            Long id = Long.parseLong(studentId);
            this.editStudent = studentDAO.findById(id);
        }
    }

    public List<Student> getStudents() {
        return studentDAO.getAll();
    }

    @ExceptionInterceptorBinding
    public void createStudent() {
        Student student = new Student();
        student.setName(studentName);
        student.setGroupNumber(groupNumber);
        studentDAO.create(student);
    }

    public Student getStudent() {

        if (studentId != null) {
            Long id = Long.parseLong(studentId);
            return studentDAO.findById(id);  // Fetch the student by id
        }
        else {
            return null;
        }
    }

    public void deleteStudent() {
        var deleteStudentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Student ID: " + deleteStudentId));

        if (deleteStudentId != null) {
            Long id = Long.parseLong(deleteStudentId);
            studentDAO.deleteById(id);  // Fetch the student by id
        }
    }

    public void updateStudent() {
        try {
            studentDAO.update(editStudent);  // JPA DAO, using em.merge()
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Student updated successfully."));
        } catch (OptimisticLockException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Update failed. The student was modified by another user.", null));
        }
    }
}
