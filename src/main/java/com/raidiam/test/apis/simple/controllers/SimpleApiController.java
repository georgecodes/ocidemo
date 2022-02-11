package com.raidiam.test.apis.simple.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SimpleApiController {

    @RequestMapping(method = { RequestMethod.GET }, path = "/api/v1/simple", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object account() {
        return Map.of("message", "hello");
    }

}
