package com.example.spaceappchallenge.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class TagDto {
    @JsonAlias("tag_id")
    @JsonIgnore
    private Long tagId;
    private String name;
    @JsonAlias("project_tags")
    @JsonIgnore
    private Set<ProjectDto> projects;
    @JsonAlias("implied_tags")
    @JsonIgnore
    private Set<ImpliedTagDto> impliedTags;
    @JsonIgnore
    private Set<UserDto> users;
}
