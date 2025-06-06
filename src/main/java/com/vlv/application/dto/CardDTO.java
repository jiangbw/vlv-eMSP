package com.vlv.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CardDTO {
    @NotBlank
    @Size(min = 8, max = 64, message = "UID length must be 8-64 characters")
    private String uid;

    @NotBlank
    @Pattern(regexp = "^CARD-[A-Z0-9]{4}$", message = "Visible Number format: CARD-XXXX")
    private String visibleNumber;
}
