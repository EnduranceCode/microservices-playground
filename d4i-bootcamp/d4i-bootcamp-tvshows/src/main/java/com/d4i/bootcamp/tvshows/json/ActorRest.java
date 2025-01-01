package com.d4i.bootcamp.tvshows.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable {

    private static final long serialVersionUID = 3862482792808603266L;

    private Long id;
    private String name;
    private List<ChapterRest> chapters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChapterRest> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterRest> chapters) {
        this.chapters = chapters;
    }
}
