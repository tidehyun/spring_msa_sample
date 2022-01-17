package com.example.secondservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SecondController {
    @RequestMapping("/second-service/welcome")
    public String welcome(@RequestHeader(value = "second-service", required = false) String header) {
        log.info("second service header : {}", header);
        return "Welcome to Second Service";
    }

    @GetMapping("/second-service/check")
    public String check() {
        return "Hi~ This is Second Service";
    }
}
