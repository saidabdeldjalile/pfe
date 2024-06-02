/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "CODE_GEOGRAPHIQUE")
public class CodeGeographique implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_GEO")
  private Integer codeGeo;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Column(name = "CODE_DAIRA")
  private String codeDaira;
  @Column(name = "CODE_POSTAL")
  private String codePostal;
  @Column(name = "STATUT")
  private Integer statut;
  @OneToMany(mappedBy = "codeGeographique", fetch = FetchType.LAZY)
  private List<Parent> parentList;
  @OneToMany(mappedBy = "codeGeographique", fetch = FetchType.LAZY)
  private List<Conjoint> conjointList;
  @OneToMany(mappedBy = "codeGeographique1", fetch = FetchType.LAZY)
  private List<Conjoint> conjointList1;
  @OneToMany(mappedBy = "codeGeographique", fetch = FetchType.LAZY)
  private List<Signalitique> signalitiqueList;
  @OneToMany(mappedBy = "LIEU_NAIS", fetch = FetchType.LAZY)
  private List<Signalitique> signalitiqueList1;
  @OneToMany(mappedBy = "codeGeographique", fetch = FetchType.LAZY)
  private List<PersACharge> persAChargeList;
  @OneToMany(mappedBy = "codeGeographique", fetch = FetchType.LAZY)
  private List<Enfant> enfantList;

  public CodeGeographique() {}

  public CodeGeographique(Integer codeGeo) {
    this.codeGeo = codeGeo;
  }

  public Integer getCodeGeo() {
    return codeGeo;
  }

  public void setCodeGeo(Integer codeGeo) {
    this.codeGeo = codeGeo;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public String getCodeDaira() {
    return codeDaira;
  }

  public void setCodeDaira(String codeDaira) {
    this.codeDaira = codeDaira;
  }

  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  @XmlTransient
  public List<Parent> getParentList() {
    return parentList;
  }

  public void setParentList(List<Parent> parentList) {
    this.parentList = parentList;
  }

  @XmlTransient
  public List<Conjoint> getConjointList() {
    return conjointList;
  }

  public void setConjointList(List<Conjoint> conjointList) {
    this.conjointList = conjointList;
  }

  @XmlTransient
  public List<Conjoint> getConjointList1() {
    return conjointList1;
  }

  public void setConjointList1(List<Conjoint> conjointList1) {
    this.conjointList1 = conjointList1;
  }

  @XmlTransient
  public List<Signalitique> getSignalitiqueList() {
    return signalitiqueList;
  }

  public void setSignalitiqueList(List<Signalitique> signalitiqueList) {
    this.signalitiqueList = signalitiqueList;
  }

  @XmlTransient
  public List<Signalitique> getSignalitiqueList1() {
    return signalitiqueList1;
  }

  public void setSignalitiqueList1(List<Signalitique> signalitiqueList1) {
    this.signalitiqueList1 = signalitiqueList1;
  }

  @XmlTransient
  public List<PersACharge> getPersAChargeList() {
    return persAChargeList;
  }

  public void setPersAChargeList(List<PersACharge> persAChargeList) {
    this.persAChargeList = persAChargeList;
  }

  @XmlTransient
  public List<Enfant> getEnfantList() {
    return enfantList;
  }

  public void setEnfantList(List<Enfant> enfantList) {
    this.enfantList = enfantList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeGeo != null ? codeGeo.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CodeGeographique)) {
      return false;
    }
    CodeGeographique other = (CodeGeographique) object;
    if ((this.codeGeo == null && other.codeGeo != null)
        || (this.codeGeo != null && !this.codeGeo.equals(other.codeGeo))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.CodeGeographique[ codeGeo=" + codeGeo + " ]";
  }

}
