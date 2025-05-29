package com.vlv.service;

import com.vlv.entity.Account;
import com.vlv.repositories.AccountRepository;
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

        Account account = accountService.createAccount("test@example.com");
        assertNotNull(account);
        assertEquals("test@example.com", account.getEmail());
    }
}
