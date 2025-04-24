package com.ander.userphoneapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePhoneDTO(
        @NotBlank(message = "Phone number cannot be blank")
        String number,

        @NotNull(message = "User ID cannot be null")
        Long userId
) {}