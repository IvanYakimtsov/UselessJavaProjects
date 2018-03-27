/*
 * XML Type:  Article
 * Namespace: http://service.axis.yakimtsov.com/xsd
 * Java type: com.yakimtsov.axis.service.xsd.Article
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.xsd;


/**
 * An XML Article(@http://service.axis.yakimtsov.com/xsd).
 *
 * This is a complex type.
 */
public interface Article extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Article.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s399E0AEE354B121DE6A28D1C25429466").resolveHandle("article7b65type");
    
    /**
     * Gets the "author" element
     */
    com.yakimtsov.axis.service.xsd.Author getAuthor();
    
    /**
     * Tests for nil "author" element
     */
    boolean isNilAuthor();
    
    /**
     * True if has "author" element
     */
    boolean isSetAuthor();
    
    /**
     * Sets the "author" element
     */
    void setAuthor(com.yakimtsov.axis.service.xsd.Author author);
    
    /**
     * Appends and returns a new empty "author" element
     */
    com.yakimtsov.axis.service.xsd.Author addNewAuthor();
    
    /**
     * Nils the "author" element
     */
    void setNilAuthor();
    
    /**
     * Unsets the "author" element
     */
    void unsetAuthor();
    
    /**
     * Gets the "content" element
     */
    com.yakimtsov.axis.service.xsd.Content getContent();
    
    /**
     * Tests for nil "content" element
     */
    boolean isNilContent();
    
    /**
     * True if has "content" element
     */
    boolean isSetContent();
    
    /**
     * Sets the "content" element
     */
    void setContent(com.yakimtsov.axis.service.xsd.Content content);
    
    /**
     * Appends and returns a new empty "content" element
     */
    com.yakimtsov.axis.service.xsd.Content addNewContent();
    
    /**
     * Nils the "content" element
     */
    void setNilContent();
    
    /**
     * Unsets the "content" element
     */
    void unsetContent();
    
    /**
     * Gets the "title" element
     */
    java.lang.String getTitle();
    
    /**
     * Gets (as xml) the "title" element
     */
    org.apache.xmlbeans.XmlString xgetTitle();
    
    /**
     * Tests for nil "title" element
     */
    boolean isNilTitle();
    
    /**
     * True if has "title" element
     */
    boolean isSetTitle();
    
    /**
     * Sets the "title" element
     */
    void setTitle(java.lang.String title);
    
    /**
     * Sets (as xml) the "title" element
     */
    void xsetTitle(org.apache.xmlbeans.XmlString title);
    
    /**
     * Nils the "title" element
     */
    void setNilTitle();
    
    /**
     * Unsets the "title" element
     */
    void unsetTitle();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.yakimtsov.axis.service.xsd.Article newInstance() {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Article newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.yakimtsov.axis.service.xsd.Article parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.yakimtsov.axis.service.xsd.Article parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Article parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.xsd.Article parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.xsd.Article parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.xsd.Article) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
