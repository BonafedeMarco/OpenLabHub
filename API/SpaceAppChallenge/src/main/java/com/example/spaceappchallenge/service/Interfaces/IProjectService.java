package com.example.spaceappchallenge.service.Interfaces;

import com.example.spaceappchallenge.dto.request.CreateProjectDto;
import com.example.spaceappchallenge.dto.response.ProjectDto;
import com.example.spaceappchallenge.dto.response.RespMessage;

import java.util.Set;

public interface IProjectService {
    public ProjectDto findById(long id);
    public Set<ProjectDto> findAll();
    public RespMessage addProject(CreateProjectDto dto, long userId);
    public long deleteProject(long id);
    public long updateProject(long id, ProjectDto dto);
}
