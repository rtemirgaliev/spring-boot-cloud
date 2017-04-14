package com.rinat.hello.service;

import com.rinat.hello.client.AuthServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AuthServiceClient authClient;

    @Override
    public String getCleanInfoFromAuthService() {

        String info = "NULLL";

        log.info("Starting request to Auth...");

        try {
            info =authClient.getCleanFromAuthService();
        } catch (Exception e) {
            log.info("Exception in authClient.getInfoFromAuthService() :  " + e.toString());
        }

        log.info("authClient.getInfoFromAuthService() : " + info);

        return info;
    }


}
