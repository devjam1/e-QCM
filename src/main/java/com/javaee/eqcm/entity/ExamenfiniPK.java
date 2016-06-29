package com.javaee.eqcm.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the examenfini database table.
 * 
 */
@Embeddable
public class ExamenfiniPK implements Serializable {

	@Column(name="etudiant_id", insertable=false, updatable=false)
	private int etudiantId;

	@Column(name="examen_id", insertable=false, updatable=false)
	private int examenId;

	public ExamenfiniPK() {
	}
	public int getEtudiantId() {
		return this.etudiantId;
	}
	public void setEtudiantId(int etudiantId) {
		this.etudiantId = etudiantId;
	}
	public int getExamenId() {
		return this.examenId;
	}
	public void setExamenId(int examenId) {
		this.examenId = examenId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ExamenfiniPK)) {
			return false;
		}
		ExamenfiniPK castOther = (ExamenfiniPK)other;
		return 
			(this.etudiantId == castOther.etudiantId)
			&& (this.examenId == castOther.examenId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.etudiantId;
		hash = hash * prime + this.examenId;
		
		return hash;
	}
}