package com.yakimtsov.thrift;

import com.yakimtsov.thrift.controller.ClientManager;
import com.yakimtsov.thrift.model.ThriftClient;
import com.yakimtsov.thrift.service.Article;
import org.apache.thrift.TException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws TException {
        new ClientManager().startClient();
//        ThriftClient thriftClient = new ThriftClient();
//        thriftClient.start();
//        List<Article> list = thriftClient.getService().getArticles();
//        list.forEach(System.out::println);
//        System.out.println("---------------------------------------");
//        thriftClient.service.addArticle(new Article("C#", new Author("Ivan", "Yakimtsov", "Student"),
//                new Content("test", "C#")));
//        list = thriftClient.service.getArticles();
//        list.forEach(System.out::println);
//        System.out.println("---------------------------------------");
//        thriftClient.service.deleteArticle(list.get(0));
//        list = thriftClient.service.getArticles();
//        list.forEach(System.out::println);
//        System.out.println("---------------------------------------");
//        Article rubyArticle = new Article("Ruby", new Author("Ivan", "Yakimtsov", "Student"),
//                new Content("test", "Ruby"));
//        thriftClient.service.modifyArticle(list.get(1),rubyArticle);
//        list = thriftClient.service.getArticles();
//        list.forEach(System.out::println);
    }
}
