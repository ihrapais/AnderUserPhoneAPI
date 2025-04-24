package com.ander.userphoneapi.controller;

import com.ander.userphoneapi.dto.CreateUserDTO;
import com.ander.userphoneapi.dto.UserDTO;
import com.ander.userphoneapi.mapper.PhoneMapper;
import com.ander.userphoneapi.mapper.UserMapper;
import com.ander.userphoneapi.model.Phone;
import com.ander.userphoneapi.model.User;
import com.ander.userphoneapi.service.UserService;
import com.ander.userphoneapi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO dto) {
        UserDTO createdUser = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody CreateUserDTO updatedData) {
        System.out.println("Recebendo requisição PUT para o ID: " + id);
        try {
            UserDTO updatedUser = userService.updateUser(id, updatedData);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}