package com.javaee.eqcm.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
public class Question {

	@Id
	@GeneratedValue
	private int id;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(length = Integer.MAX_VALUE)
	private String descReponse;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(length = Integer.MAX_VALUE)
	private String ennonce;

	//bi-directional many-to-one association to Examen
	@ManyToOne
	private Examen examen;

	//bi-directional many-to-one association to Reponse
	@OneToMany(mappedBy="question")
	private List<Reponse> reponses;

	public Question() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescReponse() {
		return this.descReponse;
	}

	public void setDescReponse(String descReponse) {
		this.descReponse = descReponse;
	}

	public String getEnnonce() {
		return this.ennonce;
	}

	public void setEnnonce(String ennonce) {
		this.ennonce = ennonce;
	}

	public Examen getExamen() {
		return this.examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public List<Reponse> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public Reponse addRepons(Reponse repons) {
		getReponses().add(repons);
		repons.setQuestion(this);

		return repons;
	}

	public Reponse removeRepons(Reponse repons) {
		getReponses().remove(repons);
		repons.setQuestion(null);

		return repons;
	}

}