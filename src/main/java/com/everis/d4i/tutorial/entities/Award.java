package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "AWARDS")
@NamedQuery(name = "Award.getAwardsByTvShowId", query = "SELECT a FROM Award a JOIN a.tvShows ts WHERE ts.id = :tvShowId")
public class Award implements Serializable {

    private static final long serialVersionUID = 698460971875255349L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "AWARDS_TV_SHOWS", joinColumns = {
            @JoinColumn(name = "AWARD_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "TV_SHOW_ID")})
    private List<TvShow> tvShows;

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

    public List<TvShow> getTvShows() {
        return tvShows;
    }

    public void setTvShows(List<TvShow> tvShows) {
        this.tvShows = tvShows;
    }
}
