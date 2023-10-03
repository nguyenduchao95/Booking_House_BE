package com.booking_house_be.controller;
import com.booking_house_be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;
}
