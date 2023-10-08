package com.example.spaceappchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="user_ent")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String description;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Project> projects;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Application> applications;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="user_tag",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    private Set<Tag> relatedTags;

}
