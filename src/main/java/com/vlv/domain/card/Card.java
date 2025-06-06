package com.vlv.domain.card;

import com.vlv.domain.account.Account;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cards") // 明确指定表名
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String uid;
    private String visibleNumber;

    @Column(unique = true)
    private String emaid;

    @Enumerated(EnumType.STRING)
    private CardStatus status = CardStatus.CREATED;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id") // 明确指定外键列名
    private Account account;

    private LocalDateTime assignedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    // Getters and setters
}

