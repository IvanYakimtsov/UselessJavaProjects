/*
 * XML Type:  Author
 * Namespace: http://service.axis.yakimtsov.com/xsd
 * Java type: com.yakimtsov.axis.service.xsd.Author
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.xsd.impl;
/**
 * An XML Author(@http://service.axis.yakimtsov.com/xsd).
 *
 * This is a complex type.
 */
public class AuthorImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.xsd.Author
{
    private static final long serialVersionUID = 1L;
    
    public AuthorImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXPERIENCE$0 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com/xsd", "experience");
    private static final javax.xml.namespace.QName NAME$2 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com/xsd", "name");
    private static final javax.xml.namespace.QName SURNAME$4 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com/xsd", "surname");
    
    
    /**
     * Gets the "experience" element
     */
    public java.lang.String getExperience()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXPERIENCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "experience" element
     */
    public org.apache.xmlbeans.XmlString xgetExperience()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXPERIENCE$0, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "experience" element
     */
    public boolean isNilExperience()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXPERIENCE$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * True if has "experience" element
     */
    public boolean isSetExperience()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(EXPERIENCE$0) != 0;
        }
    }
    
    /**
     * Sets the "experience" element
     */
    public void setExperience(java.lang.String experience)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXPERIENCE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXPERIENCE$0);
            }
            target.setStringValue(experience);
        }
    }
    
    /**
     * Sets (as xml) the "experience" element
     */
    public void xsetExperience(org.apache.xmlbeans.XmlString experience)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXPERIENCE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXPERIENCE$0);
            }
            target.set(experience);
        }
    }
    
    /**
     * Nils the "experience" element
     */
    public void setNilExperience()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXPERIENCE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXPERIENCE$0);
            }
            target.setNil();
        }
    }
    
    /**
     * Unsets the "experience" element
     */
    public void unsetExperience()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(EXPERIENCE$0, 0);
        }
    }
    
    /**
     * Gets the "name" element
     */
    public java.lang.String getName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "name" element
     */
    public org.apache.xmlbeans.XmlString xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$2, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "name" element
     */
    public boolean isNilName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$2, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * True if has "name" element
     */
    public boolean isSetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NAME$2) != 0;
        }
    }
    
    /**
     * Sets the "name" element
     */
    public void setName(java.lang.String name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAME$2);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" element
     */
    public void xsetName(org.apache.xmlbeans.XmlString name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$2);
            }
            target.set(name);
        }
    }
    
    /**
     * Nils the "name" element
     */
    public void setNilName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$2);
            }
            target.setNil();
        }
    }
    
    /**
     * Unsets the "name" element
     */
    public void unsetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NAME$2, 0);
        }
    }
    
    /**
     * Gets the "surname" element
     */
    public java.lang.String getSurname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SURNAME$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "surname" element
     */
    public org.apache.xmlbeans.XmlString xgetSurname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SURNAME$4, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "surname" element
     */
    public boolean isNilSurname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SURNAME$4, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * True if has "surname" element
     */
    public boolean isSetSurname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SURNAME$4) != 0;
        }
    }
    
    /**
     * Sets the "surname" element
     */
    public void setSurname(java.lang.String surname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SURNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SURNAME$4);
            }
            target.setStringValue(surname);
        }
    }
    
    /**
     * Sets (as xml) the "surname" element
     */
    public void xsetSurname(org.apache.xmlbeans.XmlString surname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SURNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SURNAME$4);
            }
            target.set(surname);
        }
    }
    
    /**
     * Nils the "surname" element
     */
    public void setNilSurname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SURNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SURNAME$4);
            }
            target.setNil();
        }
    }
    
    /**
     * Unsets the "surname" element
     */
    public void unsetSurname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SURNAME$4, 0);
        }
    }
}
