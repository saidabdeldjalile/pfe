/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(schema = "CAR", name = "ACTE")
public class Acte implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_ACT")
  private String codeAct;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "TYPE_ACT")
  private Character typeAct;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "acte", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;
  @OneToMany(mappedBy = "acte", fetch = FetchType.LAZY)
  private List<Discipline> disciplineList;
  @OneToMany(mappedBy = "acte1", fetch = FetchType.LAZY)
  private List<Discipline> disciplineList1;
  @OneToMany(mappedBy = "acte2", fetch = FetchType.LAZY)
  private List<Discipline> disciplineList2;
  @OneToMany(mappedBy = "acte3", fetch = FetchType.LAZY)
  private List<Discipline> disciplineList3;
  @OneToMany(mappedBy = "acte4", fetch = FetchType.LAZY)
  private List<Discipline> disciplineList4;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "acte5", fetch = FetchType.LAZY)
  private List<Discipline> disciplineList5;
  @Column(name = "STATUT")
  private Integer statut;

  public Acte() {}

  public Acte(String codeAct) {
    this.codeAct = codeAct;
  }

  public String getCodeAct() {
    return codeAct;
  }

  public void setCodeAct(String codeAct) {
    this.codeAct = codeAct;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Character getTypeAct() {
    return typeAct;
  }

  public void setTypeAct(Character typeAct) {
    this.typeAct = typeAct;
  }

  @XmlTransient
  public List<Carriere> getCarriereList() {
    return carriereList;
  }

  public void setCarriereList(List<Carriere> carriereList) {
    this.carriereList = carriereList;
  }

  @XmlTransient
  public List<Discipline> getDisciplineList() {
    return disciplineList;
  }

  public void setDisciplineList(List<Discipline> disciplineList) {
    this.disciplineList = disciplineList;
  }

  @XmlTransient
  public List<Discipline> getDisciplineList1() {
    return disciplineList1;
  }

  public void setDisciplineList1(List<Discipline> disciplineList1) {
    this.disciplineList1 = disciplineList1;
  }

  @XmlTransient
  public List<Discipline> getDisciplineList2() {
    return disciplineList2;
  }

  public void setDisciplineList2(List<Discipline> disciplineList2) {
    this.disciplineList2 = disciplineList2;
  }

  @XmlTransient
  public List<Discipline> getDisciplineList3() {
    return disciplineList3;
  }

  public void setDisciplineList3(List<Discipline> disciplineList3) {
    this.disciplineList3 = disciplineList3;
  }

  @XmlTransient
  public List<Discipline> getDisciplineList4() {
    return disciplineList4;
  }

  public void setDisciplineList4(List<Discipline> disciplineList4) {
    this.disciplineList4 = disciplineList4;
  }

  @XmlTransient
  public List<Discipline> getDisciplineList5() {
    return disciplineList5;
  }

  public void setDisciplineList5(List<Discipline> disciplineList5) {
    this.disciplineList5 = disciplineList5;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeAct != null ? codeAct.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Acte)) {
      return false;
    }
    Acte other = (Acte) object;
    if ((this.codeAct == null && other.codeAct != null)
        || (this.codeAct != null && !this.codeAct.equals(other.codeAct))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Acte[ codeAct=" + codeAct + " ]";
  }

}
