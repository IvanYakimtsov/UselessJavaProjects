package com.yakimtsov.rest;

import com.yakimtsov.rest.controller.ClientManager;
import com.yakimtsov.rest.entity.Article;
import com.yakimtsov.rest.model.ClientService;

public class Main {


    public static void main(String... args) {

        //new ClientManager().startClient();
        ClientService service = new ClientService();
        service.getArticles();
        service.addArticle(new Article());
    }
}
