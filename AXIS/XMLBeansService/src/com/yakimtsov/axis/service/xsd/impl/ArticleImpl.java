/*
 * XML Type:  Article
 * Namespace: http://service.axis.yakimtsov.com/xsd
 * Java type: com.yakimtsov.axis.service.xsd.Article
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.xsd.impl;

import com.yakimtsov.axis.service.xsd.Article;
import org.apache.xmlbeans.XmlObject;

/**
 * An XML Article(@http://service.axis.yakimtsov.com/xsd).
 *
 * This is a complex type.
 */
public class ArticleImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.xsd.Article
{
    private static final long serialVersionUID = 1L;
    
    public ArticleImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AUTHOR$0 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com/xsd", "author");
    private static final javax.xml.namespace.QName CONTENT$2 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com/xsd", "content");
    private static final javax.xml.namespace.QName TITLE$4 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com/xsd", "title");
    
    
    /**
     * Gets the "author" element
     */
    public com.yakimtsov.axis.service.xsd.Author getAuthor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.xsd.Author target = null;
            target = (com.yakimtsov.axis.service.xsd.Author)get_store().find_element_user(AUTHOR$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "author" element
     */
    public boolean isNilAuthor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.xsd.Author target = null;
            target = (com.yakimtsov.axis.service.xsd.Author)get_store().find_element_user(AUTHOR$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * True if has "author" element
     */
    public boolean isSetAuthor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(AUTHOR$0) != 0;
        }
    }
    
    /**
     * Sets the "author" element
     */
    public void setAuthor(com.yakimtsov.axis.service.xsd.Author author)
    {
        generatedSetterHelperImpl(author, AUTHOR$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "author" element
     */
    public com.yakimtsov.axis.service.xsd.Author addNewAuthor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.xsd.Author target = null;
            target = (com.yakimtsov.axis.service.xsd.Author)get_store().add_element_user(AUTHOR$0);
            return target;
        }
    }
    
    /**
     * Nils the "author" element
     */
    public void setNilAuthor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.xsd.Author target = null;
            target = (com.yakimtsov.axis.service.xsd.Author)get_store().find_element_user(AUTHOR$0, 0);
            if (target == null)
            {
                target = (com.yakimtsov.axis.service.xsd.Author)get_store().add_element_user(AUTHOR$0);
            }
            target.setNil();
        }
    }
    
    /**
     * Unsets the "author" element
     */
    public void unsetAuthor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(AUTHOR$0, 0);
        }
    }
    
    /**
     * Gets the "content" element
     */
    public com.yakimtsov.axis.service.xsd.Content getContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.xsd.Content target = null;
            target = (com.yakimtsov.axis.service.xsd.Content)get_store().find_element_user(CONTENT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "content" element
     */
    public boolean isNilContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.xsd.Content target = null;
            target = (com.yakimtsov.axis.service.xsd.Content)get_store().find_element_user(CONTENT$2, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * True if has "content" element
     */
    public boolean isSetContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTENT$2) != 0;
        }
    }
    
    /**
     * Sets the "content" element
     */
    public void setContent(com.yakimtsov.axis.service.xsd.Content content)
    {
        generatedSetterHelperImpl(content, CONTENT$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "content" element
     */
    public com.yakimtsov.axis.service.xsd.Content addNewContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.xsd.Content target = null;
            target = (com.yakimtsov.axis.service.xsd.Content)get_store().add_element_user(CONTENT$2);
            return target;
        }
    }
    
    /**
     * Nils the "content" element
     */
    public void setNilContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.xsd.Content target = null;
            target = (com.yakimtsov.axis.service.xsd.Content)get_store().find_element_user(CONTENT$2, 0);
            if (target == null)
            {
                target = (com.yakimtsov.axis.service.xsd.Content)get_store().add_element_user(CONTENT$2);
            }
            target.setNil();
        }
    }
    
    /**
     * Unsets the "content" element
     */
    public void unsetContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTENT$2, 0);
        }
    }
    
    /**
     * Gets the "title" element
     */
    public java.lang.String getTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "title" element
     */
    public org.apache.xmlbeans.XmlString xgetTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$4, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "title" element
     */
    public boolean isNilTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$4, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * True if has "title" element
     */
    public boolean isSetTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TITLE$4) != 0;
        }
    }
    
    /**
     * Sets the "title" element
     */
    public void setTitle(java.lang.String title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TITLE$4);
            }
            target.setStringValue(title);
        }
    }
    
    /**
     * Sets (as xml) the "title" element
     */
    public void xsetTitle(org.apache.xmlbeans.XmlString title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TITLE$4);
            }
            target.set(title);
        }
    }
    
    /**
     * Nils the "title" element
     */
    public void setNilTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TITLE$4);
            }
            target.setNil();
        }
    }
    
    /**
     * Unsets the "title" element
     */
    public void unsetTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TITLE$4, 0);
        }
    }

}
