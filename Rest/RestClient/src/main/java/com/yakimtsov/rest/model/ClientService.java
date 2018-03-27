package com.yakimtsov.rest.model;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.yakimtsov.rest.entity.Article;
import com.yakimtsov.rest.util.UpdateMessage;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class ClientService {
    private static final String GET_ARTICLE_LIST = "http://localhost:8080/rest/service/article-list";
    private static final String ADD_ARTICLE = "http://localhost:8080/rest/service/add-article";
    private static final String DELETE_ARTICLE = "http://localhost:8080/rest/service/delete-article";
    private static final String MODIFY_ARTICLE = "http://localhost:8080/rest/service/modify-article";

    private Client client = Client.create();

    public List<Article> getArticles(){
        WebResource webResource = client.resource(GET_ARTICLE_LIST);
        ClientResponse response = webResource.get(ClientResponse.class);
        return response.getEntity(new GenericType<List<Article>>(){});
    }

    public void addArticle(Article article){
        WebResource webResource = client.resource(ADD_ARTICLE);
        webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, article);
    }

    public void deleteArticle(Article article){
        WebResource webResource = client.resource(DELETE_ARTICLE);
        webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, article);
    }

    public void modifyArticle(Article oldArticle, Article newArticle){
        WebResource webResource = client.resource(MODIFY_ARTICLE);
        UpdateMessage updateMessage = new UpdateMessage(oldArticle,newArticle);
        webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, updateMessage);
    }
}
