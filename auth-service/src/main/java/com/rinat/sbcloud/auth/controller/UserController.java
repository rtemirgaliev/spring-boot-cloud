package com.rinat.sbcloud.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/info")
    public String getSomeInfo() {
        return "Some info from auth service";
    }

}
