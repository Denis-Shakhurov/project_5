package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.service.ServiceCreateDTO;
import org.example.dto.service.ServiceDTO;
import org.example.dto.service.ServiceUpdateDTO;
import org.example.exception.ResourceNotFoundException;
import org.example.mapper.ServiceUserMapper;
import org.example.model.ServiceUser;
import org.example.repository.ServiceUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUserService {
    private final ServiceUserRepository serviceUserRepository;
    private final ServiceUserMapper serviceUserMapper;

    public List<ServiceDTO> findByUserId(Long userId) {
        return serviceUserRepository.findByUserId(userId)
                .stream()
                .map(serviceUserMapper::map)
                .toList();
    }

    public ServiceDTO create (ServiceCreateDTO dto) {
        ServiceUser serviceUser = serviceUserMapper.map(dto);
        serviceUserRepository.save(serviceUser);
        return serviceUserMapper.map(serviceUser);
    }

    public void update(ServiceUpdateDTO dto, Long id) {
        ServiceUser serviceUser = serviceUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceUser not found with id " + id));
        serviceUserRepository.save(serviceUser);
    }

    public void delete(Long id) {
        serviceUserRepository.deleteById(id);
    }
}
