package com.example.spaceappchallenge.dto.response;

import com.example.spaceappchallenge.enums.State;
import com.example.spaceappchallenge.model.Tag;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class ProjectDto {
    @JsonIgnore
    @JsonAlias("project_id")
    private Long projectId;
    private String title;
    private String description;
    @JsonAlias("date_created")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;
    private String status;
    private String imageUrl;
    @JsonIgnore
    private UserDto user;
    private Set<TagDto> relatedTags;
}
