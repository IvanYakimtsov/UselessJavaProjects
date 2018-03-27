package com.yakimtsov.axis;

import com.yakimtsov.axis.service.xsd.Article;
import com.yakimtsov.axis.service.xsd.Author;
import com.yakimtsov.axis.service.xsd.Content;

import java.util.ArrayList;
import java.util.List;

// Need to implement the interface defined in CrawlingService
public class CrawlingHandler {
    List<Article> topicList = new ArrayList<>();

    public CrawlingHandler() {
        Author author = new Author();
        author.setName("Ivan");
        author.setSurname("Yakimtsov");
        author.setExperience("Student");
        Content content = new Content();
        content.setDescription("c++");
        content.setText("C++ language");
        Article article = new Article();
        article.setTitle("Java");
        article.setAuthor(author);
        article.setContent(content);

        topicList.add(article);

        content.setDescription("java");
        content.setText("JAVA language");
        article.setContent(content);
        topicList.add(article);

    }

    public void addArticle(Article article) {
        topicList.add(article);
    }

    public List<Article> getArticles() {
        return topicList;
    }

    public void modifyArticle(Article oldArticle, Article newArticle)  {
        int oldArticleIndex = topicList.indexOf(oldArticle);
        if (oldArticleIndex != -1) {
            topicList.set(oldArticleIndex, newArticle);
        }
    }

    public void deleteArticle(Article article) {
        topicList.remove(article);
    }
}