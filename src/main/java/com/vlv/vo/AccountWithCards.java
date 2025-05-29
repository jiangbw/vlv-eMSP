package com.vlv.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vlv.entity.Account;
import com.vlv.entity.AccountStatus;
import com.vlv.entity.Card;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AccountWithCards {
    private String email;
    private String contractId;
    private AccountStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime lastUpdated;

    private List<CardResponse> cards;

    // 自定义构造函数用于实体转换
    public AccountWithCards(Account account, List<Card> filteredCards) {
        this.email = account.getEmail();
        this.contractId = account.getContractId();
        this.status = account.getStatus();
        this.createdAt = account.getCreatedAt();
        this.lastUpdated = account.getLastUpdated();
        this.cards = filteredCards.stream()
                .map(CardResponse::new)
                .toList();
    }

    // 嵌套的卡片响应类
    @Data
    public static class CardResponse {
        private String uid;
        private String visibleNumber;
        private String emaid;
        private String status;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime assignedAt;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime lastUpdated;

        public CardResponse(Card card) {
            this.uid = card.getUid();
            this.visibleNumber = card.getVisibleNumber();
            this.emaid = card.getEmaid();
            this.status = card.getStatus().name();
            this.assignedAt = card.getAssignedAt();
            this.lastUpdated = card.getLastUpdated();
        }
    }
}