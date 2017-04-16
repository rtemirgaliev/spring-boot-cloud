package com.rinat.sbcloud.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/clean")
    public String getSomeInfo() {
        return "-> Not secured resource";
    }

    @RequestMapping("/pwd")
    public String getPwd() {
        return "-> Password secured resource";
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping("/oa")
    public String getSecuredInfo() {
        return "-> OAuth secured resource";
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }
}
