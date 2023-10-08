package com.example.spaceappchallenge.dto.request;

import com.example.spaceappchallenge.dto.response.UserDto;
import com.example.spaceappchallenge.enums.State;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class CreateProjectDto {
    private String title;
    private String description;
    private String status;
    @JsonAlias("image_url")
    private String imageUrl;
    @JsonAlias("project_tags")
    private Set<CreateTagDto> projectTags;
}
