package com.ander.userphoneapi.mapper;

import com.ander.userphoneapi.dto.CreateUserDTO;
import com.ander.userphoneapi.dto.PhoneDTO;
import com.ander.userphoneapi.dto.UserDTO;
import com.ander.userphoneapi.model.Phone;
import com.ander.userphoneapi.model.User;

import java.util.List;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        List<PhoneDTO> phones = user.getPhones()
                .stream()
                .map(PhoneMapper::toDTO)
                .toList();
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), phones);
    }

    public static User toEntity(CreateUserDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        List<Phone> phones = dto.phones()
                .stream()
                .map(PhoneMapper::toEntity)
                .peek(phone -> phone.setUser(user))
                .toList();
        user.setPhones(phones);
        return user;
    }
}