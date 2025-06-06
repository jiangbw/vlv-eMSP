package com.vlv.application.dto;

import com.vlv.domain.card.Card;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class CardAssignmentResponseDTO {
    private Long cardId;
    private String status;
    private LocalDateTime assignedAt;
    private AccountSummary account;
    private String emaid;
    private Map<String, String> links;

    // 静态内部类 - 账户摘要
    @Data
    @AllArgsConstructor
    public static class AccountSummary {
        private String email;
        private String contractId;
    }

    // 构造方法
    public CardAssignmentResponseDTO(Card card) {
        this.cardId = card.getId();
        this.status = card.getStatus().name();
        this.assignedAt = card.getAssignedAt();
        this.emaid = card.getEmaid();

        this.account = new AccountSummary(
                card.getAccount().getEmail(),
                card.getAccount().getContractId()
        );

        this.links = Map.of(
                "cardDetails", "/api/cards/" + card.getId(),
                "accountDetails", "/api/accounts/" + card.getAccount().getEmail()
        );
    }

    // Getters
}