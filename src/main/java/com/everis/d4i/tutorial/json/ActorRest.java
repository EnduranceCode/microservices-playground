package com.everis.d4i.tutorial.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable {

    private Long id;
    private String name;

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
}
