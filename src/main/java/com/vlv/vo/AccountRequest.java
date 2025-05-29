package com.vlv.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountRequest {
    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "^\\+[0-9]{1,3}-[0-9]{6,12}$", message = "Invalid phone number")
    private String phoneNumber;

    @Size(min = 2, max = 50)
    private String name;
}