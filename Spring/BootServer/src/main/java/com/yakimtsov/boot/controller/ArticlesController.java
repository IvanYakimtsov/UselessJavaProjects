package com.yakimtsov.boot.controller;

import com.yakimtsov.boot.database.ArticleRepository;
import com.yakimtsov.boot.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("manual")
public class ArticlesController {
    private ArticleRepository repository;

    @Autowired
    public ArticlesController(ArticleRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getArticles() {
        List<Article> articles = repository.findAll();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Article> getArticle(@PathVariable("id") String id) {

        Long articleId = Long.valueOf(id);
        Optional<Article> article = repository.findById(articleId);

        return article.map(article1 -> new ResponseEntity<>(article1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public ResponseEntity<Void> addArticle(@RequestBody Article article) {
        repository.save(article);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity<Void> updateArticle(@RequestBody Article article) {

        repository.deleteById(article.getId());
        repository.save(article);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") String id) {
        Long articleId = Long.valueOf(id);
        repository.deleteById(articleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}