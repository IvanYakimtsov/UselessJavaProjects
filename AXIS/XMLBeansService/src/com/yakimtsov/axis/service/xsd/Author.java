/*
 * XML Type:  Author
 * Namespace: http://service.axis.yakimtsov.com/xsd
 * Java type: com.yakimtsov.axis.service.xsd.Author
 *
 * Automatically generated - do not modify.
 */
package com.yakimtsov.axis.service.xsd;


/**
 * An XML Author(@http://service.axis.yakimtsov.com/xsd).
 *
 * This is a complex type.
 */
public interface Author extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Author.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB0C8E22E34DA361BEF8D197EAC5E4FE2").resolveHandle("author612ctype");
    
    /**
     * Gets the "experience" element
     */
    java.lang.String getExperience();
    
    /**
     * Gets (as xml) the "experience" element
     */
    org.apache.xmlbeans.XmlString xgetExperience();
    
    /**
     * Tests for nil "experience" element
     */
    boolean isNilExperience();
    
    /**
     * True if has "experience" element
     */
    boolean isSetExperience();
    
    /**
     * Sets the "experience" element
     */
    void setExperience(java.lang.String experience);
    
    /**
     * Sets (as xml) the "experience" element
     */
    void xsetExperience(org.apache.xmlbeans.XmlString experience);
    
    /**
     * Nils the "experience" element
     */
    void setNilExperience();
    
    /**
     * Unsets the "experience" element
     */
    void unsetExperience();
    
    /**
     * Gets the "name" element
     */
    java.lang.String getName();
    
    /**
     * Gets (as xml) the "name" element
     */
    org.apache.xmlbeans.XmlString xgetName();
    
    /**
     * Tests for nil "name" element
     */
    boolean isNilName();
    
    /**
     * True if has "name" element
     */
    boolean isSetName();
    
    /**
     * Sets the "name" element
     */
    void setName(java.lang.String name);
    
    /**
     * Sets (as xml) the "name" element
     */
    void xsetName(org.apache.xmlbeans.XmlString name);
    
    /**
     * Nils the "name" element
     */
    void setNilName();
    
    /**
     * Unsets the "name" element
     */
    void unsetName();
    
    /**
     * Gets the "surname" element
     */
    java.lang.String getSurname();
    
    /**
     * Gets (as xml) the "surname" element
     */
    org.apache.xmlbeans.XmlString xgetSurname();
    
    /**
     * Tests for nil "surname" element
     */
    boolean isNilSurname();
    
    /**
     * True if has "surname" element
     */
    boolean isSetSurname();
    
    /**
     * Sets the "surname" element
     */
    void setSurname(java.lang.String surname);
    
    /**
     * Sets (as xml) the "surname" element
     */
    void xsetSurname(org.apache.xmlbeans.XmlString surname);
    
    /**
     * Nils the "surname" element
     */
    void setNilSurname();
    
    /**
     * Unsets the "surname" element
     */
    void unsetSurname();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.yakimtsov.axis.service.xsd.Author newInstance() {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Author newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.yakimtsov.axis.service.xsd.Author parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.yakimtsov.axis.service.xsd.Author parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.yakimtsov.axis.service.xsd.Author parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.xsd.Author parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.yakimtsov.axis.service.xsd.Author parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.yakimtsov.axis.service.xsd.Author) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
