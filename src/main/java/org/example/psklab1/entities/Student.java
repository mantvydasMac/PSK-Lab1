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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String groupNumber;

    @Version
    @Column(nullable = false)
    private Long version;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}
