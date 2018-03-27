package com.yakimtsov.thrift.view;

import com.yakimtsov.thrift.controller.ClientManager;
import com.yakimtsov.thrift.service.Article;
import com.yakimtsov.thrift.service.Author;
import com.yakimtsov.thrift.service.Content;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ArticlePanel {
    private JPanel panel = new JPanel();
    private JPanel articlePanel = new JPanel();
    private JPanel contentPanel = new JPanel();
    private ClientManager manager;

    private JPanel articleHolderPanel = new JPanel();
    private JPanel contentHolderPanel = new JPanel();

    // private List<JTextArea> valuesList = new ArrayList<>();

    //  private JButton saveButton;

    public ArticlePanel(ClientManager manager) {
        this.manager = manager;
        setUp();
    }

    private void setUp() {
        articlePanel.setLayout(new BorderLayout());
        articlePanel.setPreferredSize(new Dimension(300, 700));
        articlePanel.setBackground(Color.GREEN);
        Container container = new Container();
        container.setLayout(new FlowLayout());
        JButton updateButton = new JButton("update");
        updateButton.addActionListener(e -> updateArticles());
        JButton addArticleButton = new JButton("add");
        addArticleButton.addActionListener(e -> addArticle());
        container.add(updateButton);
        container.add(addArticleButton);
        articlePanel.add(container, BorderLayout.NORTH);
        articlePanel.add(articleHolderPanel, BorderLayout.CENTER);
        updateArticles();

        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
//        JPanel optionPanel = new JPanel();
//        optionPanel.setLayout(new FlowLayout());
//        saveButton = new JButton("Save");
//        optionPanel.add(saveButton);
//        optionPanel.setBackground(Color.CYAN);
//        contentPanel.add(optionPanel, BorderLayout.NORTH);
        contentHolderPanel.setBackground(Color.WHITE);
        contentPanel.add(contentHolderPanel, BorderLayout.CENTER);


        panel.setBackground(Color.CYAN);
        panel.setLayout(new BorderLayout());
        panel.add(articlePanel, BorderLayout.WEST);
        panel.add(contentPanel, BorderLayout.CENTER);
        panel.validate();
        panel.repaint();
    }

    private void updateArticles() {
        articleHolderPanel.removeAll();
        List<Article> articleList = manager.getArticles();

        articleHolderPanel.setLayout(new GridLayout(articleList.size(), 1));

        for (Article article : articleList) {
            Container articleContainer = new Container();
            articleContainer.setLayout(new BorderLayout());

            JButton deleteButton = new JButton("delete");
            deleteButton.addActionListener(e -> {
                manager.deleteArticle(article);
                updateArticles();
            });
            articleContainer.add(deleteButton, BorderLayout.EAST);


            ArticleHolder articleHolder = createArticleHolder(article);

            JButton contentButton = new JButton(article.title + " author: " + article.author.surname);
            contentButton.addActionListener(e -> showContent(articleHolder));
            articleContainer.add(contentButton, BorderLayout.CENTER);

            JButton save = new JButton("save");
            save.addActionListener(e -> {
                save(articleHolder);
                showContent(articleHolder);
            });
            articleContainer.add(save, BorderLayout.WEST);
            articleHolderPanel.add(articleContainer);
        }

        contentHolderPanel.removeAll();
        contentHolderPanel.validate();
        contentHolderPanel.repaint();
        articleHolderPanel.validate();
        articleHolderPanel.repaint();
    }


    private ArticleHolder createArticleHolder(Article article) {
        ArticleHolder articleHolder = new ArticleHolder();

        articleHolder.article = article;

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JTextArea textArea = new JTextArea();
        textArea.append(article.title);
        textArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        articleHolder.valuesList.add(textArea);

        textArea = new JTextArea();
        textArea.append(article.content.description);
        textArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        articleHolder.valuesList.add(textArea);

        textArea = new JTextArea();
        textArea.append(article.content.text);
        textArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        articleHolder.valuesList.add(textArea);

        textArea = new JTextArea();
        textArea.append(article.author.name);
        textArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        articleHolder.valuesList.add(textArea);

        textArea = new JTextArea();
        textArea.append(article.author.surname);
        textArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        articleHolder.valuesList.add(textArea);

        textArea = new JTextArea();
        textArea.append(article.author.experience);
        textArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        articleHolder.valuesList.add(textArea);


        return articleHolder;
    }

    private void addArticle() {
        Article article = new Article("AutoGen article", new Author("Default", "Default", "Default"),
                new Content("Default", "Default"));
        manager.addArticle(article);
        updateArticles();
    }


    private void save(ArticleHolder articleHolder) {
        Article newArticle = new Article(articleHolder.valuesList.get(0).getText(),
                new Author(articleHolder.valuesList.get(3).getText(),
                        articleHolder.valuesList.get(4).getText(),
                        articleHolder.valuesList.get(5).getText()),
                new Content(articleHolder.valuesList.get(1).getText(), articleHolder.valuesList.get(2).getText()));
        manager.modifyArticle(articleHolder.article, newArticle);
        updateArticles();
    }

    private void showContent(ArticleHolder articleHolder) {
        contentHolderPanel.removeAll();
        contentHolderPanel.setLayout(new GridLayout(articleHolder.valuesList.size(), 1));

        articleHolder.valuesList.forEach(contentHolderPanel::add);

        contentHolderPanel.validate();
        contentHolderPanel.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }

    private class ArticleHolder {
        Article article;
        List<JTextArea> valuesList = new ArrayList<>();
    }
}
