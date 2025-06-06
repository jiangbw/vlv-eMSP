package com.vlv.application;

import com.vlv.application.dto.AccountDTO;
import com.vlv.application.dto.AccountStatusDTO;
import com.vlv.domain.account.Account;
import com.vlv.domain.account.AccountFactory;
import com.vlv.domain.account.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountAppService {
    private final AccountService accountService;
    private final AccountFactory accountFactory;

    public AccountAppService(AccountService accountService, AccountFactory accountFactory) {
        this.accountService = accountService;
        this.accountFactory = accountFactory;
    }

    public Account createAccount(AccountDTO accountDTO) {
        Account account = accountFactory.createAccount(accountDTO);
        return accountService.createAccount(account);
    }

    public Account updateStatus(String email, AccountStatusDTO accountStatusDTO) {

        return accountService.updateStatus(email,accountStatusDTO);
    }
}
