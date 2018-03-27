/**
 * CrawlingServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package com.yakimtsov.axis;

/**
 *  CrawlingServiceSkeleton java skeleton for the axisService
 */
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
//        crawlingHandler.modifyArticle(modifyArticle.getModifyArticle().addNewArgs0(),
//                modifyArticle.getModifyArticle().getArgs1());
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
        //TODO : fill this with the necessary business logic
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
        //TODO : fill this with the necessary business logic
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
        //TODO : fill this with the necessary business logic
        throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#getArticles");
    }
}
