package com.yakimtsov.axis;

import com.yakimtsov.axis.service.xsd.Article;
import com.yakimtsov.axis.service.xsd.Author;
import com.yakimtsov.axis.service.xsd.Content;
import com.yakimtsov.axis.service.xsd.impl.ArticleImpl;
import com.yakimtsov.axis.service.xsd.impl.AuthorImpl;
import com.yakimtsov.axis.service.xsd.impl.ContentImpl;

import java.util.ArrayList;
import java.util.List;

// Need to implement the interface defined in CrawlingService
public class CrawlingHandler {


    private static class Holder {
        private static final CrawlingHandler INSTANCE = new CrawlingHandler();
    }

    private List<Article> topicList = new ArrayList<>();

    private CrawlingHandler() {
        Author author = Author.Factory.newInstance();
        author.setName("Ivan");
        author.setSurname("Yakimtsov");
        author.setExperience("Student");

        Content content = Content.Factory.newInstance();
        content.setDescription("c++");
        content.setText("C++ language");

        Article article = Article.Factory.newInstance();
        article.setTitle("C++");
        article.setAuthor(author);
        article.setContent(content);

        topicList.add(article);

        article = Article.Factory.newInstance();

        article.setTitle("C++");
        article.setAuthor(author);
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

    public void modifyArticle(Article oldArticle, Article newArticle) {
//        int oldArticleIndex = topicList.indexOf(oldArticle);
//        if (oldArticleIndex != -1) {
//            topicList.set(oldArticleIndex, newArticle);
//        }

        for (int i = 0; i < topicList.size(); i++) {
            Article currentArticle = topicList.get(i);
            boolean condition = currentArticle.getTitle().equals(oldArticle.getTitle())
                    && currentArticle.getAuthor().getName().equals(oldArticle.getAuthor().getName())
                    && currentArticle.getAuthor().getSurname().equals(oldArticle.getAuthor().getSurname())
                    && currentArticle.getAuthor().getExperience().equals(oldArticle.getAuthor().getExperience())
                    && currentArticle.getContent().getText().equals(oldArticle.getContent().getText())
                    && currentArticle.getContent().getDescription().equals(oldArticle.getContent().getDescription());
            if (condition) {
                topicList.set(i, newArticle);
                break;
            }
        }
    }

    public void deleteArticle(Article article) {
        for (int i = 0; i < topicList.size(); i++) {
            Article currentArticle = topicList.get(i);
            boolean condition = currentArticle.getTitle().equals(article.getTitle())
                    && currentArticle.getAuthor().getName().equals(article.getAuthor().getName())
                    && currentArticle.getAuthor().getSurname().equals(article.getAuthor().getSurname())
                    && currentArticle.getAuthor().getExperience().equals(article.getAuthor().getExperience())
                    && currentArticle.getContent().getText().equals(article.getContent().getText())
                    && currentArticle.getContent().getDescription().equals(article.getContent().getDescription());
            if (condition) {
                topicList.remove(i);
                break;
            }
        }

    }

    public static CrawlingHandler getInstance() {
        return Holder.INSTANCE;
    }
}