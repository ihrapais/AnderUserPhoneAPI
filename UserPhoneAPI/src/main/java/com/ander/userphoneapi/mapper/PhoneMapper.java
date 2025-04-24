package com.ander.userphoneapi.mapper;

import com.ander.userphoneapi.dto.CreatePhoneDTO;
import com.ander.userphoneapi.dto.PhoneDTO;
import com.ander.userphoneapi.model.Phone;

public class PhoneMapper {
    public static PhoneDTO toDTO(Phone phone) {
        return new PhoneDTO(phone.getId(), phone.getNumber());
    }

    public static Phone toEntity(CreatePhoneDTO dto) {
        Phone phone = new Phone();
        phone.setNumber(dto.number());
        return phone;
    }
}