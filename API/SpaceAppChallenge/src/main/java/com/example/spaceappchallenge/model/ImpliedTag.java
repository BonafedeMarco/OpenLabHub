package com.example.spaceappchallenge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="implied_tag")
public class ImpliedTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long impliedTagId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="base_tag_id", nullable = false)
    private Tag baseTag;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="related_tag_id", nullable = false)
    private Tag relatedTag;
}
