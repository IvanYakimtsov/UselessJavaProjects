package com.yakimtsov.thrift.dao;

import com.yakimtsov.thrift.service.Article;
import com.yakimtsov.thrift.service.Author;
import com.yakimtsov.thrift.service.Content;
import com.yakimtsov.thrift.service.CrawlingService;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

// Need to implement the interface defined in CrawlingService
public class CrawlingHandler implements CrawlingService.Iface {
    List<Article> topicList = new ArrayList<>();

    public CrawlingHandler() {
        topicList.add(new Article("Java", new Author("Ivan", "Yakimtsov", "Student"),
                new Content("test", "java")));
        topicList.add(new Article("C++", new Author("Ivan", "Yakimtsov", "Student"),
                new Content("test", "c++")));

    }

    @Override
    public void addArticle(Article article) throws TException {
        topicList.add(article);
    }

    @Override
    public List<Article> getArticles() throws TException {
        return topicList;
    }

    @Override
    public void modifyArticle(Article oldArticle, Article newArticle) throws TException {
        int oldArticleIndex = topicList.indexOf(oldArticle);
        if (oldArticleIndex != -1) {
            topicList.set(oldArticleIndex, newArticle);
        }
    }

    @Override
    public void deleteArticle(Article article) throws TException {
        topicList.remove(article);
    }
}