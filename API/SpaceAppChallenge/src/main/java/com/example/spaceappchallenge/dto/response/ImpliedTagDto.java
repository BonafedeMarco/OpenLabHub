package com.example.spaceappchallenge.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImpliedTagDto {
    @JsonAlias("base_tag")
    private TagDto baseTag;
    @JsonAlias("related_tag")
    private TagDto relatedTag;
}
