package com.yakimtsov.rest.controller;

import com.yakimtsov.rest.entity.Article;
import com.yakimtsov.rest.model.ClientService;
import com.yakimtsov.rest.view.ArticlePanel;

import javax.swing.*;
import java.util.List;

public class ClientManager {
    private ClientService client = new ClientService();
    private JFrame mainFrame = new JFrame("Thrift Client");
  //  private ContentPanel contentPanel = new ContentPanel(this);
    private ArticlePanel articlePanel;


    public void startClient(){
      //  client.start();
        setUp();
    }

    private void setUp(){
        articlePanel = new ArticlePanel(this);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.add(articlePanel.getPanel());
        mainFrame.setVisible(true);
    }

    public void addArticle(Article article){
        client.addArticle(article);
    }

    public List<Article> getArticles(){
        return client.getArticles();
    }

    public void deleteArticle(Article article){
        client.deleteArticle(article);
    }

    public void modifyArticle(Article oldArticle, Article newArticle){
        client.modifyArticle(oldArticle,newArticle);
    }

}
