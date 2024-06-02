/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.entities.commun;

import dz.airalgerie.grh.model.entities.carriere.Conjoint;
import dz.airalgerie.grh.model.entities.carriere.Enfant;
import dz.airalgerie.grh.model.entities.carriere.Parent;
import dz.airalgerie.grh.model.entities.carriere.PersACharge;
import dz.airalgerie.grh.model.entities.carriere.Signalitique;
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
@Table(schema = "CAR", name = "PAYS")
public class PaysGrh implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_PAY")
  private String codePay;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(mappedBy = "pays", fetch = FetchType.LAZY)
  private List<Parent> parentList;
  @OneToMany(mappedBy = "pays", fetch = FetchType.LAZY)
  private List<Conjoint> conjointList;
  @OneToMany(mappedBy = "pays1", fetch = FetchType.LAZY)
  private List<Conjoint> conjointList1;
  @OneToMany(mappedBy = "pays", fetch = FetchType.LAZY)
  private List<Signalitique> signalitiqueList;
  @OneToMany(mappedBy = "pays", fetch = FetchType.LAZY)
  private List<PersACharge> persAChargeList;
  @OneToMany(mappedBy = "pays", fetch = FetchType.LAZY)
  private List<Enfant> enfantList;

  public PaysGrh() {}

  public PaysGrh(String codePay) {
    this.codePay = codePay;
  }

  public String getCodePay() {
    return codePay;
  }

  public void setCodePay(String codePay) {
    this.codePay = codePay;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
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
    hash += (codePay != null ? codePay.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PaysGrh)) {
      return false;
    }
    PaysGrh other = (PaysGrh) object;
    if ((this.codePay == null && other.codePay != null)
        || (this.codePay != null && !this.codePay.equals(other.codePay))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.PaysGrh[ codePay=" + codePay + " ]";
  }

}
