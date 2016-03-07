package com.iqiyi.thriftdemo;

import com.iqiyi.thriftdemo.service.HelloService;
import com.iqiyi.thriftdemo.service.impl.HelloServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhaowenbo on 2016/3/7.
 */
public class Server {

    private static  final Logger logger = LoggerFactory.getLogger(Server.class);
    private static final int SERVER_PORT = 9090;
    private static HelloServiceImpl  service;
    private static  HelloService.Processor processor;

    public  static  void main(String[] args) {

        try {
            service = new HelloServiceImpl();
            processor = new HelloService.Processor(service);

            Runnable simple = new Runnable() {
                @Override
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();
        } catch (Exception e) {
            logger.warn("", e);
        }
    }

    public static void simple(HelloService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(SERVER_PORT);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            logger.info("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            logger.warn("", e);
        }
    }
}
