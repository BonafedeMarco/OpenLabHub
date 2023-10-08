package com.example.spaceappchallenge.service.Interfaces;

import com.example.spaceappchallenge.dto.response.ApplicationDto;

import java.util.Set;

public interface IApplicationService {
    public ApplicationDto findById(long id);
    public Set<ApplicationDto> findAll();
    public long addApplication(ApplicationDto dto, long idUser, long idProject);
    public long deleteApplication(long id);
    public long updateApplication(long id, ApplicationDto dto);
}
