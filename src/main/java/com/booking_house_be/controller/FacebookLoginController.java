package com.booking_house_be.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class FacebookLoginController {
    private static final String REDIRECT_URI = "http://localhost:8080/api/auth/facebook/callback";

}
