package com.example.spaceappchallenge.dto.request;

import com.example.spaceappchallenge.dto.response.ApplicationDto;
import com.example.spaceappchallenge.dto.response.ProjectDto;
import com.example.spaceappchallenge.dto.response.TagDto;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Setter @Getter
public class CreateUserDto {
    private String username;
    private String email;
    private String password;
    private String description;
    @JsonAlias("related_tags")
    private Set<CreateTagDto> relatedTags;
}
