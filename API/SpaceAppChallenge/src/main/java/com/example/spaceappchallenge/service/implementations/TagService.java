package com.example.spaceappchallenge.service.implementations;

import com.example.spaceappchallenge.dto.response.TagDto;
import com.example.spaceappchallenge.service.Interfaces.ITagService;

import java.util.Set;

public class TagService implements ITagService {
    @Override
    public TagDto findById(long id) {
        return null;
    }

    @Override
    public Set<TagDto> findAll() {
        return null;
    }

    @Override
    public long addTag(TagDto dto) {
        return 0;
    }

    @Override
    public long deleteTag(long id) {
        return 0;
    }

    @Override
    public long updateTag(long id, TagDto dto) {
        return 0;
    }
}
