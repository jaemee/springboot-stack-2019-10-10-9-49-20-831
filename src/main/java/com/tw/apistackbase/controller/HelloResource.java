package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/hello")
public class HelloResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @GetMapping(path = "/{userName}", produces = {"application/json"})
    public ResponseEntity<String> getAll(@PathVariable String userName) {

        return ResponseEntity.ok("Hello:" + userName);
    }

    @ResponseBody
    @GetMapping(path = "/test-response-body/{name}", produces = {"application/json"})
    public ResponseTransfer postResponseController(@PathVariable String name) {
        return new ResponseTransfer("Thanks "+ name +" For Posting!!!");
    }

    @PostMapping("/test-request-body")
    public ResponseTransfer requestController(
            @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("Thanks "+ loginForm.getUserName() +" For Requesting!!!");
    }


}
