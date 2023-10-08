package com.example.spaceappchallenge.controller;

import com.example.spaceappchallenge.dto.request.CreateProjectDto;
import com.example.spaceappchallenge.service.implementations.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/project")
@RestController
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController (ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getAll(@PathVariable long projectId){
        return new ResponseEntity<>(projectService.findById(projectId), HttpStatus.OK);
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> getAll(@RequestBody CreateProjectDto newProject, @PathVariable long userId){
        return new ResponseEntity<>(projectService.addProject(newProject, userId), HttpStatus.OK);
    }
}
