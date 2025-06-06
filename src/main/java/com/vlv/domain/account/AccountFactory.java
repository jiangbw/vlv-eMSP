package com.vlv.domain.account;

import com.vlv.application.dto.AccountDTO;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AccountFactory {

    public Account createAccount(AccountDTO accountDTO){
        Account account = new Account();
        account.setEmail(accountDTO.getEmail());
        account.setContractId(generateContractId());
        return account;
    }
    private String generateContractId() {
        // Implement Contract ID generation (6-digit unique)
        return String.format("%06d", new Random().nextInt(999999));
    }

}
