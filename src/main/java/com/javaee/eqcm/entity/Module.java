package com.javaee.eqcm.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Module {

	@Id
	@GeneratedValue
	private int id;

	private String nomModule;

	@OneToMany(mappedBy="module")
	private List<Examen> examens;

	@ManyToMany(mappedBy="modules")
	private List<Enseignant> enseignants;

	public Module() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomModule() {
		return this.nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public List<Examen> getExamens() {
		return this.examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
}