/**
 * CrawlingServiceMessageReceiverInOnly.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package com.yakimtsov.axis;


/**
 *  CrawlingServiceMessageReceiverInOnly message receiver
 */
public class CrawlingServiceMessageReceiverInOnly extends org.apache.axis2.receivers.AbstractMessageReceiver {
    //
    private final org.apache.xmlbeans.XmlOptions _xmlOptions;

    {
        _xmlOptions = new org.apache.xmlbeans.XmlOptions();
        _xmlOptions.setSaveNoXmlDecl();
        _xmlOptions.setSaveAggressiveNamespaces();
        _xmlOptions.setSaveNamespacesFirst();
    }

    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            CrawlingServiceSkeleton skel = (CrawlingServiceSkeleton) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("modifyArticle".equals(methodName)) {
                    //doc style
                    com.yakimtsov.axis.service.ModifyArticleDocument wrappedParam =
                        (com.yakimtsov.axis.service.ModifyArticleDocument) fromOM(msgContext.getEnvelope()
                                                                                            .getBody()
                                                                                            .getFirstElement(),
                            com.yakimtsov.axis.service.ModifyArticleDocument.class);

                    skel.modifyArticle(wrappedParam);

                    envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                } else if ("addArticle".equals(methodName)) {
                    //doc style
                    com.yakimtsov.axis.service.AddArticleDocument wrappedParam = (com.yakimtsov.axis.service.AddArticleDocument) fromOM(msgContext.getEnvelope()
                                                                                                                                                  .getBody()
                                                                                                                                                  .getFirstElement(),
                            com.yakimtsov.axis.service.AddArticleDocument.class);

                    skel.addArticle(wrappedParam);

                    envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                } else if ("deleteArticle".equals(methodName)) {
                    //doc style
                    com.yakimtsov.axis.service.DeleteArticleDocument wrappedParam =
                        (com.yakimtsov.axis.service.DeleteArticleDocument) fromOM(msgContext.getEnvelope()
                                                                                            .getBody()
                                                                                            .getFirstElement(),
                            com.yakimtsov.axis.service.DeleteArticleDocument.class);

                    skel.deleteArticle(wrappedParam);

                    envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    /**
     * Get the {@link org.apache.xmlbeans.XmlOptions} object that the stub uses when
     * serializing objects to XML.
     *
     * @return the options used for serialization
     */
    public org.apache.xmlbeans.XmlOptions _getXmlOptions() {
        return _xmlOptions;
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.ModifyArticleDocument param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        return toOM(param);
    }

    private org.apache.axiom.om.OMElement toOM(
        final com.yakimtsov.axis.service.ModifyArticleDocument param)
        throws org.apache.axis2.AxisFault {
        org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(new javax.xml.transform.sax.SAXSource(
                    new org.apache.axis2.xmlbeans.XmlBeansXMLReader(param,
                        _xmlOptions), new org.xml.sax.InputSource()));

        try {
            return builder.getDocumentElement(true);
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.AddArticleDocument param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        return toOM(param);
    }

    private org.apache.axiom.om.OMElement toOM(
        final com.yakimtsov.axis.service.AddArticleDocument param)
        throws org.apache.axis2.AxisFault {
        org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(new javax.xml.transform.sax.SAXSource(
                    new org.apache.axis2.xmlbeans.XmlBeansXMLReader(param,
                        _xmlOptions), new org.xml.sax.InputSource()));

        try {
            return builder.getDocumentElement(true);
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.DeleteArticleDocument param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        return toOM(param);
    }

    private org.apache.axiom.om.OMElement toOM(
        final com.yakimtsov.axis.service.DeleteArticleDocument param)
        throws org.apache.axis2.AxisFault {
        org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(new javax.xml.transform.sax.SAXSource(
                    new org.apache.axis2.xmlbeans.XmlBeansXMLReader(param,
                        _xmlOptions), new org.xml.sax.InputSource()));

        try {
            return builder.getDocumentElement(true);
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.GetArticlesDocument param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        return toOM(param);
    }

    private org.apache.axiom.om.OMElement toOM(
        final com.yakimtsov.axis.service.GetArticlesDocument param)
        throws org.apache.axis2.AxisFault {
        org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(new javax.xml.transform.sax.SAXSource(
                    new org.apache.axis2.xmlbeans.XmlBeansXMLReader(param,
                        _xmlOptions), new org.xml.sax.InputSource()));

        try {
            return builder.getDocumentElement(true);
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.GetArticlesResponseDocument param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        return toOM(param);
    }

    private org.apache.axiom.om.OMElement toOM(
        final com.yakimtsov.axis.service.GetArticlesResponseDocument param)
        throws org.apache.axis2.AxisFault {
        org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(new javax.xml.transform.sax.SAXSource(
                    new org.apache.axis2.xmlbeans.XmlBeansXMLReader(param,
                        _xmlOptions), new org.xml.sax.InputSource()));

        try {
            return builder.getDocumentElement(true);
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.yakimtsov.axis.service.GetArticlesResponseDocument param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();

        if (param != null) {
            envelope.getBody().addChild(toOM(param, optimizeContent));
        }

        return envelope;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    public org.apache.xmlbeans.XmlObject fromOM(
        org.apache.axiom.om.OMElement param, java.lang.Class type)
        throws org.apache.axis2.AxisFault {
        try {
            if (com.yakimtsov.axis.service.ModifyArticleDocument.class.equals(
                        type)) {
                org.apache.axiom.om.OMXMLStreamReaderConfiguration configuration =
                    new org.apache.axiom.om.OMXMLStreamReaderConfiguration();
                configuration.setPreserveNamespaceContext(true);

                return com.yakimtsov.axis.service.ModifyArticleDocument.Factory.parse(param.getXMLStreamReader(
                        false, configuration));
            }

            if (com.yakimtsov.axis.service.AddArticleDocument.class.equals(type)) {
                org.apache.axiom.om.OMXMLStreamReaderConfiguration configuration =
                    new org.apache.axiom.om.OMXMLStreamReaderConfiguration();
                configuration.setPreserveNamespaceContext(true);

                return com.yakimtsov.axis.service.AddArticleDocument.Factory.parse(param.getXMLStreamReader(
                        false, configuration));
            }

            if (com.yakimtsov.axis.service.DeleteArticleDocument.class.equals(
                        type)) {
                org.apache.axiom.om.OMXMLStreamReaderConfiguration configuration =
                    new org.apache.axiom.om.OMXMLStreamReaderConfiguration();
                configuration.setPreserveNamespaceContext(true);

                return com.yakimtsov.axis.service.DeleteArticleDocument.Factory.parse(param.getXMLStreamReader(
                        false, configuration));
            }

            if (com.yakimtsov.axis.service.GetArticlesDocument.class.equals(
                        type)) {
                org.apache.axiom.om.OMXMLStreamReaderConfiguration configuration =
                    new org.apache.axiom.om.OMXMLStreamReaderConfiguration();
                configuration.setPreserveNamespaceContext(true);

                return com.yakimtsov.axis.service.GetArticlesDocument.Factory.parse(param.getXMLStreamReader(
                        false, configuration));
            }

            if (com.yakimtsov.axis.service.GetArticlesResponseDocument.class.equals(
                        type)) {
                org.apache.axiom.om.OMXMLStreamReaderConfiguration configuration =
                    new org.apache.axiom.om.OMXMLStreamReaderConfiguration();
                configuration.setPreserveNamespaceContext(true);

                return com.yakimtsov.axis.service.GetArticlesResponseDocument.Factory.parse(param.getXMLStreamReader(
                        false, configuration));
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class
