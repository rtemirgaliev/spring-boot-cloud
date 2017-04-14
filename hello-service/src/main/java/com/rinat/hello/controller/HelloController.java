package com.rinat.hello.controller;

import com.rinat.hello.client.AuthServiceClient;
import com.rinat.hello.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AuthServiceClient authClient;

//    @Autowired
//    private HelloService helloService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    String getHello() {
        log.info("..logger in /hello");
        System.out.println("..sout in /hello");
        return "Response from hello-service" + '\n';
    }

    @RequestMapping(path = "/clean", method = RequestMethod.GET)
    String getInfoFromAuth() {
        return authClient.getCleanFromAuthService();
    }

    @RequestMapping(path = "/pwd", method = RequestMethod.GET)
    String getPwdFromAuth() {
        return authClient.getPwdFromAuthService();
    }

    @RequestMapping(path = "/oa", method = RequestMethod.GET)
    String getOaFromAuth() {
        return authClient.getOauthFromAuthService();
    }

}
