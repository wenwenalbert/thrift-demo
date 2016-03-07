package com.iqiyi.thriftdemo;

import com.iqiyi.thriftdemo.service.HelloService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final int SERVER_PORT = 9090;
    public static void main( String[] args )
    {
        try {
            TTransport transport = new TSocket("localhost", SERVER_PORT);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);
            logger.info(client.sayHello("wenwen"));
            transport.close();
        } catch (Exception e) {
            logger.warn("", e);
        }
    }
}
