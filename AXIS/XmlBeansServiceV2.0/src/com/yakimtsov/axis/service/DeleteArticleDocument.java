/*
 * An XML document type.
 * Localname: deleteArticle
 * Namespace: http://service.axis.yakimtsov.com
 * Java type: com.yakimtsov.axis.service.DeleteArticleDocument
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service;


/**
 * A document containing one deleteArticle(@http://service.axis.yakimtsov.com) element.
 *
 * This is a complex type.
 */
public interface DeleteArticleDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DeleteArticleDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s399E0AEE354B121DE6A28D1C25429466").resolveHandle("deletearticleac10doctype");
    
    /**
     * Gets the "deleteArticle" element
     */
    com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle getDeleteArticle();
    
    /**
     * Sets the "deleteArticle" element
     */
    void setDeleteArticle(com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle deleteArticle);
    
    /**
     * Appends and returns a new empty "deleteArticle" element
     */
    com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle addNewDeleteArticle();
    
    /**
     * An XML deleteArticle(@http://service.axis.yakimtsov.com).
     *
     * This is a complex type.
     */
    public interface DeleteArticle extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DeleteArticle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s399E0AEE354B121DE6A28D1C25429466").resolveHandle("deletearticle3787elemtype");
        
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
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle newInstance() {
              return (com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.yakimtsov.axis.service.DeleteArticleDocument.DeleteArticle) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.yakimtsov.axis.service.DeleteArticleDocument newInstance() {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.DeleteArticleDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.DeleteArticleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
