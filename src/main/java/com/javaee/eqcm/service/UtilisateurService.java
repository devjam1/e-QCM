package com.javaee.eqcm.service;

import com.javaee.eqcm.entity.Etudiant;
import com.javaee.eqcm.entity.Role;
import com.javaee.eqcm.entity.Utilisateur;
import com.javaee.eqcm.repository.RoleRepository;
import com.javaee.eqcm.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Autowired
    private RoleRepository roleRepository;

    public Utilisateur save(Etudiant etudiant) {
        etudiant.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        etudiant.setMdp(encoder.encode(etudiant.getMdp()));
        List<Role> roles = new ArrayList<>();
        roles .add(roleRepository.findByNomRole("ROLE_ETUDIANT"));
        etudiant.setRoles(roles);
        return utilisateurRepository.save(etudiant);
    }

    public Utilisateur findOne(String login) {
        return utilisateurRepository.findByLogin(login);
    }
}
