package com.yakimtsov.rest.entity;

public class Article {
    private String uri;
    private String title;
    private Author author;
    private Content content;

    public Article() {

    }

    public Article(String title, Author author, Content content) {
        this.title = title;
        this.author = author;
        this.content = content;
        updateUri();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        updateUri();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        updateUri();
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    private void updateUri() {
        uri = title;
        if (author != null) {
            uri += author.getSurname();
        }

        uri = uri.replaceAll("\\s+","+");
    }

    public String getUri() {
        return uri;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Article article = (Article) obj;
        return this.getTitle().equals(article.getTitle())
                && this.getAuthor().equals(article.getAuthor())
                && this.getContent().equals(article.getContent());

    }
}
