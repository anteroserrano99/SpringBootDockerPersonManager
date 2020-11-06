package com.project.antero.personmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;


import java.util.UUID;

public class Person {

    private  UUID id;
    @NotNull
    private String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
