package org.project1.controller;

import org.project1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class ApiTestController {
    @Autowired
    private AccountService accountService;
    @GetMapping
    public String test(){
        return "baphan test";

    }

    @GetMapping("/errors")
    public String getError() {
        try {
            int a = 1;
            float c = a/0;
            return "this is api no error";
        } catch (Exception e) {
            e.printStackTrace();
            return "this is api has error";
        }
    }
    @GetMapping("/errors-shutdown-project")
    public String getErrorShutdown() {
            int a = 1;
            float c = a/0;
            return "bug bug bug!";
    }
    @GetMapping("/accounts")
    public ResponseEntity<?> getAll(){
        return accountService.getAll();

    }
    @GetMapping("/account")
    public ResponseEntity<?> getAcount(@RequestParam String username){
        return accountService.findByUsername(username);
    }
    @GetMapping("/dummy")
    public ResponseEntity<?> dummmy(){
        accountService.dummyData();
        return ResponseEntity.ok().build();
    }


}
