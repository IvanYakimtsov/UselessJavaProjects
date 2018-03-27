/*
 * An XML document type.
 * Localname: getArticlesResponse
 * Namespace: http://service.axis.yakimtsov.com
 * Java type: com.yakimtsov.axis.service.GetArticlesResponseDocument
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.impl;
/**
 * A document containing one getArticlesResponse(@http://service.axis.yakimtsov.com) element.
 *
 * This is a complex type.
 */
public class GetArticlesResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.GetArticlesResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public GetArticlesResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETARTICLESRESPONSE$0 = 
        new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "getArticlesResponse");
    
    
    /**
     * Gets the "getArticlesResponse" element
     */
    public com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse getGetArticlesResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse target = null;
            target = (com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse)get_store().find_element_user(GETARTICLESRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getArticlesResponse" element
     */
    public void setGetArticlesResponse(com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse getArticlesResponse)
    {
        generatedSetterHelperImpl(getArticlesResponse, GETARTICLESRESPONSE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "getArticlesResponse" element
     */
    public com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse addNewGetArticlesResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse target = null;
            target = (com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse)get_store().add_element_user(GETARTICLESRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML getArticlesResponse(@http://service.axis.yakimtsov.com).
     *
     * This is a complex type.
     */
    public static class GetArticlesResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse
    {
        private static final long serialVersionUID = 1L;
        
        public GetArticlesResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName RETURN$0 = 
            new javax.xml.namespace.QName("http://service.axis.yakimtsov.com", "return");
        
        
        /**
         * Gets array of all "return" elements
         */
        public com.yakimtsov.axis.service.xsd.Article[] getReturnArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(RETURN$0, targetList);
                com.yakimtsov.axis.service.xsd.Article[] result = new com.yakimtsov.axis.service.xsd.Article[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "return" element
         */
        public com.yakimtsov.axis.service.xsd.Article getReturnArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(RETURN$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Tests for nil ith "return" element
         */
        public boolean isNilReturnArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(RETURN$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.isNil();
            }
        }
        
        /**
         * Returns number of "return" element
         */
        public int sizeOfReturnArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RETURN$0);
            }
        }
        
        /**
         * Sets array of all "return" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setReturnArray(com.yakimtsov.axis.service.xsd.Article[] xreturnArray)
        {
            check_orphaned();
            arraySetterHelper(xreturnArray, RETURN$0);
        }
        
        /**
         * Sets ith "return" element
         */
        public void setReturnArray(int i, com.yakimtsov.axis.service.xsd.Article xreturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(RETURN$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(xreturn);
            }
        }
        
        /**
         * Nils the ith "return" element
         */
        public void setNilReturnArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().find_element_user(RETURN$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setNil();
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "return" element
         */
        public com.yakimtsov.axis.service.xsd.Article insertNewReturn(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().insert_element_user(RETURN$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "return" element
         */
        public com.yakimtsov.axis.service.xsd.Article addNewReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.yakimtsov.axis.service.xsd.Article target = null;
                target = (com.yakimtsov.axis.service.xsd.Article)get_store().add_element_user(RETURN$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "return" element
         */
        public void removeReturn(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RETURN$0, i);
            }
        }
    }
}
