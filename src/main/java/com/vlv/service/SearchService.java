package com.vlv.service;

import com.vlv.entity.Account;
import com.vlv.repositories.AccountRepository;
import com.vlv.vo.AccountWithCards;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final AccountRepository accountRepository;

    public Page<AccountWithCards> searchByLastUpdated(
            LocalDateTime lastUpdated,
            Pageable pageable
    ) {
        Page<Account> accounts = accountRepository.findByLastUpdatedAfterOrCardsLastUpdatedAfter(
                lastUpdated, pageable
        );

        return accounts.map(account ->
                new AccountWithCards(account, new ArrayList<>(account.getCards()))
        );
    }
}