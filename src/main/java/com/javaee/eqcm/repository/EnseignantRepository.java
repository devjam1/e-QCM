package com.javaee.eqcm.repository;

import com.javaee.eqcm.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
}
