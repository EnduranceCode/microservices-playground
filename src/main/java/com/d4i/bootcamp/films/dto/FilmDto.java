package com.d4i.bootcamp.films.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.Year;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmDto implements Serializable {

    private static final long serialVersionUID = -6473989334697075320L;

    private Long id;
    private String name;
    private String shortDescription;
    private String longDescription;
    private Year year;
    private RecommendedAgeDto recommendedAge;
    private String advertising;

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public RecommendedAgeDto getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(RecommendedAgeDto recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }
}
