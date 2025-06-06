package com.vlv.domain.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT DISTINCT a FROM Account a  " +
            "WHERE a.email = :email")
    Optional<Account> findByEmail(@Param("email")String email);

    @Query("SELECT DISTINCT a FROM Account a LEFT JOIN a.cards c " +
            "WHERE a.lastUpdated > :lastUpdated OR c.lastUpdated > :lastUpdated")
    Page<Account> findByLastUpdatedAfterOrCardsLastUpdatedAfter(
            @Param("lastUpdated") LocalDateTime lastUpdated,
            Pageable pageable
    );
}
