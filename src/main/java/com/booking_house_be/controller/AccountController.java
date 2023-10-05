package com.booking_house_be.controller;
import com.booking_house_be.entity.Account;
import com.booking_house_be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/getById/{id}")
    public Account getById(@PathVariable int id) {
        return accountService.getById(id);
    }
    @PutMapping("/{id}")
    public Account edit(@PathVariable int id , @RequestBody Account accountEdit) {
        Account account = accountService.getById(id);
        account.setFirstname(accountEdit.getFirstname());
        account.setLastname(accountEdit.getLastname());
        account.setAddress(accountEdit.getAddress());
        account.setEmail(accountEdit.getEmail());
        account.setPhone(accountEdit.getPhone());
        account.setAvatar(accountEdit.getAvatar());
        accountService.edit(account);
        return account;
    }
    @GetMapping("/getAccountById")
    public ResponseEntity<Optional<Account>> getAccountById(@RequestParam int id){
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<Account> getAccountByUserName(@PathVariable String username){
        return new ResponseEntity<>(accountService.getAccountByUserName(username), HttpStatus.OK);
    }

    @PutMapping("/changePassword/{id}")
    public Account changePassword(@RequestBody Account accountEdit) {
        Account account = accountService.getById(accountEdit.getId());
        account.setPassword(accountEdit.getPassword());
        accountService.edit(account);
        return account;
    }
    @PostMapping("/checkPassword/{id}")
    public boolean checkPassword(@PathVariable int id , @RequestBody Account accountEdit) {
        Account account = accountService.getById(id);
        if (account.getPassword().equals(accountEdit.getPassword())) {
            return true;
        }else  {
            return false;
        }

    }
}
