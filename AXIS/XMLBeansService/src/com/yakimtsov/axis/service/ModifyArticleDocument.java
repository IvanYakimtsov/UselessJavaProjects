/*
 * An XML document type.
 * Localname: modifyArticle
 * Namespace: http://service.axis.yakimtsov.com
 * Java type: com.yakimtsov.axis.service.ModifyArticleDocument
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service;


/**
 * A document containing one modifyArticle(@http://service.axis.yakimtsov.com) element.
 *
 * This is a complex type.
 */
public interface ModifyArticleDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ModifyArticleDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB0C8E22E34DA361BEF8D197EAC5E4FE2").resolveHandle("modifyarticle35e1doctype");
    
    /**
     * Gets the "modifyArticle" element
     */
    com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle getModifyArticle();
    
    /**
     * Sets the "modifyArticle" element
     */
    void setModifyArticle(com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle modifyArticle);
    
    /**
     * Appends and returns a new empty "modifyArticle" element
     */
    com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle addNewModifyArticle();
    
    /**
     * An XML modifyArticle(@http://service.axis.yakimtsov.com).
     *
     * This is a complex type.
     */
    public interface ModifyArticle extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ModifyArticle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB0C8E22E34DA361BEF8D197EAC5E4FE2").resolveHandle("modifyarticle8929elemtype");
        
        /**
         * Gets the "args0" element
         */
        com.yakimtsov.axis.service.xsd.Article getArgs0();
        
        /**
         * Tests for nil "args0" element
         */
        boolean isNilArgs0();
        
        /**
         * True if has "args0" element
         */
        boolean isSetArgs0();
        
        /**
         * Sets the "args0" element
         */
        void setArgs0(com.yakimtsov.axis.service.xsd.Article args0);
        
        /**
         * Appends and returns a new empty "args0" element
         */
        com.yakimtsov.axis.service.xsd.Article addNewArgs0();
        
        /**
         * Nils the "args0" element
         */
        void setNilArgs0();
        
        /**
         * Unsets the "args0" element
         */
        void unsetArgs0();
        
        /**
         * Gets the "args1" element
         */
        com.yakimtsov.axis.service.xsd.Article getArgs1();
        
        /**
         * Tests for nil "args1" element
         */
        boolean isNilArgs1();
        
        /**
         * True if has "args1" element
         */
        boolean isSetArgs1();
        
        /**
         * Sets the "args1" element
         */
        void setArgs1(com.yakimtsov.axis.service.xsd.Article args1);
        
        /**
         * Appends and returns a new empty "args1" element
         */
        com.yakimtsov.axis.service.xsd.Article addNewArgs1();
        
        /**
         * Nils the "args1" element
         */
        void setNilArgs1();
        
        /**
         * Unsets the "args1" element
         */
        void unsetArgs1();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle newInstance() {
              return (com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.yakimtsov.axis.service.ModifyArticleDocument.ModifyArticle) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.yakimtsov.axis.service.ModifyArticleDocument newInstance() {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.ModifyArticleDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.ModifyArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
