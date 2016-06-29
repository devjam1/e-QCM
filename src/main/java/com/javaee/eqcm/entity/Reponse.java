package com.javaee.eqcm.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
public class Reponse {

    @Id
    @GeneratedValue
    private int id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(length = Integer.MAX_VALUE)
    private String contenu;

    private boolean etat;

    @ManyToOne
    private Question question;

    public Reponse() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEtat() {
        return this.etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}