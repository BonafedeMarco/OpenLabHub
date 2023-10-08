package com.example.spaceappchallenge.service.Interfaces;

import com.example.spaceappchallenge.dto.response.TagDto;

import java.util.Set;

public interface ITagService {
    public TagDto findById(long id);
    public Set<TagDto> findAll();
    public long addTag(TagDto dto);
    public long deleteTag(long id);
    public long updateTag(long id, TagDto dto);
}
