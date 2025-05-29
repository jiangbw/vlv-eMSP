package com.vlv.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssignRequest {
    @NotBlank
    @Email
    private String accountEmail;

    @FutureOrPresent(message = "Assign time cannot be in the past")
    private LocalDateTime assignTime;

    @Pattern(regexp = "EMP\\d{6}", message = "Invalid operator ID format")
    private String operatorId;
}
