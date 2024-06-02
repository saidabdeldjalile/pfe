/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import dz.airalgerie.grh.model.entities.commun.Personnel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "FRAIS_MED", schema = DbSchemaName.GRH_MLD)
@XmlRootElement
public class MldFraisMed implements Serializable {

  private static final long serialVersionUID = 1L;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FM")
  @Temporal(TemporalType.DATE)
  private Date dateFm;
  // @Size(max = 1)
  // @Column(name = "CODE_BENEF")
  // private String codeBenef;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONT_FM")
  private BigDecimal montFm;
  @Size(max = 2)
  @Column(name = "CODE_ACTE")
  private String codeActe;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaisie;
  @Column(name = "DATE_REC_CM")
  @Temporal(TemporalType.DATE)
  private Date dateRecCm;
  @Size(max = 255)
  @Column(name = "OBSERVATION")
  private String observation;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Personnel personnel;
  @JoinColumn(name = "CODE_BENEF", referencedColumnName = "CODE_BENEF")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private MldBeneficiaire beneficiaire;

  public MldFraisMed() {
  }

  public MldFraisMed(Integer id) {
    this.id = id;
  }

  public MldFraisMed(Integer id, int matricule, Date dateFm) {
    this.id = id;
    this.matricule = matricule;
    this.dateFm = dateFm;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDateFm() {
    return dateFm;
  }

  public void setDateFm(Date dateFm) {
    this.dateFm = dateFm;
  }

  public BigDecimal getMontFm() {
    return montFm;
  }

  public void setMontFm(BigDecimal montFm) {
    this.montFm = montFm;
  }

  public String getCodeActe() {
    return codeActe;
  }

  public void setCodeActe(String codeActe) {
    this.codeActe = codeActe;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public Date getDateRecCm() {
    return dateRecCm;
  }

  public void setDateRecCm(Date dateRecCm) {
    this.dateRecCm = dateRecCm;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Personnel getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Personnel personnel) {
    this.personnel = personnel;
  }

  public MldBeneficiaire getBeneficiaire() {
    return beneficiaire;
  }

  public void setBeneficiaire(MldBeneficiaire beneficiaire) {
    this.beneficiaire = beneficiaire;
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
    if (!(object instanceof MldFraisMed)) {
      return false;
    }
    MldFraisMed other = (MldFraisMed) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "grh.maladies.entities.MldFraisMed[ id=" + id + " ]";
  }

}
