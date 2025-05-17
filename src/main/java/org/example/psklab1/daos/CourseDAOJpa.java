package org.example.psklab1.daos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.psklab1.entities.Course;

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
    @Transactional
    public Course create(Course course) {
        em.persist(course);
        return course;
    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Course deleteById(Long id) {
        Course course = em.find(Course.class, id);
        if (course != null) {
            em.remove(course);
        }
        return course;
    }
}
