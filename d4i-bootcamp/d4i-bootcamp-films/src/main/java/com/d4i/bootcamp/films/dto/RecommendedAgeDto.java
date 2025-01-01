package com.d4i.bootcamp.films.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecommendedAgeDto implements Serializable {

    private static final long serialVersionUID = 917372394172320585L;

    private Long id;
    private String name;
    private byte minAge;
    private String description;

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

    public byte getMinAge() {
        return minAge;
    }

    public void setMinAge(byte minAge) {
        this.minAge = minAge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
