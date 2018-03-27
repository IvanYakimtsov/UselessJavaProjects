/**
 * CrawlingServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package com.yakimtsov.axis;


/**
 *  CrawlingServiceMessageReceiverInOut message receiver
 */
public class CrawlingServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
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
                if ("getArticles".equals(methodName)) {
                    com.yakimtsov.axis.service.GetArticlesResponse getArticlesResponse14 =
                        null;
                    com.yakimtsov.axis.service.GetArticles wrappedParam = (com.yakimtsov.axis.service.GetArticles) fromOM(msgContext.getEnvelope()
                                                                                                                                    .getBody()
                                                                                                                                    .getFirstElement(),
                            com.yakimtsov.axis.service.GetArticles.class);

                    getArticlesResponse14 = skel.getArticles(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getArticlesResponse14, false,
                            new javax.xml.namespace.QName(
                                "http://service.axis.yakimtsov.com",
                                "getArticlesResponse"));
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.ModifyArticle param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.yakimtsov.axis.service.ModifyArticle.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.AddArticle param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.yakimtsov.axis.service.AddArticle.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.DeleteArticle param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.yakimtsov.axis.service.DeleteArticle.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.GetArticles param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.yakimtsov.axis.service.GetArticles.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        com.yakimtsov.axis.service.GetArticlesResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(com.yakimtsov.axis.service.GetArticlesResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        com.yakimtsov.axis.service.GetArticlesResponse param,
        boolean optimizeContent, javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    com.yakimtsov.axis.service.GetArticlesResponse.MY_QNAME,
                    factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private com.yakimtsov.axis.service.GetArticlesResponse wrapgetArticles() {
        com.yakimtsov.axis.service.GetArticlesResponse wrappedElement = new com.yakimtsov.axis.service.GetArticlesResponse();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (com.yakimtsov.axis.service.AddArticle.class.equals(type)) {
                return com.yakimtsov.axis.service.AddArticle.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.yakimtsov.axis.service.DeleteArticle.class.equals(type)) {
                return com.yakimtsov.axis.service.DeleteArticle.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.yakimtsov.axis.service.GetArticles.class.equals(type)) {
                return com.yakimtsov.axis.service.GetArticles.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.yakimtsov.axis.service.GetArticlesResponse.class.equals(
                        type)) {
                return com.yakimtsov.axis.service.GetArticlesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (com.yakimtsov.axis.service.ModifyArticle.class.equals(type)) {
                return com.yakimtsov.axis.service.ModifyArticle.Factory.parse(param.getXMLStreamReaderWithoutCaching());
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
