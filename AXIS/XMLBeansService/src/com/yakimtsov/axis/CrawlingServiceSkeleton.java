/**
 * CrawlingServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package com.yakimtsov.axis;

import com.yakimtsov.axis.service.GetArticlesResponseDocument;
import com.yakimtsov.axis.service.impl.GetArticlesResponseDocumentImpl;
import com.yakimtsov.axis.service.xsd.Article;

import javax.jws.WebService;
import java.util.List;

/**
 *  CrawlingServiceSkeleton java skeleton for the axisService
 */
@WebService
public class CrawlingServiceSkeleton {
    /**
     * Auto generated method signature
     *
     * @param modifyArticle
     * @return
     */
    public void modifyArticle(
        com.yakimtsov.axis.service.ModifyArticleDocument modifyArticle) {
        System.out.println("modifyArticle");
        CrawlingHandler.getInstance().modifyArticle(modifyArticle.getModifyArticle()
                        .getArgs0(), modifyArticle.getModifyArticle().getArgs1());
    }

    /**
     * Auto generated method signature
     *
     * @param addArticle
     * @return
     */
    public void addArticle(
        com.yakimtsov.axis.service.AddArticleDocument addArticle) {
        System.out.println("addArticle");
        Article article = addArticle.getAddArticle().getArgs0();
        CrawlingHandler.getInstance().addArticle(article);
    }

    /**
     * Auto generated method signature
     *
     * @param deleteArticle
     * @return
     */
    public void deleteArticle(
        com.yakimtsov.axis.service.DeleteArticleDocument deleteArticle) {
        System.out.println("deleteArticle");
       CrawlingHandler.getInstance().deleteArticle(deleteArticle.getDeleteArticle().getArgs0());
    }

    /**
     * Auto generated method signature
     *
     * @param getArticles
     * @return getArticlesResponse
     */
    public com.yakimtsov.axis.service.GetArticlesResponseDocument getArticles(
        com.yakimtsov.axis.service.GetArticlesDocument getArticles) {
        System.out.println("getArticles");
        List<Article> articles = CrawlingHandler.getInstance().getArticles();

        com.yakimtsov.axis.service.GetArticlesResponseDocument response
                = com.yakimtsov.axis.service.GetArticlesResponseDocument.Factory.newInstance();

        GetArticlesResponseDocument.GetArticlesResponse getArticlesResponse
                = GetArticlesResponseDocument.GetArticlesResponse.Factory.newInstance();

        getArticlesResponse.setReturnArray(articles.toArray(new Article[articles.size()]));

        response.setGetArticlesResponse(getArticlesResponse);
        return response;
    }
}
