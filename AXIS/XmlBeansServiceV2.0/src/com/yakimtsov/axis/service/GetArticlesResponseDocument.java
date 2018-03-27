/*
 * An XML document type.
 * Localname: getArticlesResponse
 * Namespace: http://service.axis.yakimtsov.com
 * Java type: com.yakimtsov.axis.service.GetArticlesResponseDocument
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service;


/**
 * A document containing one getArticlesResponse(@http://service.axis.yakimtsov.com) element.
 *
 * This is a complex type.
 */
public interface GetArticlesResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetArticlesResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s399E0AEE354B121DE6A28D1C25429466").resolveHandle("getarticlesresponse9cd9doctype");
    
    /**
     * Gets the "getArticlesResponse" element
     */
    com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse getGetArticlesResponse();
    
    /**
     * Sets the "getArticlesResponse" element
     */
    void setGetArticlesResponse(com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse getArticlesResponse);
    
    /**
     * Appends and returns a new empty "getArticlesResponse" element
     */
    com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse addNewGetArticlesResponse();
    
    /**
     * An XML getArticlesResponse(@http://service.axis.yakimtsov.com).
     *
     * This is a complex type.
     */
    public interface GetArticlesResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetArticlesResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s399E0AEE354B121DE6A28D1C25429466").resolveHandle("getarticlesresponse8259elemtype");
        
        /**
         * Gets array of all "return" elements
         */
        com.yakimtsov.axis.service.xsd.Article[] getReturnArray();
        
        /**
         * Gets ith "return" element
         */
        com.yakimtsov.axis.service.xsd.Article getReturnArray(int i);
        
        /**
         * Tests for nil ith "return" element
         */
        boolean isNilReturnArray(int i);
        
        /**
         * Returns number of "return" element
         */
        int sizeOfReturnArray();
        
        /**
         * Sets array of all "return" element
         */
        void setReturnArray(com.yakimtsov.axis.service.xsd.Article[] xreturnArray);
        
        /**
         * Sets ith "return" element
         */
        void setReturnArray(int i, com.yakimtsov.axis.service.xsd.Article xreturn);
        
        /**
         * Nils the ith "return" element
         */
        void setNilReturnArray(int i);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "return" element
         */
        com.yakimtsov.axis.service.xsd.Article insertNewReturn(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "return" element
         */
        com.yakimtsov.axis.service.xsd.Article addNewReturn();
        
        /**
         * Removes the ith "return" element
         */
        void removeReturn(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse newInstance() {
              return (com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.yakimtsov.axis.service.GetArticlesResponseDocument.GetArticlesResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument newInstance() {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.GetArticlesResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.GetArticlesResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
