package com.example.spaceappchallenge.model;

import com.example.spaceappchallenge.enums.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    private State state;
    private String message;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="project_id", nullable = false)
    private Project project;
}
