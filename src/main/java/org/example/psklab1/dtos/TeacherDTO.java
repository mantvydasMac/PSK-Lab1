package org.example.psklab1.dtos;

import org.example.psklab1.entities.Teacher;

public class TeacherDTO {
    public Long id;
    public String name;

    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
    }
}
