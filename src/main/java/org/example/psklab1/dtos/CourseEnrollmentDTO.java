package org.example.psklab1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseEnrollmentDTO {
    private Long courseId;
    private String courseTitle;
    private Long enrolledCount;

    public CourseEnrollmentDTO(Long courseId, String courseTitle, Long enrolledCount) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.enrolledCount = enrolledCount;
    }
}
