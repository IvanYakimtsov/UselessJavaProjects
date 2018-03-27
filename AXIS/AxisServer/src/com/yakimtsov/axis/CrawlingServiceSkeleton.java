/**
 * CrawlingServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package com.yakimtsov.axis;

import com.yakimtsov.axis.service.GetArticlesResponse;
import com.yakimtsov.axis.service.xsd.Article;

import java.util.List;

/**
 *  CrawlingServiceSkeleton java skeleton for the axisService
 */
public class CrawlingServiceSkeleton {
    private final static  CrawlingHandler crawlingHandler = new CrawlingHandler();
    /**
     * Auto generated method signature
     *
     * @param modifyArticle
     * @return
     */
    public void modifyArticle(
        com.yakimtsov.axis.service.ModifyArticle modifyArticle) {
        //TODO : fill this with the necessary business logic
        crawlingHandler.modifyArticle(modifyArticle.getArgs0(),modifyArticle.getArgs1());
    }

    /**
     * Auto generated method signature
     *
     * @param addArticle
     * @return
     */
    public void addArticle(com.yakimtsov.axis.service.AddArticle addArticle) {
        //TODO : fill this with the necessary business logic
        crawlingHandler.addArticle(addArticle.getArgs0());
    }

    /**
     * Auto generated method signature
     *
     * @param deleteArticle
     * @return
     */
    public void deleteArticle(
        com.yakimtsov.axis.service.DeleteArticle deleteArticle) {
        //TODO : fill this with the necessary business logic
        crawlingHandler.deleteArticle(deleteArticle.getArgs0());
    }

    /**
     * Auto generated method signature
     *
     * @param getArticles
     * @return getArticlesResponse
     */
    public com.yakimtsov.axis.service.GetArticlesResponse getArticles(
        com.yakimtsov.axis.service.GetArticles getArticles) {
        //TODO : fill this with the necessary business logic
        GetArticlesResponse response = new GetArticlesResponse();
        List<Article> articles = crawlingHandler.getArticles();
        response.set_return(articles.toArray(new Article[articles.size()]));
       // getArticlesResponse.set_return((Article[]) crawlingHandler.getArticles().toArray());
        System.out.println("show list");
        return response;
    }
}
