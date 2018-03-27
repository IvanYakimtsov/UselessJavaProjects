package com.yakimtsov.thrift.model;

import com.yakimtsov.thrift.service.CrawlingService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
;

public class ThriftClient {
    private CrawlingService.Client service;
    private TTransport transport;
    public void start(){
        try {
            transport = new TSocket("localhost", 7911);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            service = new CrawlingService.Client(protocol);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        transport.close();
    }

    public CrawlingService.Client getService() {
        return service;
    }
}