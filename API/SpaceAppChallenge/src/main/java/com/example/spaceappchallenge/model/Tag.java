package com.example.spaceappchallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    private String name;
    @ManyToMany(mappedBy = "relatedTags")
    @JsonIgnore
    private Set<Project> projects;
    @OneToMany(mappedBy = "baseTag", cascade = CascadeType.ALL)
    private Set<ImpliedTag> impliedTags;
    @ManyToMany(mappedBy = "relatedTags")
    @JsonIgnore
    private Set<User> users;
}
