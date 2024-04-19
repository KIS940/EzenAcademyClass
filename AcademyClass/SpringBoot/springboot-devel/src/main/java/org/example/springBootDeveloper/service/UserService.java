package org.example.springBootDeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springBootDeveloper.dto.AddUserRequest;
import org.example.springBootDeveloper.repository.UserRepository;
import org.example.springBootDeveloper.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
}
