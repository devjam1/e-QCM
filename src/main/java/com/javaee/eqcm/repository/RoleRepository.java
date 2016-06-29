package com.javaee.eqcm.repository;

import com.javaee.eqcm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByNomRole(String nomRole);
}
