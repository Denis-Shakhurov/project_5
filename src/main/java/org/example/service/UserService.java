package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.user.UserCreateDTO;
import org.example.dto.user.UserDTO;
import org.example.dto.user.UserUpdateDTO;
import org.example.mapper.UserMapper;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElse(null);
        return userMapper.map(user);
    }

    public UserDTO create(UserCreateDTO dto) {
        User user = userMapper.map(dto);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public UserDTO update(UserUpdateDTO dto, Long id) {
        User user = userRepository.findById(id)
                .orElse(null);
        userMapper.update(dto, user);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
