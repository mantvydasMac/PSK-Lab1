package org.example.psklab1.entities;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class CourseDAOJpa implements CourseDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Course> getAll() {
        return em.createQuery("SELECT c FROM Course c LEFT JOIN FETCH c.students", Course.class).getResultList();
    }

    @Override
    public Course create(Course course) {
        return null;
    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    @Override
    public Course deleteById(Long id) {
        return null;
    }
}
