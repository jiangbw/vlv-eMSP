package com.vlv.service;

import com.vlv.entity.Account;
import com.vlv.entity.AccountStatus;
import com.vlv.entity.Card;
import com.vlv.entity.CardStatus;
import com.vlv.repositories.AccountRepository;
import com.vlv.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    public Card createCard(String uid, String visibleNumber) {
        Card card = new Card();
        card.setUid(uid);
        card.setVisibleNumber(visibleNumber);
        return cardRepository.save(card);
    }

    public Card assignToAccount(Long cardId, String email) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (card.getAccount() != null) {
            throw new RuntimeException("Card already assigned");
        }

        String emaid = generateEMAID(account);
        card.setEmaid(emaid);
        card.setAccount(account);
        card.setStatus(CardStatus.ASSIGNED);
        card.setAssignedAt(LocalDateTime.now());

        account.setNextServiceId(account.getNextServiceId() + 1);
        accountRepository.save(account);

        return cardRepository.save(card);
    }

    private String generateEMAID(Account account) {
        return account.getCountryCode() +
                account.getProviderId() +
                account.getInstance() +
                account.getContractId() +
                String.format("%02d", account.getNextServiceId());
    }

    public Card updateStatus(Long cardId, CardStatus status) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));

        card.setStatus(status);
        return cardRepository.save(card);
    }
}