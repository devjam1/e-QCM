package com.javaee.eqcm.service;

import com.javaee.eqcm.entity.*;
import com.javaee.eqcm.repository.GroupeRepository;
import com.javaee.eqcm.repository.RoleRepository;
import com.javaee.eqcm.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InitDbService {

    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private GroupeRepository groupeRepository;

    @PostConstruct
    public void init() {
        if (roleRepository.findByNomRole("ROLE_ADMIN") == null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            Role roleAdmin = new Role();
            roleAdmin.setNomRole("ROLE_ADMIN");
            roleRepository.save(roleAdmin);

            Role roleEnseignant = new Role();
            roleEnseignant.setNomRole("ROLE_ADMIN");
            roleRepository.save(roleEnseignant);

            Role roleEtudiant = new Role();
            roleEtudiant.setNomRole("ROLE_ETUDIANT");
            roleRepository.save(roleEtudiant);

            Administrateur userAdmin = new Administrateur();
            List<Role> roles = new ArrayList<>();
            roles.add(roleAdmin);
            roles.add(roleEnseignant);
            userAdmin.setEnabled(true);
            userAdmin.setLogin("admin");
            userAdmin.setEmail("admin@gmail.com");
            userAdmin.setMdp(encoder.encode("admin"));
            userAdmin.setRoles(roles);
            userRepository.save(userAdmin);

            Enseignant userEnseignant = new Enseignant();
            List<Role> roles1 = new ArrayList<>();
            roles1.add(roleEnseignant);
            userEnseignant.setEnabled(true);
            userEnseignant.setLogin("ens1");
            userEnseignant.setEmail("enseignant@gmail.com");
            userEnseignant.setMdp(encoder.encode("ens1"));
            userEnseignant.setRoles(roles1);
            userRepository.save(userEnseignant);

            Groupe groupe1 = new Groupe();
            groupe1.setNomGroupe("G1");
            groupe1.setAnnee(2016);
            groupe1.setEnseignant(userEnseignant);
            groupeRepository.save(groupe1);


            Etudiant userEtudiant = new Etudiant();
            List<Role> roles2 = new ArrayList<>();
            roles2.add(roleEtudiant);
            userEtudiant.setEnabled(true);
            userEtudiant.setLogin("etu1");
            userEtudiant.setEmail("etudiant@gmail.com");
            userEtudiant.setMdp(encoder.encode("etu1"));
            userEtudiant.setRoles(roles2);
            userEtudiant.setGroupe(groupe1);
            userRepository.save(userEtudiant);

        }
    }
}
