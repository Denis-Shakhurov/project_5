package org.example.repository;

import org.example.model.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService, Long> {
}