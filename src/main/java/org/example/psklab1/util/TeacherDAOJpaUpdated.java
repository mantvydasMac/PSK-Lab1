package org.example.psklab1.util;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Specializes;
import org.example.psklab1.daos.TeacherDAOJpa;

@Specializes
@RequestScoped
public class TeacherDAOJpaUpdated extends TeacherDAOJpa {

    @Override
    public void printMessage() {
        System.out.println("Still using JPA for teacherDAO.");
    }
}
