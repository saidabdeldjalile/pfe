/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CPTE_ESCALE", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CpteEscale.findAll", query = "SELECT c FROM CpteEscale c"),
    @NamedQuery(name = "CpteEscale.findByDateTrt",
        query = "SELECT c FROM CpteEscale c WHERE c.cpteEscalePK.dateTrt = :dateTrt"),
    @NamedQuery(name = "CpteEscale.findByTypeApp",
        query = "SELECT c FROM CpteEscale c WHERE c.cpteEscalePK.typeApp = :typeApp"),
    @NamedQuery(name = "CpteEscale.findByCaeEsc",
        query = "SELECT c FROM CpteEscale c WHERE c.cpteEscalePK.caeEsc = :caeEsc"),
    @NamedQuery(name = "CpteEscale.findByCodeMonnaie",
        query = "SELECT c FROM CpteEscale c WHERE c.codeMonnaie = :codeMonnaie"),
    @NamedQuery(name = "CpteEscale.findByCoutTouche",
        query = "SELECT c FROM CpteEscale c WHERE c.coutTouche = :coutTouche"),
    @NamedQuery(name = "CpteEscale.findByTauxConv",
        query = "SELECT c FROM CpteEscale c WHERE c.tauxConv = :tauxConv")})
public class CpteEscale implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CpteEscalePK cpteEscalePK;
  @Size(max = 3)
  @Column(name = "CODE_MON")
  private String codeMonnaie;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "COUT_TOUCHE")
  private BigDecimal coutTouche;
  @Column(name = "TAUX_CONV")
  private BigDecimal tauxConv;
  // @OneToOne(cascade = CascadeType.ALL, mappedBy = "cpteEscale")
  // private CpteAtterissage cpteAtterissage;

  public CpteEscale() {}

  public CpteEscale(CpteEscalePK cpteEscalePK) {
    this.cpteEscalePK = cpteEscalePK;
  }

  public CpteEscale(int dateTrt, String typeApp, String caeEsc) {
    this.cpteEscalePK = new CpteEscalePK(dateTrt, typeApp, caeEsc);
  }

  public CpteEscalePK getCpteEscalePK() {
    if (cpteEscalePK == null)
      cpteEscalePK = new CpteEscalePK();

    return cpteEscalePK;
  }

  public void setCpteEscalePK(CpteEscalePK cpteEscalePK) {
    this.cpteEscalePK = cpteEscalePK;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public BigDecimal getCoutTouche() {
    return coutTouche;
  }

  public void setCoutTouche(BigDecimal coutTouche) {
    this.coutTouche = coutTouche;
  }

  public BigDecimal getTauxConv() {
    return tauxConv;
  }

  public void setTauxConv(BigDecimal tauxConv) {
    this.tauxConv = tauxConv;
  }

  // public CpteAtterissage getCpteAtterissage() {
  // return cpteAtterissage;
  // }
  //
  // public void setCpteAtterissage(CpteAtterissage cpteAtterissage) {
  // this.cpteAtterissage = cpteAtterissage;
  // }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cpteEscalePK != null ? cpteEscalePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteEscale)) {
      return false;
    }
    CpteEscale other = (CpteEscale) object;
    if ((this.cpteEscalePK == null && other.cpteEscalePK != null)
        || (this.cpteEscalePK != null && !this.cpteEscalePK.equals(other.cpteEscalePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteEscale[ cpteEscalePK=" + cpteEscalePK + " ]";
  }

}
