package com.rinat.hello.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth-service")
public interface AuthServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/uaa/users/clean", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getCleanFromAuthService();

    @RequestMapping(method = RequestMethod.GET, value = "/uaa/users/ui", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getPwdFromAuthService();

    @RequestMapping(method = RequestMethod.GET, value = "/uaa/users/oa", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getOauthFromAuthService();

    @RequestMapping(method = RequestMethod.GET, value = "/uaa/users/current", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getCurrentFromAuthService();

}
