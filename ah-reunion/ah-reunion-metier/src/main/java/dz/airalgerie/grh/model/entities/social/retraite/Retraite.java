/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.retraite;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DEV
 */
@Entity
@Table(name = "RETRAITE", schema = "RET")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Retraite.findAll", query = "SELECT r FROM Retraite r"),
    @NamedQuery(name = "Retraite.findByMatricule",
        query = "SELECT r FROM Retraite r WHERE r.retraitePK.matricule = :matricule"),
    @NamedQuery(name = "Retraite.findByAnneePaie",
        query = "SELECT r FROM Retraite r WHERE r.retraitePK.anneePaie = :anneePaie"),
    @NamedQuery(name = "Retraite.findByCodeWil",
        query = "SELECT r FROM Retraite r WHERE r.retraitePK.codeWil = :codeWil"),
    @NamedQuery(name = "Retraite.findByAnneeTrt",
        query = "SELECT r FROM Retraite r WHERE r.anneeTrt = :anneeTrt"),
    @NamedQuery(name = "Retraite.findByActAnnuel",
        query = "SELECT r FROM Retraite r WHERE r.actAnnuel = :actAnnuel"),
    @NamedQuery(name = "Retraite.findByCodeDas",
        query = "SELECT r FROM Retraite r WHERE r.codeDas = :codeDas"),
    @NamedQuery(name = "Retraite.findByMontDas",
        query = "SELECT r FROM Retraite r WHERE r.montDas = :montDas"),
    @NamedQuery(name = "Retraite.findByDateEntree",
        query = "SELECT r FROM Retraite r WHERE r.dateEntree = :dateEntree"),
    @NamedQuery(name = "Retraite.findByDateSortie",
        query = "SELECT r FROM Retraite r WHERE r.dateSortie = :dateSortie"),
    @NamedQuery(name = "Retraite.findByCodeInvest",
        query = "SELECT r FROM Retraite r WHERE r.codeInvest = :codeInvest"),
    @NamedQuery(name = "Retraite.findByDateSaisie",
        query = "SELECT r FROM Retraite r WHERE r.dateSaisie = :dateSaisie")})
public class Retraite implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected RetraitePK retraitePK;
  @Column(name = "ANNEE_TRT")
  private Integer anneeTrt;
  @Column(name = "ACT_ANNUEL")
  private Integer actAnnuel;
  @Size(max = 3)
  @Column(name = "CODE_DAS")
  private String codeDas;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONT_DAS")
  private BigDecimal montDas;
  @Column(name = "DATE_ENTREE")
  @Temporal(TemporalType.DATE)
  private Date dateEntree;
  @Column(name = "DATE_SORTIE")
  @Temporal(TemporalType.DATE)
  private Date dateSortie;
  @Column(name = "CODE_INVEST")
  private Integer codeInvest;
  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.DATE)
  private Date dateSaisie;

  public Retraite() {}

  public Retraite(RetraitePK retraitePK) {
    this.retraitePK = retraitePK;
  }

  public Retraite(int matricule, int anneePaie, String codeWil) {
    this.retraitePK = new RetraitePK(matricule, anneePaie, codeWil);
  }

  public RetraitePK getRetraitePK() {
    return retraitePK;
  }

  public void setRetraitePK(RetraitePK retraitePK) {
    this.retraitePK = retraitePK;
  }

  public Integer getAnneeTrt() {
    return anneeTrt;
  }

  public void setAnneeTrt(Integer anneeTrt) {
    this.anneeTrt = anneeTrt;
  }

  public Integer getActAnnuel() {
    return actAnnuel;
  }

  public void setActAnnuel(Integer actAnnuel) {
    this.actAnnuel = actAnnuel;
  }

  public String getCodeDas() {
    return codeDas;
  }

  public void setCodeDas(String codeDas) {
    this.codeDas = codeDas;
  }

  public BigDecimal getMontDas() {
    return montDas;
  }

  public void setMontDas(BigDecimal montDas) {
    this.montDas = montDas;
  }

  public Date getDateEntree() {
    return dateEntree;
  }

  public void setDateEntree(Date dateEntree) {
    this.dateEntree = dateEntree;
  }

  public Date getDateSortie() {
    return dateSortie;
  }

  public void setDateSortie(Date dateSortie) {
    this.dateSortie = dateSortie;
  }

  public Integer getCodeInvest() {
    return codeInvest;
  }

  public void setCodeInvest(Integer codeInvest) {
    this.codeInvest = codeInvest;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (retraitePK != null ? retraitePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Retraite)) {
      return false;
    }
    Retraite other = (Retraite) object;
    if ((this.retraitePK == null && other.retraitePK != null)
        || (this.retraitePK != null && !this.retraitePK.equals(other.retraitePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entities.Retraite[ retraitePK=" + retraitePK + " ]";
  }

}
