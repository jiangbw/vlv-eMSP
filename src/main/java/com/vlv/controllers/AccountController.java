package com.vlv.controllers;

import com.vlv.entity.Account;
import com.vlv.service.AccountService;
import com.vlv.vo.AccountRequest;
import com.vlv.vo.AccountStatusRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Valid AccountRequest request) {
        Account account = accountService.createAccount(request.getEmail());
        return ResponseEntity.ok(account);
    }

    @PatchMapping("/{email}/status")
    public ResponseEntity<Account> updateAccountStatus(@PathVariable String email, @RequestBody AccountStatusRequest request) {
        Account account = accountService.updateStatus(email, request.getStatus());
        return ResponseEntity.ok(account);
    }
}
