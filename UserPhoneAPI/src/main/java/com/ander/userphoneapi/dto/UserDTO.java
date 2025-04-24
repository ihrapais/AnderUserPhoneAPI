package com.ander.userphoneapi.dto;

import java.util.List;

public record UserDTO(Long id, String name, String email, List<PhoneDTO> phones) {}