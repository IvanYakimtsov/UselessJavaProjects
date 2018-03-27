/*
 * An XML document type.
 * Localname: getArticles
 * Namespace: http://service.axis.yakimtsov.com
 * Java type: com.yakimtsov.axis.service.GetArticlesDocument
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.impl;
/**
 * A document containing one getArticles(@http://service.axis.yakimtsov.com) element.
 *
 * This is a complex type.
 */
public class GetArticlesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.GetArticlesDocument
{
    private static final long serialVersionUID = 1L;
    
    public GetArticlesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETARTICLES$0 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "getArticles");
    
    
    /**
     * Gets the "getArticles" element
     */
    public com.yakimtsov.axis.service.GetArticlesDocument.GetArticles getGetArticles()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.GetArticlesDocument.GetArticles target = null;
            target = (com.yakimtsov.axis.service.GetArticlesDocument.GetArticles)get_store().find_element_user(GETARTICLES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getArticles" element
     */
    public void setGetArticles(com.yakimtsov.axis.service.GetArticlesDocument.GetArticles getArticles)
    {
        generatedSetterHelperImpl(getArticles, GETARTICLES$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "getArticles" element
     */
    public com.yakimtsov.axis.service.GetArticlesDocument.GetArticles addNewGetArticles()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.GetArticlesDocument.GetArticles target = null;
            target = (com.yakimtsov.axis.service.GetArticlesDocument.GetArticles)get_store().add_element_user(GETARTICLES$0);
            return target;
        }
    }
    /**
     * An XML getArticles(@http://service.axis.yakimtsov.com).
     *
     * This is a complex type.
     */
    public static class GetArticlesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.GetArticlesDocument.GetArticles
    {
        private static final long serialVersionUID = 1L;
        
        public GetArticlesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}
