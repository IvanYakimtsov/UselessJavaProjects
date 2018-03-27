package com.yakimtsov.axis.controller;

import com.yakimtsov.axis.CrawlingServiceStub;
import com.yakimtsov.axis.view.ArticlePanel;
import org.apache.axis2.AxisFault;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientManager {
   // private ThriftClient client = new ThriftClient();
    private JFrame mainFrame = new JFrame("Thrift Client");
  //  private ContentPanel contentPanel = new ContentPanel(this);
    private CrawlingServiceStub crawlingServiceStub;
    private ArticlePanel articlePanel;


    public void startClient(){
      //  client.start();
        try {
            crawlingServiceStub =
                    new CrawlingServiceStub("http://localhost:8080/axis2/services/CrawlingService?wsdl");
            setUp();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }

    }

    private void setUp(){
        articlePanel = new ArticlePanel(this);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.add(articlePanel.getPanel());
        mainFrame.setVisible(true);
    }

    public void addArticle(CrawlingServiceStub.Article article){
        CrawlingServiceStub.AddArticle addArticle = new CrawlingServiceStub.AddArticle();
        addArticle.setArgs0(article);
        try {
            crawlingServiceStub.addArticle(addArticle);
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame,
                    e.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public List<CrawlingServiceStub.Article> getArticles(){
        List<CrawlingServiceStub.Article> articleList = new ArrayList<>();
        try {
            CrawlingServiceStub.GetArticles getArticles = new CrawlingServiceStub.GetArticles();
            CrawlingServiceStub.GetArticlesResponse response = crawlingServiceStub.getArticles(getArticles);
            CrawlingServiceStub.Article[] articles = response.get_return();
            articleList = Arrays.asList(articles);
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame,
                    e.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }

        return articleList;
    }

    public void deleteArticle(CrawlingServiceStub.Article article){
        CrawlingServiceStub.DeleteArticle deleteArticle = new CrawlingServiceStub.DeleteArticle();
        deleteArticle.setArgs0(article);
        try {
            System.out.println("delete");
            crawlingServiceStub.deleteArticle(deleteArticle);
            System.out.println("after delete");
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame,
                    e.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void modifyArticle(CrawlingServiceStub.Article oldArticle, CrawlingServiceStub.Article newArticle){
        CrawlingServiceStub.ModifyArticle modifyArticle = new CrawlingServiceStub.ModifyArticle();
        modifyArticle.setArgs0(oldArticle);
        modifyArticle.setArgs1(newArticle);
        try {
            crawlingServiceStub.modifyArticle(modifyArticle);
        } catch (RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame,
                    e.getMessage(),
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

}
