package com.yakimtsov.rest.dao;


import com.yakimtsov.rest.entity.Article;
import com.yakimtsov.rest.entity.Author;
import com.yakimtsov.rest.entity.Content;

import java.util.ArrayList;
import java.util.List;

// Need to implement the interface defined in CrawlingService
public class CrawlingHandler {
    List<Article> topicList = new ArrayList<>();

    public CrawlingHandler() {
        topicList.add(new Article("Java", new Author("Ivan", "Yakimtsov", "Student"),
                new Content("test", "java")));
        topicList.add(new Article("C++", new Author("Ivan", "Yakimtsov", "Student"),
                new Content("test", "c++")));

    }


    public void addArticle(Article article){
        topicList.add(article);
    }


    public List<Article> getArticles(){
        return topicList;
    }

    public void modifyArticle(Article oldArticle, Article newArticle){
        int oldArticleIndex = topicList.indexOf(oldArticle);
        if (oldArticleIndex != -1) {
            topicList.set(oldArticleIndex, newArticle);
        }
    }


    public void deleteArticle(Article article){
        topicList.remove(article);
    }
}