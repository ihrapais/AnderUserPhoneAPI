package com.ander.userphoneapi.controller;

import com.ander.userphoneapi.dto.CreatePhoneDTO;
import com.ander.userphoneapi.dto.PhoneDTO;
import com.ander.userphoneapi.mapper.PhoneMapper;
import com.ander.userphoneapi.model.Phone;
import com.ander.userphoneapi.model.User;
import com.ander.userphoneapi.repository.PhoneRepository;
import com.ander.userphoneapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneRepository phoneRepository;
    private final UserRepository userRepository;

    public PhoneController(PhoneRepository phoneRepository, UserRepository userRepository) {
        this.phoneRepository = phoneRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<PhoneDTO> createPhone(@RequestBody CreatePhoneDTO dto) {
        // Buscar o usuário pelo userId
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.userId()));

        Phone phone = PhoneMapper.toEntity(dto);
        phone.setUser(user); // Associar o telefone ao usuário
        Phone savedPhone = phoneRepository.save(phone);
        return ResponseEntity.status(HttpStatus.CREATED).body(PhoneMapper.toDTO(savedPhone));
    }

    @GetMapping
    public ResponseEntity<List<PhoneDTO>> getAllPhones() {
        List<PhoneDTO> phones = phoneRepository.findAll()
                .stream()
                .map(PhoneMapper::toDTO)
                .toList();
        return ResponseEntity.ok(phones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneDTO> getPhoneById(@PathVariable Long id) {
        return phoneRepository.findById(id)
                .map(PhoneMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}