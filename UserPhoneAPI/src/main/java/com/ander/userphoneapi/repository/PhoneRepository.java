package com.ander.userphoneapi.repository;

import com.ander.userphoneapi.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}