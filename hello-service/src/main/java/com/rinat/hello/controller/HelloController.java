package com.rinat.hello.controller;

import com.rinat.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    String getHello() {
        return "Response from hello-service" + '\n';
    }

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    String getInfoFromAuth() {
        return helloService.getSomeInfoFromAuthService();
    }
}
