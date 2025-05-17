package org.example.psklab1.daos;

import org.apache.ibatis.annotations.Select;
import org.example.psklab1.entities.Course;

import java.util.List;

public interface CourseMapper {

    @Select("SELECT c.* FROM course c " +
            "JOIN course_student cs ON c.id = cs.course_id " +
            "WHERE cs.student_id = #{studentId}")
    List<Course> getCoursesByStudentId(Long studentId);
}
