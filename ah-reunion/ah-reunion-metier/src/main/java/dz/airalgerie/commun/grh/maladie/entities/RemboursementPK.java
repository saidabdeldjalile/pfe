/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class RemboursementPK implements Serializable {
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
  @Size(min = 1, max = 6)
  @Column(name = "NUM_CHEQUE")
  private String numCheque;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "NUM_BDX")
  private String numBordereau;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_RUB")
  private String codeRub;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID_MONTANT")
  private int idMontant;

  public RemboursementPK() {}

  public RemboursementPK(int matricule, int datePai, String numCheque, String numBordereau,
      String codeRub, int idMontant) {
    this.matricule = matricule;
    this.datePai = datePai;
    this.numCheque = numCheque;
    this.numBordereau = numBordereau;
    this.codeRub = codeRub;
    this.idMontant = idMontant;
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

  public String getNumCheque() {
    return numCheque;
  }

  public void setNumCheque(String numCheque) {
    this.numCheque = numCheque;
  }

  public String getNumBordereau() {
    return numBordereau;
  }

  public void setNumBordereau(String numBordereau) {
    this.numBordereau = numBordereau;
  }

  public String getCodeRub() {
    return codeRub;
  }

  public void setCodeRub(String codeRub) {
    this.codeRub = codeRub;
  }

  public int getIdMontant() {
    return idMontant;
  }

  public void setIdMontant(int idMontant) {
    this.idMontant = idMontant;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) matricule;
    hash += (int) datePai;
    hash += (numCheque != null ? numCheque.hashCode() : 0);
    hash += (numBordereau != null ? numBordereau.hashCode() : 0);
    hash += (codeRub != null ? codeRub.hashCode() : 0);
    hash += (int) idMontant;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RemboursementPK)) {
      return false;
    }
    RemboursementPK other = (RemboursementPK) object;
    if (this.matricule != other.matricule) {
      return false;
    }
    if (this.datePai != other.datePai) {
      return false;
    }
    if ((this.numCheque == null && other.numCheque != null)
        || (this.numCheque != null && !this.numCheque.equals(other.numCheque))) {
      return false;
    }
    if ((this.numBordereau == null && other.numBordereau != null)
        || (this.numBordereau != null && !this.numBordereau.equals(other.numBordereau))) {
      return false;
    }
    if ((this.codeRub == null && other.codeRub != null)
        || (this.codeRub != null && !this.codeRub.equals(other.codeRub))) {
      return false;
    }
    if (this.idMontant != other.idMontant) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.RemboursementPK[ matricule=" + matricule + ", datePai=" + datePai
        + ", numCheque=" + numCheque + ", numBordereau=" + numBordereau + ", codeRub=" + codeRub
        + ", idMontant=" + idMontant + " ]";
  }

}
