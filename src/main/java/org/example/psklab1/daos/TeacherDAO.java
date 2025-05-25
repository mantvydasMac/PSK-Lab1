package org.example.psklab1.daos;

import org.example.psklab1.entities.Teacher;
import org.example.psklab1.interfaces.GenericDAO;

public interface TeacherDAO extends GenericDAO<Teacher> {
    void printMessage();
}
