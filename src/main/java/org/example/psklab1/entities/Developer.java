package org.example.psklab1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Developer {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;

    @Basic
    private String country;

    @OneToMany(mappedBy = "developer")
    private List<Game> games;
}
