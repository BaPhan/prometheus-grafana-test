package org.project1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class ApiTestController {
    @GetMapping
    public String test(){
        return "baphan test";

    }
}
