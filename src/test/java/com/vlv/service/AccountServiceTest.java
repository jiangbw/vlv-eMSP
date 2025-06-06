package com.vlv.service;

import com.vlv.domain.account.Account;
import com.vlv.domain.account.AccountService;
import com.vlv.domain.account.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    void createAccount_ValidEmail_ReturnsAccount() {
        Account savedAccount = new Account();
        savedAccount.setEmail("test@example.com");
        when(accountRepository.save(any())).thenReturn(savedAccount);

        Account accountDto = new Account();
        accountDto.setEmail("test@example.com");
        Account account = accountService.createAccount(accountDto);
        assertNotNull(account);
        assertEquals("test@example.com", account.getEmail());
    }
}
