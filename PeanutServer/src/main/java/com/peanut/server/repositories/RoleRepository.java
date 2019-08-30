package com.peanut.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peanut.server.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    Role findByRole(String role);
}