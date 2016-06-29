package com.javaee.eqcm.entity;

import javax.persistence.*;
import java.util.List;



@Entity
public class Examen {
	@Id
	@GeneratedValue
	private int id;

	private int annee;

	private int duree;

	private int minScore;

	private int variante;

	@ManyToOne
	private Module module;

	@OneToMany(mappedBy="examen")
	private List<Examenfini> examenfinis;

	@OneToMany(mappedBy="examen",cascade = CascadeType.ALL)
	private List<Question> questions;

	public Examen() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getMinScore() {
		return this.minScore;
	}

	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}

	public int getVariante() {
		return this.variante;
	}

	public void setVariante(int variante) {
		this.variante = variante;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Examenfini> getExamenfinis() {
		return this.examenfinis;
	}

	public void setExamenfinis(List<Examenfini> examenfinis) {
		this.examenfinis = examenfinis;
	}

	public Examenfini addExamenfini(Examenfini examenfini) {
		getExamenfinis().add(examenfini);
		examenfini.setExamen(this);

		return examenfini;
	}

	public Examenfini removeExamenfini(Examenfini examenfini) {
		getExamenfinis().remove(examenfini);
		examenfini.setExamen(null);

		return examenfini;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setExamen(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setExamen(null);

		return question;
	}

}