package org.example.psklab1.producer;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

@ApplicationScoped
public class MyBatisProducer {
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    public MyBatisProducer() {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("Error loading MyBatis configuration", e);
        }
    }

    @Produces
    public SqlSessionFactory produceSqlSessionFactory() {
        return sqlSessionFactory;
    }

    @Produces
    public SqlSession produceSqlSession() {
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession(true);
        }
        return sqlSession;
    }
}