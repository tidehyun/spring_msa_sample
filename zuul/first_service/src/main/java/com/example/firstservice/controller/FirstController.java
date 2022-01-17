package com.example.firstservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FirstController {

    @GetMapping("/first-service/welcome")
    public String welcome(@RequestHeader(value = "first-service", required = false) String header) {
        log.info("first service header : {}", header);
        return "Welcome to First Service";
    }

    @GetMapping("/first-service/check")
    public String check() {
        return "Hi~ This is First Service";
    }
}
