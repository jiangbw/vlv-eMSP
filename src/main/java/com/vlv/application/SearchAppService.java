package com.vlv.application;

import com.vlv.domain.account.Account;
import com.vlv.domain.account.AccountRepository;
import com.vlv.application.dto.AccountWithCardsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class SearchAppService {
    private final AccountRepository accountRepository;

    public Page<AccountWithCardsDTO> searchByLastUpdated(
            LocalDateTime lastUpdated,
            Pageable pageable
    ) {
        Page<Account> accounts = accountRepository.findByLastUpdatedAfterOrCardsLastUpdatedAfter(
                lastUpdated, pageable
        );

        return accounts.map(account ->
                new AccountWithCardsDTO(account, new ArrayList<>(account.getCards()))
        );
    }
}
