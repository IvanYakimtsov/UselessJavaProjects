package com.yakimtsov.thrift.controller;

import com.yakimtsov.thrift.model.ThriftClient;
import com.yakimtsov.thrift.service.Article;
import com.yakimtsov.thrift.view.ArticlePanel;
import org.apache.thrift.TException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClientManager {
    private ThriftClient client = new ThriftClient();
    private JFrame mainFrame = new JFrame("Thrift Client");
  //  private ContentPanel contentPanel = new ContentPanel(this);
    private ArticlePanel articlePanel;


    public void startClient(){
        client.start();
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
        try {
            client.getService().addArticle(article);
        } catch (TException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame,
                    e.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public List<Article> getArticles(){
        List<Article> articleList = new ArrayList<>();
        try {
            articleList = client.getService().getArticles();
        } catch (TException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame,
                    e.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
        return articleList;
    }

    public void deleteArticle(Article article){
        try {
            client.getService().deleteArticle(article);
        } catch (TException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame,
                    e.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void modifyArticle(Article oldArticle, Article newArticle){
        try {
            client.getService().modifyArticle(oldArticle,newArticle);
        } catch (TException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame,
                    e.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

}
