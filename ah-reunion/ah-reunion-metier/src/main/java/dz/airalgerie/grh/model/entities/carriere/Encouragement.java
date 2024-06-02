/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "ENCOURAGEMENT")
public class Encouragement implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected EncouragementPK encouragementPK;
  @Column(name = "NBR_JOUR")
  private Integer nbrJour;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MONT_INTER")
  private BigDecimal montInter;
  @Column(name = "DATE_SAISI")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisi;

  public Encouragement() {}

  public Encouragement(EncouragementPK encouragementPK) {
    this.encouragementPK = encouragementPK;
  }

  public Encouragement(int matricule, int annee) {
    this.encouragementPK = new EncouragementPK(matricule, annee);
  }

  public EncouragementPK getEncouragementPK() {
    return encouragementPK;
  }

  public void setEncouragementPK(EncouragementPK encouragementPK) {
    this.encouragementPK = encouragementPK;
  }

  public Integer getNbrJour() {
    return nbrJour;
  }

  public void setNbrJour(Integer nbrJour) {
    this.nbrJour = nbrJour;
  }

  public BigDecimal getMontInter() {
    return montInter;
  }

  public void setMontInter(BigDecimal montInter) {
    this.montInter = montInter;
  }

  public Date getDateSaisi() {
    return dateSaisi;
  }

  public void setDateSaisi(Date dateSaisi) {
    this.dateSaisi = dateSaisi;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (encouragementPK != null ? encouragementPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Encouragement)) {
      return false;
    }
    Encouragement other = (Encouragement) object;
    if ((this.encouragementPK == null && other.encouragementPK != null)
        || (this.encouragementPK != null && !this.encouragementPK.equals(other.encouragementPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.Encouragement[ encouragementPK=" + encouragementPK + " ]";
  }

}
