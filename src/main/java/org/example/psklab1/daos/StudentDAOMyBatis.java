package org.example.psklab1.daos;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.ibatis.session.SqlSession;
import org.example.psklab1.entities.Student;

import java.util.List;

@Alternative
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

    @Override
    public Student update(Student student) {
        return null;
    }
}
