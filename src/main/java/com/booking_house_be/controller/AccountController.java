package com.booking_house_be.controller;
import com.booking_house_be.entity.Account;
import com.booking_house_be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @GetMapping("/getAccountById")
    public ResponseEntity<Optional<Account>> getAccountById(@RequestParam int id){
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<Account> getAccountByUserName(@PathVariable String username){
        return new ResponseEntity<>(accountService.getAccountByUsername(username), HttpStatus.OK);
    }
}
