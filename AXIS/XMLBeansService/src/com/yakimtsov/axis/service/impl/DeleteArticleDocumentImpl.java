/*
 * An XML document type.
 * Localname: deleteArticle
 * Namespace: http://service.axis.yakimtsov.com
 * Java type: com.yakimtsov.axis.service.DeleteArticleDocument
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.impl;
/**
 * A document containing one deleteArticle(@http://service.axis.yakimtsov.com) element.
 *
 * This is a complex type.
 */
public class DeleteArticleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.DeleteArticleDocument
{
    private static final long serialVersionUID = 1L;
    
    public DeleteArticleDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DELETEARTICLE$0 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "deleteArticle");
    
    
    /**
     * Gets the "deleteArticle" element
     */
    public com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle getDeleteArticle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle target = null;
            target = (com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle)get_store().find_element_user(DELETEARTICLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "deleteArticle" element
     */
    public void setDeleteArticle(com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle deleteArticle)
    {
        generatedSetterHelperImpl(deleteArticle, DELETEARTICLE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "deleteArticle" element
     */
    public com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle addNewDeleteArticle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle target = null;
            target = (com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle)get_store().add_element_user(DELETEARTICLE$0);
            return target;
        }
    }
    /**
     * An XML deleteArticle(@http://service.axis.yakimtsov.com).
     *
     * This is a complex type.
     */
    public static class DeleteArticleImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle
    {
        private static final long serialVersionUID = 1L;
        
        public DeleteArticleImpl(org.apache.xmlbeans.SchemaType sType)
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
