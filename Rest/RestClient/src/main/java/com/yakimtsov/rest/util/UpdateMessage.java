package com.yakimtsov.rest.util;

import com.yakimtsov.rest.entity.Article;

public class UpdateMessage {
    private Article oldArticle;
    private Article newArticle;


    public UpdateMessage(){

    }

    public UpdateMessage(Article oldArticle, Article newArticle) {
        this.oldArticle = oldArticle;
        this.newArticle = newArticle;
    }

    public Article getOldArticle() {
        return oldArticle;
    }

    public Article getNewArticle() {
        return newArticle;
    }

    public void setOldArticle(Article oldArticle) {
        this.oldArticle = oldArticle;
    }

    public void setNewArticle(Article newArticle) {
        this.newArticle = newArticle;
    }
}
