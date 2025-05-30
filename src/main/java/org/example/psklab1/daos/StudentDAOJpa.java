package org.example.psklab1.daos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.psklab1.entities.Student;

import java.util.List;

@RequestScoped
public class StudentDAOJpa implements StudentDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Student> getAll() {
        return em.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.courses", Student.class).getResultList();
    }

    @Override
    @Transactional
    public Student create(Student student) {
        em.persist(student);
        return student;
    }

    @Override
    public Student findById(Long id) {
        return em.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.courses WHERE s.id = :id", Student.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Student deleteById(Long id) {
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        return student;
    }

//    update
    @Override
    @Transactional
    public Student update(Student student) {
        return em.merge(student);
    }

//    delete

}
