package org.example.psklab1.entities;

import java.util.List;

public interface StudentCourseDAO {
    void insertMultiple(Long studentId, List<Long> courseId);
}
