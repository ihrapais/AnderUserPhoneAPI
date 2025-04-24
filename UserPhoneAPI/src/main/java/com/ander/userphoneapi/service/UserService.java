package com.ander.userphoneapi.service;

import com.ander.userphoneapi.dto.CreateUserDTO;
import com.ander.userphoneapi.dto.UserDTO;
import com.ander.userphoneapi.mapper.PhoneMapper;
import com.ander.userphoneapi.mapper.UserMapper;
import com.ander.userphoneapi.model.Phone;
import com.ander.userphoneapi.model.User;
import com.ander.userphoneapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(CreateUserDTO dto) {
        User user = UserMapper.toEntity(dto);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Transactional
    public UserDTO updateUser(Long id, CreateUserDTO updatedData) {
        System.out.println("Procurando usuário com ID: " + id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("Usuário encontrado: " + user.getName());
        System.out.println("Atualizando nome para: " + updatedData.name());
        user.setName(updatedData.name());
        System.out.println("Atualizando email para: " + updatedData.email());
        user.setEmail(updatedData.email());
        System.out.println("Limpando lista de telefones existente");
        user.getPhones().clear(); // Limpar a coleção existente
        System.out.println("Mapeando novos telefones: " + updatedData.phones());
        List<Phone> updatedPhones = updatedData.phones()
                .stream()
                .map(PhoneMapper::toEntity)
                .peek(phone -> phone.setUser(user))
                .toList();
        System.out.println("Novos telefones mapeados: " + updatedPhones);
        user.getPhones().addAll(updatedPhones); // Adicionar os novos telefones à coleção existente
        System.out.println("Salvando usuário atualizado");
        User savedUser = userRepository.save(user);
        System.out.println("Usuário salvo: " + savedUser.getName());
        return UserMapper.toDTO(savedUser);
    }
}