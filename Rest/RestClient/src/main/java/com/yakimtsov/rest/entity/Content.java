package com.yakimtsov.rest.entity;

public class Content {
    private String description;
    private String text;

    public Content(){

    }

    public Content(String description, String text) {
        this.description = description;
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

        Content content = (Content) obj;
        return this.getDescription().equals(content.getDescription())
                && this.getText().equals(content.getText());

    }
}
