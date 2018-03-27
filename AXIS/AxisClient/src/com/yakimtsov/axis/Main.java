package com.yakimtsov.axis;

import com.yakimtsov.axis.controller.ClientManager;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) throws RemoteException {
//        CrawlingServiceStub crawlingServiceStub =
//                new CrawlingServiceStub("http://localhost:8080/axis2/services/CrawlingService?wsdl");
//        CrawlingServiceStub.Author author = new CrawlingServiceStub.Author();
//        author.setName("Ivan");
//        author.setSurname("Yakimtsov");
//        author.setExperience("Student");
//        CrawlingServiceStub.Content content = new CrawlingServiceStub.Content();
//        content.setDescription("c++");
//        content.setText("C++ language");
//        CrawlingServiceStub.Article article = new CrawlingServiceStub.Article();
//        article.setTitle("C++");
//        article.setAuthor(author);
//        article.setContent(content);
//        CrawlingServiceStub.AddArticle addArticle = new CrawlingServiceStub.AddArticle();
//        addArticle.setArgs0(article);
//        crawlingServiceStub.addArticle(addArticle);


//        CrawlingServiceStub.GetArticles getArticles = new CrawlingServiceStub.GetArticles();
//        CrawlingServiceStub.GetArticlesResponse response = crawlingServiceStub.getArticles(getArticles);
//        CrawlingServiceStub.Article[] articles = response.get_return();
//        List<CrawlingServiceStub.Article> articleList = Arrays.asList(articles);
//        articleList.forEach(article -> System.out.println(article.getTitle()));

        new ClientManager().startClient();
    }
}
