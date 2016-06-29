package com.javaee.eqcm.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the examenfini database table.
 */
@Entity
public class Examenfini {

    @EmbeddedId
    private ExamenfiniPK id;

    @Temporal(TemporalType.DATE)
    private Date dateExam;

    private boolean fini;

    private int score;

    //bi-directional many-to-one association to Examen
    @ManyToOne
    @JoinColumn(name = "examen_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Examen examen;

    //bi-directional many-to-one association to Utilisateur
    @ManyToOne
    @JoinColumn(name = "etudiant_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Etudiant etudiant;

    public Examenfini() {
    }

    public ExamenfiniPK getId() {
        return this.id;
    }

    public void setId(ExamenfiniPK id) {
        this.id = id;
    }

    public Date getDateExam() {
        return this.dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }

    public boolean isFini() {
        return this.fini;
    }

    public void setFini(boolean fini) {
        this.fini = fini;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Examen getExamen() {
        return this.examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}