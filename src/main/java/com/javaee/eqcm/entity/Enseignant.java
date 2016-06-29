package com.javaee.eqcm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Enseignant extends Utilisateur {

    @OneToMany(mappedBy ="enseignant",cascade = CascadeType.ALL)
    private List<Groupe> groupes;

    @ManyToMany
    @JoinTable
    private List<Module> modules;

    public Enseignant() {
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
