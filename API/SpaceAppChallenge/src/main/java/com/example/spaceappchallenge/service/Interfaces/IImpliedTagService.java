package com.example.spaceappchallenge.service.Interfaces;

import com.example.spaceappchallenge.dto.response.ImpliedTagDto;

import java.util.Set;

public interface IImpliedTagService {
    public ImpliedTagDto findById(long id);
    public Set<ImpliedTagDto> findAll();
    public long addImpliedTag(long baseTagId, long impliedTagId);
    public long deleteImpliedTag(long id);
    public long updateImpliedTag(long id, ImpliedTagDto dto);
}
