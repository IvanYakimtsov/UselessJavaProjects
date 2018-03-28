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


    @Path("/add-article") @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addArticle(Article article){
        service.addArticle(article);
       return Response.status(Response.Status.CREATED).build();
    }


    @Path("/delete-article/{articleUri}") @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("articleUri") String uri){
        List<Article> articles = service.getArticles();
        for(Article article : articles){
            if(article.getUri().equals(uri)){
                service.deleteArticle(article);
                break;
            }
        }

        return Response.status(Response.Status.OK).build();
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