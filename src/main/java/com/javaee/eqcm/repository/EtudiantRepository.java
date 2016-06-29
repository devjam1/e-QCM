package com.javaee.eqcm.repository;

import com.javaee.eqcm.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
}
