package org.example.psklab1.daos;

import org.apache.ibatis.annotations.*;
import org.example.psklab1.entities.Student;

import java.util.List;

public interface StudentMapper {

    @Select("SELECT * FROM student")
    @Results(id = "studentsWithCourses", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "groupNumber", column = "groupnumber"),
            @Result(property = "courses", column = "id", many = @Many(select = "org.example.psklab1.daos.CourseMapper.getCoursesByStudentId"))
    })
    List<Student> getAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results(id = "studentWithCourses", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "groupNumber", column = "groupnumber"),
            @Result(property = "courses", column = "id", many = @Many(select = "org.example.psklab1.daos.CourseMapper.getCoursesByStudentId"))
    })
    Student getById(Long id);

    @Insert("INSERT INTO student (name, groupnumber) VALUES (#{name}, #{groupNumber})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void delete(@Param("id") long id);
}
