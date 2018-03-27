/*
 * An XML document type.
 * Localname: addArticle
 * Namespace: http://service.axis.yakimtsov.com
 * Java type: com.yakimtsov.axis.service.AddArticleDocument
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.impl;
/**
 * A document containing one addArticle(@http://service.axis.yakimtsov.com) element.
 *
 * This is a complex type.
 */
public class AddArticleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.AddArticleDocument
{
    private static final long serialVersionUID = 1L;
    
    public AddArticleDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDARTICLE$0 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "addArticle");
    
    
    /**
     * Gets the "addArticle" element
     */
    public com.yakimtsov.axis.service.AddArticleDocument.AddArticle getAddArticle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.AddArticleDocument.AddArticle target = null;
            target = (com.yakimtsov.axis.service.AddArticleDocument.AddArticle)get_store().find_element_user(ADDARTICLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "addArticle" element
     */
    public void setAddArticle(com.yakimtsov.axis.service.AddArticleDocument.AddArticle addArticle)
    {
        generatedSetterHelperImpl(addArticle, ADDARTICLE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "addArticle" element
     */
    public com.yakimtsov.axis.service.AddArticleDocument.AddArticle addNewAddArticle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.AddArticleDocument.AddArticle target = null;
            target = (com.yakimtsov.axis.service.AddArticleDocument.AddArticle)get_store().add_element_user(ADDARTICLE$0);
            return target;
        }
    }
    /**
     * An XML addArticle(@http://service.axis.yakimtsov.com).
     *
     * This is a complex type.
     */
    public static class AddArticleImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.AddArticleDocument.AddArticle
    {
        private static final long serialVersionUID = 1L;
        
        public AddArticleImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ARGS0$0 = 
            new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "args0");
        
        
        /**
         * Gets the "args0" element
         */
        public com.yakimtsov.axis.service.xsd.Article getArgs0()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(ARGS0$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Tests for nil "args0" element
         */
        public boolean isNilArgs0()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(ARGS0$0, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "args0" element
         */
        public boolean isSetArgs0()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ARGS0$0) != 0;
            }
        }
        
        /**
         * Sets the "args0" element
         */
        public void setArgs0(com.yakimtsov.axis.service.xsd.Article args0)
        {
            generatedSetterHelperImpl(args0, ARGS0$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "args0" element
         */
        public com.yakimtsov.axis.service.xsd.Article addNewArgs0()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().add_element_user(ARGS0$0);
                return target;
            }
        }
        
        /**
         * Nils the "args0" element
         */
        public void setNilArgs0()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(ARGS0$0, 0);
                if (target == null)
                {
                    target = (com.yakimtsov.axis.service.xsd.Article)get_store().add_element_user(ARGS0$0);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "args0" element
         */
        public void unsetArgs0()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ARGS0$0, 0);
            }
        }
    }
}
