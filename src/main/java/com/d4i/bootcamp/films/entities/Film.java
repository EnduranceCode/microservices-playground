package com.d4i.bootcamp.films.entities;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    private static final long serialVersionUID = -9055733513942096076L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_desc")
    private String shortDescription;

    @Column(name = "long_desc")
    private String longDescription;

    @Column(name = "year", nullable = false)
    private Year year;

    @ManyToOne(fetch = FetchType.LAZY)
    private RecommendedAge recommendedAge;

    @ElementCollection
    @Column(name = "category_id")
    @CollectionTable(name = "film_categories", joinColumns = @JoinColumn(name = "film_id"))
    private List<Long> categories = new ArrayList<>();

    @Column(name = "advertising")
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

    public RecommendedAge getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(RecommendedAge recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }
}
