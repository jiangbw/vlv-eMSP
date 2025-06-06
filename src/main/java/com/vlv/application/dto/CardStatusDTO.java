package com.vlv.application.dto;

import com.vlv.domain.card.CardStatus;
import com.vlv.domain.shared.ValidStatusTransition;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CardStatusDTO {
    @NotNull
    @ValidStatusTransition
    private CardStatus status;
}
