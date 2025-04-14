package org.example.psklab1.entities;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


@RequestScoped
public class StudentDAOMyBatis implements StudentDAO {

    @Inject
    private SqlSession sqlSession;

    @Override
    public List<Student> getAll() {
        return sqlSession.getMapper(StudentMapper.class).getAll();
    }

    @Override
    @Transactional
    public Student create(Student student) {
        sqlSession.getMapper(StudentMapper.class).add(student);
        return student;
    }

    @Override
    public Student findById(Long id) {
        return sqlSession.getMapper(StudentMapper.class).getById(id);
    }

    @Override
    @Transactional
    public Student deleteById(Long id) {
        sqlSession.getMapper(StudentMapper.class).delete(id);
        return null;
    }
}
