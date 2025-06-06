package com.vlv.application.dto;

import com.vlv.domain.account.AccountStatus;
import com.vlv.domain.shared.ValidStatusTransition;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountStatusDTO {
    @NotNull
    @ValidStatusTransition
    private AccountStatus status;
}
