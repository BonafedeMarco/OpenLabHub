package com.example.spaceappchallenge.model;

import com.example.spaceappchallenge.enums.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String title;
    private String description;
    private LocalDate dateCreated;
    private String status;
    private String imageUrl;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="project_tag",
            joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    private Set<Tag> relatedTags;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name="user_id", nullable = false)
    private User user;
}
