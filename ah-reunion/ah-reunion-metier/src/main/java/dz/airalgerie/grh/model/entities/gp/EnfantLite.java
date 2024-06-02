/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import dz.airalgerie.grh.model.entities.carriere.EnfantPK;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "CAR", name = "ENFANT")
@XmlRootElement

public class EnfantLite implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected EnfantPK enfantPK;
  @Column(name = "DATE_NAIS")
  private LocalDate dateNais;
  @Column(name = "DATE_DECES")
  private LocalDate dateDeces;
  @Column(name = "DROIT_GP")
  private Boolean droitGp;
	@Column(name = "MATRICULE_ENF")
  private Integer matriculeEnf;
  @Column(name = "CODE_CNJ")
  private int codeCnj;
  @Size(min = 1, max = 50)
  @Column(name = "NOM")
  private String nom;
  @PrimaryKeyJoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private PersonnelLite vPers;

  public EnfantLite() {}

  public PersonnelLite getvPers() {
    return vPers;
  }

  public void setvPers(PersonnelLite vPers) {
    this.vPers = vPers;
  }

  public EnfantLite(EnfantPK enfantPK) {
    this.enfantPK = enfantPK;
  }

  public EnfantLite(int matricule, String prenoms) {
    this.enfantPK = new EnfantPK(matricule, prenoms);
  }

  public EnfantPK getEnfantPK() {
    return enfantPK;
  }

  public void setEnfantPK(EnfantPK enfantPK) {
    this.enfantPK = enfantPK;
  }

  public LocalDate getDateNais() {
    return dateNais;
  }

  public void setDateNais(LocalDate dateNais) {
    this.dateNais = dateNais;
  }

  public LocalDate getDateDeces() {
    return dateDeces;
  }

  public void setDateDeces(LocalDate dateDeces) {
    this.dateDeces = dateDeces;
  }

  public Boolean getDroitGp() {
    return droitGp;
  }

  public void setDroitGp(Boolean droitGp) {
    this.droitGp = droitGp;
  }

	public Integer getMatriculeEnf() {
		return matriculeEnf;
	}

	public void setMatriculeEnf(Integer matriculeEnf) {
		this.matriculeEnf = matriculeEnf;
	}

  public int getCodeCnj() {
    return codeCnj;
  }

  public void setCodeCnj(int codeCnj) {
    this.codeCnj = codeCnj;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (enfantPK != null ? enfantPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EnfantLite)) {
      return false;
    }
    EnfantLite other = (EnfantLite) object;
    if ((this.enfantPK == null && other.enfantPK != null)
        || (this.enfantPK != null && !this.enfantPK.equals(other.enfantPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.Enfant[ enfantPK=" + enfantPK + " ]";
  }
}
