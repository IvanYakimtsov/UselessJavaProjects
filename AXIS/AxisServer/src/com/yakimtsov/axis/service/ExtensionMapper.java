/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:50 GMT)
 */
package com.yakimtsov.axis.service;


/**
 *  ExtensionMapper class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ExtensionMapper {
    public static java.lang.Object getTypeObject(
        java.lang.String namespaceURI, java.lang.String typeName,
        javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
        if ("http://service.axis.yakimtsov.com/xsd".equals(namespaceURI) &&
                "Content".equals(typeName)) {
            return com.yakimtsov.axis.service.xsd.Content.Factory.parse(reader);
        }

        if ("http://service.axis.yakimtsov.com/xsd".equals(namespaceURI) &&
                "Article".equals(typeName)) {
            return com.yakimtsov.axis.service.xsd.Article.Factory.parse(reader);
        }

        if ("http://service.axis.yakimtsov.com/xsd".equals(namespaceURI) &&
                "Author".equals(typeName)) {
            return com.yakimtsov.axis.service.xsd.Author.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
