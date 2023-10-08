package com.example.spaceappchallenge.dto.response;

import com.example.spaceappchallenge.enums.State;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApplicationDto {
    private String state;
    private String message;
    private UserDto user;
    private ProjectDto project;
}
