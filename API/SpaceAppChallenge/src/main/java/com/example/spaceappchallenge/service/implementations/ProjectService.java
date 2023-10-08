package com.example.spaceappchallenge.service.implementations;

import com.example.spaceappchallenge.dto.request.CreateProjectDto;
import com.example.spaceappchallenge.dto.response.ProjectDto;
import com.example.spaceappchallenge.dto.response.RespMessage;
import com.example.spaceappchallenge.dto.response.UserDto;
import com.example.spaceappchallenge.enums.ResponseMessages;
import com.example.spaceappchallenge.exception.NotFoundException;
import com.example.spaceappchallenge.model.Project;
import com.example.spaceappchallenge.model.Tag;
import com.example.spaceappchallenge.model.User;
import com.example.spaceappchallenge.repository.IProjectRepository;
import com.example.spaceappchallenge.repository.IUserRepository;
import com.example.spaceappchallenge.service.Interfaces.IProjectService;
import com.example.spaceappchallenge.service.Interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    private IProjectRepository projectRepository;
    private IUserRepository userRepository;

    public ProjectService(IProjectRepository projectRepository, IUserRepository userRepository){
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ProjectDto findById(long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        if (!projectRepository.existsById(id))
            throw new NotFoundException(String.format(ResponseMessages.PROJECT_NOT_FOUND.toString(), id));

        Project projectReturned = projectRepository.findById(id).get();

        return mapper.convertValue(projectReturned, ProjectDto.class);
    }

    @Override
    public Set<ProjectDto> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Project> projectsReturned = projectRepository.findAll();

        if (projectsReturned.isEmpty())
            throw new NotFoundException("Project list is empty");

        return projectsReturned.stream()
                .map(p -> mapper.convertValue(p, ProjectDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public RespMessage addProject(CreateProjectDto dto, long userId) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        if (!userRepository.existsById(userId))
            throw new NotFoundException(String.format(ResponseMessages.USER_NOT_FOUND.toString(), userId));

        User creator = userRepository.findById(userId).get();

        Set<Tag> tags = dto.getProjectTags().stream()
                .map(t -> mapper.convertValue(t, Tag.class))
                .collect(Collectors.toSet());

        Project project = new Project();

        project.setUser(creator);
        project.setRelatedTags(tags);
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setImageUrl(dto.getImageUrl());
        project.setStatus(dto.getStatus());
        project.setDateCreated(LocalDate.now());

        RespMessage respMessage = new RespMessage();

        Project projectCreated = projectRepository.save(project);

        respMessage.setId(projectCreated.getProjectId());
        respMessage.setMessage("project created succesfully ;)");

        return respMessage;
    }

    @Override
    public long deleteProject(long id) {
        return 0;
    }

    @Override
    public long updateProject(long id, ProjectDto dto) {
        return 0;
    }
}
