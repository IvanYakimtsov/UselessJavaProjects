package com.yakimtsov.rest.service;

import com.yakimtsov.rest.dao.CrawlingHandler;
import com.yakimtsov.rest.entity.Article;
import com.yakimtsov.rest.util.UpdateMessage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/service")
public class RestService {

    private final static CrawlingHandler service = new CrawlingHandler();


    @Path("/add-article") @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addArticle(Article article){
        service.addArticle(article);
       return Response.status(Response.Status.CREATED).build();
    }


    @Path("/delete-article") @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Article article){
        service.deleteArticle(article);
        return Response.status(Response.Status.CREATED).build();
    }


    @Path("/modify-article") @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(UpdateMessage updateMessage){
        service.modifyArticle(updateMessage.getOldArticle(),updateMessage.getNewArticle());
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("/article-list") @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArticles(){
        List<Article> articleList = service.getArticles();
        return Response.status(Response.Status.OK).entity(articleList).build();
    }

}