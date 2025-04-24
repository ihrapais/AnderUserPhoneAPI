package com.ander.userphoneapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public record CreateUserDTO(
        @NotBlank(message = "Name cannot be blank") String name,
        @NotBlank(message = "Email cannot be blank") @Email(message = "Email must be valid") String email,
        List<CreatePhoneDTO> phones
) {}