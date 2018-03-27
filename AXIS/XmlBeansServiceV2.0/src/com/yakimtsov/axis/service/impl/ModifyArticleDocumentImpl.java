/*
 * An XML document type.
 * Localname: modifyArticle
 * Namespace: http://service.axis.yakimtsov.com
 * Java type: com.yakimtsov.axis.service.ModifyArticleDocument
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.impl;
/**
 * A document containing one modifyArticle(@http://service.axis.yakimtsov.com) element.
 *
 * This is a complex type.
 */
public class ModifyArticleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.ModifyArticleDocument
{
    private static final long serialVersionUID = 1L;
    
    public ModifyArticleDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MODIFYARTICLE$0 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "modifyArticle");
    
    
    /**
     * Gets the "modifyArticle" element
     */
    public com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle getModifyArticle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle target = null;
            target = (com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle)get_store().find_element_user(MODIFYARTICLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "modifyArticle" element
     */
    public void setModifyArticle(com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle modifyArticle)
    {
        generatedSetterHelperImpl(modifyArticle, MODIFYARTICLE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "modifyArticle" element
     */
    public com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle addNewModifyArticle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle target = null;
            target = (com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle)get_store().add_element_user(MODIFYARTICLE$0);
            return target;
        }
    }
    /**
     * An XML modifyArticle(@http://service.axis.yakimtsov.com).
     *
     * This is a complex type.
     */
    public static class ModifyArticleImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle
    {
        private static final long serialVersionUID = 1L;
        
        public ModifyArticleImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ARGS0$0 = 
            new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "args0");
        private static final javax.xml.namespace.QName ARGS1$2 = 
            new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "args1");
        
        
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
        
        /**
         * Gets the "args1" element
         */
        public com.yakimtsov.axis.service.xsd.Article getArgs1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(ARGS1$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Tests for nil "args1" element
         */
        public boolean isNilArgs1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(ARGS1$2, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "args1" element
         */
        public boolean isSetArgs1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ARGS1$2) != 0;
            }
        }
        
        /**
         * Sets the "args1" element
         */
        public void setArgs1(com.yakimtsov.axis.service.xsd.Article args1)
        {
            generatedSetterHelperImpl(args1, ARGS1$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "args1" element
         */
        public com.yakimtsov.axis.service.xsd.Article addNewArgs1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().add_element_user(ARGS1$2);
                return target;
            }
        }
        
        /**
         * Nils the "args1" element
         */
        public void setNilArgs1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(ARGS1$2, 0);
                if (target == null)
                {
                    target = (com.yakimtsov.axis.service.xsd.Article)get_store().add_element_user(ARGS1$2);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "args1" element
         */
        public void unsetArgs1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ARGS1$2, 0);
            }
        }
    }
}
