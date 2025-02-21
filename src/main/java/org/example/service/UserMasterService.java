package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.usermaster.UserMasterCreateDTO;
import org.example.dto.usermaster.UserMasterDTO;
import org.example.dto.usermaster.UserMasterUpdateDTO;
import org.example.exception.ResourceNotFoundException;
import org.example.mapper.UserMasterMapper;
import org.example.model.UserMaster;
import org.example.repository.UserMasterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMasterService {
    private final UserMasterRepository userMasterRepository;
    private final UserMasterMapper userMasterMapper;

    public UserMasterDTO findById(Long id) {
        UserMaster userMaster = userMasterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserMaster not found with id " + id));
        return userMasterMapper.map(userMaster);
    }

    public UserMasterDTO create(UserMasterCreateDTO dto) {
        UserMaster userMaster = userMasterMapper.map(dto);
        userMaster = userMasterRepository.save(userMaster);
        return userMasterMapper.map(userMaster);
    }

    public UserMasterDTO update(UserMasterUpdateDTO dto, Long id) {
        UserMaster userMaster = userMasterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserMaster not found with id " + id));
        userMasterMapper.update(dto, userMaster);
        userMasterRepository.save(userMaster);
        return userMasterMapper.map(userMaster);
    }

    public void delete(Long id) {
        userMasterRepository.deleteById(id);
    }
}
