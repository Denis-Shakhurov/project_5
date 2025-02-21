package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.typeservice.TypeServiceCreateDTO;
import org.example.dto.typeservice.TypeServiceDTO;
import org.example.dto.typeservice.TypeServiceUpdateDTO;
import org.example.mapper.TypeServiceMapper;
import org.example.model.TypeService;
import org.example.repository.TypeServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceService {
    private final TypeServiceRepository typeServiceRepository;
    private final TypeServiceMapper typeServiceMapper;

    public List<TypeServiceDTO> findAll() {
        return typeServiceRepository.findAll()
                .stream()
                .map(typeServiceMapper::map)
                .toList();
    }

    public TypeServiceDTO create(TypeServiceCreateDTO dto) {
        TypeService typeService = typeServiceMapper.map(dto);
        typeServiceRepository.save(typeService);
        return typeServiceMapper.map(typeService);
    }

    public TypeServiceDTO update(TypeServiceUpdateDTO dto, Long id) {
        TypeService typeService = typeServiceRepository.findById(id)
                .orElse(null);
        typeServiceMapper.update(dto, typeService);
        typeServiceRepository.save(typeService);
        return typeServiceMapper.map(typeService);
    }

    public void delete(Long id) {
        typeServiceRepository.deleteById(id);
    }
}
