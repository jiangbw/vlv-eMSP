package com.vlv.domain.account;

import com.vlv.application.dto.AccountStatusDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateStatus(String email, AccountStatusDTO accountStatusDTO) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setStatus(accountStatusDTO.getStatus());
        return accountRepository.save(account);
    }
}
