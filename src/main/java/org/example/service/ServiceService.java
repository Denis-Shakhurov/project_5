package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repository.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

}
