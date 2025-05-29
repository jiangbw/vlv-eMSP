package com.vlv.vo;

import com.vlv.annotations.ValidStatusTransition;
import com.vlv.entity.AccountStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountStatusRequest {
    @NotNull
    @ValidStatusTransition
    private AccountStatus status;
}
