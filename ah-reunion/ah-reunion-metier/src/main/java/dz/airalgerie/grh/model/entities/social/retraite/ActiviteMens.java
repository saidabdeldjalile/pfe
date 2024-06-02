/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.retraite;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AGHA Riadh
 */
@Entity
@Table(name = "ACTIVITE_MENS", schema = "RET")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "ActiviteMens.findAll", query = "SELECT a FROM ActiviteMens a"),
    @NamedQuery(name = "ActiviteMens.findById",
        query = "SELECT a FROM ActiviteMens a WHERE a.id = :id"),
    @NamedQuery(name = "ActiviteMens.findByMatricule",
        query = "SELECT a FROM ActiviteMens a WHERE a.matricule = :matricule"),
    @NamedQuery(name = "ActiviteMens.findByDatePai",
        query = "SELECT a FROM ActiviteMens a WHERE a.datePai = :datePai"),
    @NamedQuery(name = "ActiviteMens.findByDateTrt",
        query = "SELECT a FROM ActiviteMens a WHERE a.dateTrt = :dateTrt"),
    @NamedQuery(name = "ActiviteMens.findByCodeWil",
        query = "SELECT a FROM ActiviteMens a WHERE a.codeWil = :codeWil"),
    @NamedQuery(name = "ActiviteMens.findByCodeFil",
        query = "SELECT a FROM ActiviteMens a WHERE a.codeFil = :codeFil"),
    @NamedQuery(name = "ActiviteMens.findByBulPrim",
        query = "SELECT a FROM ActiviteMens a WHERE a.bulPrim = :bulPrim"),
    @NamedQuery(name = "ActiviteMens.findByNbrJour",
        query = "SELECT a FROM ActiviteMens a WHERE a.nbrJour = :nbrJour"),
    @NamedQuery(name = "ActiviteMens.findByMontantActivite",
        query = "SELECT a FROM ActiviteMens a WHERE a.montantActivite = :montantActivite")})
public class ActiviteMens implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
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
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Size(max = 1)
  @Column(name = "CODE_FIL")
  private String codeFil;
  @Column(name = "BUL_PRIM")
  private Boolean bulPrim;
  @Column(name = "NBR_JOUR")
  private Integer nbrJour;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONTANT_ACTIVITE")
  private BigDecimal montantActivite;

  public ActiviteMens() {}

  public ActiviteMens(Integer id) {
    this.id = id;
  }

  public ActiviteMens(Integer id, int matricule, int datePai, int dateTrt, String codeWil) {
    this.id = id;
    this.matricule = matricule;
    this.datePai = datePai;
    this.dateTrt = dateTrt;
    this.codeWil = codeWil;
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

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public String getCodeFil() {
    return codeFil;
  }

  public void setCodeFil(String codeFil) {
    this.codeFil = codeFil;
  }

  public Boolean getBulPrim() {
    return bulPrim;
  }

  public void setBulPrim(Boolean bulPrim) {
    this.bulPrim = bulPrim;
  }

  public Integer getNbrJour() {
    return nbrJour;
  }

  public void setNbrJour(Integer nbrJour) {
    this.nbrJour = nbrJour;
  }

  public BigDecimal getMontantActivite() {
    return montantActivite;
  }

  public void setMontantActivite(BigDecimal montantActivite) {
    this.montantActivite = montantActivite;
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
    if (!(object instanceof ActiviteMens)) {
      return false;
    }
    ActiviteMens other = (ActiviteMens) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entities.ActiviteMens[ id=" + id + " ]";
  }

}
