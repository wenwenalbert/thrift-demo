package com.iqiyi.thriftdemo.service.impl;

import com.iqiyi.thriftdemo.service.HelloService;

/**
 * Created by zhaowenbo on 2016/3/7.
 */
public class HelloServiceImpl implements HelloService.Iface {

    public String sayHello(String username) {
        return "Hello " + username;
    }
}
