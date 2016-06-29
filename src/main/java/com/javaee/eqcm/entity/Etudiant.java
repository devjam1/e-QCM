package com.javaee.eqcm.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Etudiant extends Utilisateur{


    @OneToMany(mappedBy="etudiant")
    private List<Examenfini> examenfinis;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    public Etudiant() {
    }

    public List<Examenfini> getExamenfinis() {
        return examenfinis;
    }

    public void setExamenfinis(List<Examenfini> examenfinis) {
        this.examenfinis = examenfinis;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
}
