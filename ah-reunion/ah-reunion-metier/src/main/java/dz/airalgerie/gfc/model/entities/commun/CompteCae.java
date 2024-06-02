/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "COMPTE_CAE", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CompteCae.findAll", query = "SELECT c FROM CompteCae c"),
    @NamedQuery(name = "CompteCae.findByCptPart",
        query = "SELECT c FROM CompteCae c WHERE c.compteCaePK.cptPart = :cptPart"),
    @NamedQuery(name = "CompteCae.findByDateDeb",
        query = "SELECT c FROM CompteCae c WHERE c.compteCaePK.dateDeb = :dateDeb"),
    @NamedQuery(name = "CompteCae.findByDateFin",
        query = "SELECT c FROM CompteCae c WHERE c.dateFin = :dateFin"),
    @NamedQuery(name = "CompteCae.findByGrpChap",
        query = "SELECT c FROM CompteCae c WHERE c.grpChap = :grpChap"),
    @NamedQuery(name = "CompteCae.findByDateDecision",
        query = "SELECT c FROM CompteCae c WHERE c.dateDecision = :dateDecision"),
    @NamedQuery(name = "CompteCae.findByRefCae",
        query = "SELECT c FROM CompteCae c WHERE c.refCae = :refCae"),
    @NamedQuery(name = "CompteCae.findByCodeUnit",
        query = "SELECT c FROM CompteCae c WHERE c.codeUnit = :codeUnit"),
    @NamedQuery(name = "CompteCae.findByCodeReg",
        query = "SELECT c FROM CompteCae c WHERE c.codeReg = :codeReg"),
    @NamedQuery(name = "CompteCae.findByCodeWil",
        query = "SELECT c FROM CompteCae c WHERE c.codeWil = :codeWil"),
    @NamedQuery(name = "CompteCae.findByLibelle",
        query = "SELECT c FROM CompteCae c WHERE c.libelle = :libelle")})
public class CompteCae implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CompteCaePK compteCaePK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_FIN")
  @Temporal(TemporalType.DATE)
  private Date dateFin;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Column(name = "DATE_DECISION")
  @Temporal(TemporalType.DATE)
  private Date dateDecision;
  @Size(max = 10)
  @Column(name = "REF_CAE")
  private String refCae;
  @Size(max = 2)
  @Column(name = "CODE_UNIT")
  private String codeUnit;
  @Size(max = 10)
  @Column(name = "CODE_REG")
  private String codeReg;
  @Size(max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;

  public CompteCae() {}

  public CompteCae(CompteCaePK compteCaePK) {
    this.compteCaePK = compteCaePK;
  }

  public CompteCae(CompteCaePK compteCaePK, Date dateFin, String grpChap) {
    this.compteCaePK = compteCaePK;
    this.dateFin = dateFin;
    this.grpChap = grpChap;
  }

  public CompteCae(String cptPart, Date dateDeb) {
    this.compteCaePK = new CompteCaePK(cptPart, dateDeb);
  }

  public CompteCaePK getCompteCaePK() {
    return compteCaePK;
  }

  public void setCompteCaePK(CompteCaePK compteCaePK) {
    this.compteCaePK = compteCaePK;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public Date getDateDecision() {
    return dateDecision;
  }

  public void setDateDecision(Date dateDecision) {
    this.dateDecision = dateDecision;
  }

  public String getRefCae() {
    return refCae;
  }

  public void setRefCae(String refCae) {
    this.refCae = refCae;
  }

  public String getCodeUnit() {
    return codeUnit;
  }

  public void setCodeUnit(String codeUnit) {
    this.codeUnit = codeUnit;
  }

  public String getCodeReg() {
    return codeReg;
  }

  public void setCodeReg(String codeReg) {
    this.codeReg = codeReg;
  }

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (compteCaePK != null ? compteCaePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CompteCae)) {
      return false;
    }
    CompteCae other = (CompteCae) object;
    if ((this.compteCaePK == null && other.compteCaePK != null)
        || (this.compteCaePK != null && !this.compteCaePK.equals(other.compteCaePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.bean.journal.CompteCae[ compteCaePK=" + compteCaePK + " ]";
  }

}
