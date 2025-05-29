package com.vlv.vo;

import com.vlv.annotations.ValidStatusTransition;
import com.vlv.entity.AccountStatus;
import com.vlv.entity.CardStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CardStatusRequest {
    @NotNull
    @ValidStatusTransition
    private CardStatus status;
}
