package com.yakimtsov.rest.entity;

public class Author {
    private String name;
    private String surname;
    private String experience;

    public Author(){

    }

    public Author(String name, String surname, String experience) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj == this) {
            return true;
        }
        if(obj.getClass() != this.getClass()){
            return  false;
        }

        Author author = (Author) obj;
        return this.getName().equals(author.getName())
                && this.getExperience().equals(author.getExperience())
                && this.getSurname().equals(author.getSurname());

    }
}
