package com.javaee.eqcm.repository;

import com.javaee.eqcm.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Utilisateur findByLogin(String login);
}
