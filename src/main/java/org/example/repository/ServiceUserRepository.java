package org.example.repository;

import org.example.model.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceUserRepository extends JpaRepository<ServiceUser, Long> {

    public List<ServiceUser> findByUserId(Long userId);
}