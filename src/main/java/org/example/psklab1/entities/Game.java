package org.example.psklab1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String title;

    @Basic(optional = false)
    private Date releaseDate;

    @ManyToOne
    private Developer developer;

    @ManyToMany
    @JoinTable(name = "game_genre",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;
}
