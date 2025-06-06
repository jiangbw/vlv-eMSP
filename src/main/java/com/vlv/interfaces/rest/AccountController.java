package com.vlv.interfaces.rest;

import com.vlv.application.AccountAppService;
import com.vlv.application.dto.AccountDTO;
import com.vlv.application.dto.AccountStatusDTO;
import com.vlv.domain.account.Account;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountAppService accountAppService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Valid AccountDTO accountDTO) {
        Account account = accountAppService.createAccount(accountDTO);
        return ResponseEntity.ok(account);
    }

    @PatchMapping("/{email}/status")
    public ResponseEntity<Account> updateAccountStatus(@PathVariable String email, @RequestBody AccountStatusDTO accountStatusDTO) {
        Account account = accountAppService.updateStatus(email, accountStatusDTO);
        return ResponseEntity.ok(account);
    }
}
