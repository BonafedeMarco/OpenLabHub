package com.example.spaceappchallenge.dto.response;

import com.example.spaceappchallenge.dto.request.CreateTagDto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class UserDto {
    @JsonAlias("user_id")
    @JsonIgnore
    private Long userId;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String description;
    private Set<ProjectDto> projects;
    private Set<ApplicationDto> applications;
    @JsonAlias("related_tags")
    private Set<TagDto> relatedTags;
}
