package org.example.psklab1.daos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.psklab1.entities.Teacher;

import java.util.List;

@RequestScoped
public class TeacherDAOJpa implements TeacherDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Teacher> getAll() {
        return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    @Transactional
    public Teacher create(Teacher teacher) {
        em.persist(teacher);
        return teacher;
    }

    @Override
    public Teacher findById(Long id) {
        return em.find(Teacher.class, id);
    }

    @Override
    @Transactional
    public Teacher deleteById(Long id) {
        Teacher teacher = em.find(Teacher.class, id);
        if (teacher != null) {
            em.remove(teacher);
        }
        return teacher;
    }
}
