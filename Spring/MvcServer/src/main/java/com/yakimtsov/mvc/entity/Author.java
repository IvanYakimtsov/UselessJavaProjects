package com.yakimtsov.mvc.entity;


import java.util.HashSet;
import java.util.Set;

public class Author {
    private Long id;
    private String name;
    private String surname;
    private String experience;

    public Author(){

    }


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

}
