package org.example.psklab1.entities;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
public class StudentCourseDAOJpa implements StudentCourseDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void insertMultiple(Long studentId, List<Long> courseIds) {

        for(Long courseId : courseIds) {
            em.createNativeQuery("INSERT INTO course_student (course_id, student_id) VALUES (?, ?)")
                    .setParameter(1, courseId)
                    .setParameter(2, studentId)
                    .executeUpdate();
        }
    }
}
