package com.booking_house_be.controller;

import com.booking_house_be.entity.Account;
import com.booking_house_be.entity.Owner;
import com.booking_house_be.entity.Role;
import com.booking_house_be.repository.IRoleRepo;
import com.booking_house_be.service.IAccountService;
import com.booking_house_be.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private IOwnerService ownerService;

    @Autowired
    private IRoleRepo roleRepo;

    @GetMapping("/admins")
    public List<Account> findAdmins() {
        return accountService.findAdmins();
    }

    @GetMapping("/getById/{id}")
    public Account getById(@PathVariable int id) {
        return accountService.getById(id);
    }

    @PutMapping("/{id}")
    public Account edit(@PathVariable int id, @RequestBody Account accountEdit) {
        Account account = accountService.getById(id);
        account.setFirstname(accountEdit.getFirstname());
        account.setLastname(accountEdit.getLastname());
        account.setAddress(accountEdit.getAddress());
        account.setProvince(accountEdit.getProvince());
        account.setDistrict(accountEdit.getDistrict());
        account.setWard(accountEdit.getWard());
        account.setEmail(accountEdit.getEmail());
        account.setPhone(accountEdit.getPhone());
        account.setAvatar(accountEdit.getAvatar());
        accountService.edit(account);
        return account;
    }

    @GetMapping("/getAccountById")
    public ResponseEntity<Optional<Account>> getAccountById(@RequestParam int id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Account> getAccountByUserName(@PathVariable String username) {
        return new ResponseEntity<>(accountService.getAccountByUsername(username), HttpStatus.OK);
    }

    @PutMapping("/changePassword/{id}")
    public Account changePassword(@RequestBody Account accountEdit) {
        Account account = accountService.getById(accountEdit.getId());
        account.setPassword(accountEdit.getPassword());
        accountService.edit(account);
        return account;
    }

    @PostMapping("/checkPassword/{id}")
    public boolean checkPassword(@PathVariable int id, @RequestBody Account accountEdit) {
        Account account = accountService.getById(id);
        if (account.getPassword().equals(accountEdit.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/registerOwner")
    public ResponseEntity<?> registerOwner(@RequestBody Owner owner) {
        Owner ownerCheck = ownerService.getOwnerByAccount(owner.getAccount().getId());
        if (ownerCheck != null) {
            owner.setId(ownerCheck.getId());
        }
        ownerService.save(owner);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getByAccount/{idAccount}")
    public ResponseEntity<?> getByIdAccount(@PathVariable int idAccount) {
        Owner owner = ownerService.getOwnerByAccount(idAccount);
        Owner owner1 = new Owner(owner.getStatus());
        return new ResponseEntity(owner1, HttpStatus.OK);
    }

    @GetMapping("/getRegisterOwner")
    public ResponseEntity<?> getRegisterOwner() {
        return new ResponseEntity<>(ownerService.getAllByStatus("Chờ xác nhận"), HttpStatus.OK);
    }

    @PostMapping("/agreeRegister")
    public ResponseEntity<?> agreeRegister(@RequestBody Owner owner) {
        ownerService.save(owner);
        Account account = owner.getAccount();
        Role role = roleRepo.findById(3);
        account.setRole(role);
        accountService.save(account);
        return new ResponseEntity<>("Xác nhận thành công", HttpStatus.OK);
    }

    @GetMapping("/refuseRegister/{idOwner}")
    public ResponseEntity<?> refuseRegister(@PathVariable int idOwner) {
        Owner owner = ownerService.findOwnerById(idOwner);
        owner.setStatus("Bị từ chối");
        ownerService.save(owner);
        return new ResponseEntity<>("Từ chối thành công", HttpStatus.OK);
    }

}
