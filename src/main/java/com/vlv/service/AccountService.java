package com.vlv.service;

import com.vlv.entity.Account;
import com.vlv.entity.AccountStatus;
import com.vlv.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account createAccount(String email) {
        Account account = new Account();
        account.setEmail(email);
        account.setContractId(generateContractId());
        return accountRepository.save(account);
    }

    private String generateContractId() {
        // Implement Contract ID generation (6-digit unique)
        return String.format("%06d", new Random().nextInt(999999));
    }

    public Account updateStatus(String email, AccountStatus status) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setStatus(status);
        return accountRepository.save(account);
    }
}
