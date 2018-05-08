package com.yakimtsov.mvc.rest;

import com.yakimtsov.mvc.entity.Article;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RestConnector {

    private static final String RECEIVE_ARTICLES_URL = "http://localhost:8080/BootServer-0.0.1-SNAPSHOT/manual/articles";
    private static final String GET_ARTICLE_URL = "http://localhost:8080/BootServer-0.0.1-SNAPSHOT/manual/get";
    private static final String ADD_ARTICLE_URL = "http://localhost:8080/BootServer-0.0.1-SNAPSHOT/manual/add";
    private static final String CHANGE_ARTICLE_URL = "http://localhost:8080/BootServer-0.0.1-SNAPSHOT/manual/update";
    private static final String DELETE_ARTICLE_URL = "http://localhost:8080/BootServer-0.0.1-SNAPSHOT/manual/delete";

    private static final String URL_DELIMITER = "/";


    public List<Article> findArticles() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<Article[]> response = restTemplate.getForEntity(RECEIVE_ARTICLES_URL, Article[].class);
        return Arrays.asList(response.getBody());
    }

    public Article findArticle(String articleId) {

        String url = GET_ARTICLE_URL + URL_DELIMITER + articleId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        return restTemplate.getForObject(url, Article.class);
    }

    public void addArticle(Article article) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.put(ADD_ARTICLE_URL, article, Article.class);
    }

    public void changeArticle(Article article) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.postForObject(CHANGE_ARTICLE_URL, article, Article.class);
    }

    public void deleteArticle(String articleName) {

        String url = DELETE_ARTICLE_URL + URL_DELIMITER + articleName;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
    }
}