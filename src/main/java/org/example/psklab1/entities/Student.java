package org.example.psklab1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String groupNumber;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}
