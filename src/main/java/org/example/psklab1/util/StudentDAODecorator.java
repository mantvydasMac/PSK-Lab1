package org.example.psklab1.util;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import org.example.psklab1.daos.StudentDAO;
import org.example.psklab1.entities.Student;

@Decorator
public abstract class StudentDAODecorator implements StudentDAO  {

    @Inject
    @Delegate
    private StudentDAO studentDAO;

    @Override
    public Student create(Student student) {
        if (student.getName().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        return studentDAO.create(student);
    }
}
