/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "DEPART")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Depart.findAll", query = "SELECT d FROM Depart d"),
    @NamedQuery(name = "Depart.findById", query = "SELECT d FROM Depart d WHERE d.id = :id"),
    @NamedQuery(name = "Depart.findByMatricule",
        query = "SELECT d FROM Depart d WHERE d.matricule = :matricule"),
    @NamedQuery(name = "Depart.findByDatePai",
        query = "SELECT d FROM Depart d WHERE d.datePai = :datePai"),
    @NamedQuery(name = "Depart.findByDateTrt",
        query = "SELECT d FROM Depart d WHERE d.dateTrt = :dateTrt"),
    @NamedQuery(name = "Depart.findByCodePaie",
        query = "SELECT d FROM Depart d WHERE d.codePaie = :codePaie"),
    @NamedQuery(name = "Depart.findByPreCge",
        query = "SELECT d FROM Depart d WHERE d.preCge = :preCge"),
    @NamedQuery(name = "Depart.findByCodeRub",
        query = "SELECT d FROM Depart d WHERE d.codeRub = :codeRub"),
    @NamedQuery(name = "Depart.findBySensRub",
        query = "SELECT d FROM Depart d WHERE d.sensRub = :sensRub"),
    @NamedQuery(name = "Depart.findByMontant",
        query = "SELECT d FROM Depart d WHERE d.montant = :montant")})
public class Depart implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_PAI")
  private int datePai;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Column(name = "CODE_PAIE")
  private Character codePaie;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "PRE_CGE")
  private BigDecimal preCge;
  @Size(max = 3)
  @Column(name = "CODE_RUB")
  private String codeRub;
  @Column(name = "SENS_RUB")
  private Character sensRub;
  @Column(name = "MONTANT")
  private BigDecimal montant;

  public Depart() {}

  public Depart(Long id) {
    this.id = id;
  }

  public Depart(Long id, int matricule, int datePai, int dateTrt) {
    this.id = id;
    this.matricule = matricule;
    this.datePai = datePai;
    this.dateTrt = dateTrt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public int getDatePai() {
    return datePai;
  }

  public void setDatePai(int datePai) {
    this.datePai = datePai;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public Character getCodePaie() {
    return codePaie;
  }

  public void setCodePaie(Character codePaie) {
    this.codePaie = codePaie;
  }

  public BigDecimal getPreCge() {
    return preCge;
  }

  public void setPreCge(BigDecimal preCge) {
    this.preCge = preCge;
  }

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
  }

  public Character getSensRub() {
    return sensRub;
  }

  public void setSensRub(Character sensRub) {
    this.sensRub = sensRub;
  }

  public BigDecimal getMontant() {
    return montant;
  }

  public void setMontant(BigDecimal montant) {
    this.montant = montant;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Depart)) {
      return false;
    }
    Depart other = (Depart) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.Depart[ id=" + id + " ]";
  }

}
