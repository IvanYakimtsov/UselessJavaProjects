package com.yakimtsov.mvc.controller;

import com.yakimtsov.mvc.entity.Article;
import com.yakimtsov.mvc.entity.Author;
import com.yakimtsov.mvc.rest.RestConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticlesController {
    private final RestConnector restConnector;

    @Autowired
    public ArticlesController(RestConnector restConnector) {
        this.restConnector = restConnector;
    }

    @RequestMapping("/showArticles")
    public ModelAndView receiveArticles() {
        List<Article> articles = restConnector.findArticles();

        return new ModelAndView("/pages/homePage.jsp", "list", articles);
    }

    @RequestMapping(value = "/showArticle", method = RequestMethod.GET)
    public ModelAndView getArticle(@RequestParam String id) {

        Article article = restConnector.findArticle(id);

        return new ModelAndView("/pages/articlePage.jsp", "entity", article);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView addArticle(@RequestParam String title, @RequestParam String description,
                                   @RequestParam String text, @RequestParam(value = "author_name") String authorName,
                                   @RequestParam(value = "author_surname") String authorSurname,
                                   @RequestParam(value = "author_experience") String authorExperience) {

        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setText(text);

        Author author = new Author();
        author.setName(authorName);
        author.setSurname(authorSurname);
        author.setExperience(authorExperience);

        article.setAuthor(author);

        restConnector.addArticle(article);

        return new ModelAndView("redirect:/showArticles");
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView changeArticle(@RequestParam String title, @RequestParam String description,
                                      @RequestParam String text, @RequestParam(value = "author_name") String authorName,
                                      @RequestParam(value = "author_surname") String authorSurname,
                                      @RequestParam(value = "author_experience") String authorExperience,
                                      @RequestParam long id, @RequestParam(value = "author_id") long authorId) {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setText(text);
        article.setId(id);

        Author author = new Author();
        author.setName(authorName);
        author.setSurname(authorSurname);
        author.setExperience(authorExperience);
        author.setId(id);

        article.setAuthor(author);


        restConnector.changeArticle(article);

        return new ModelAndView("redirect:/showArticles");
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ModelAndView deleteArticle(@RequestParam String id) {

        restConnector.deleteArticle(id);

        return new ModelAndView("redirect:/showArticles");
    }
}