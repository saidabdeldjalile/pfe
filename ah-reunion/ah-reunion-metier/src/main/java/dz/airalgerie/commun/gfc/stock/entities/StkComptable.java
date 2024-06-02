/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
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
 * @author user
 */
@Entity
@Table(name = "STK.stkComptable")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "StkComptable.findAll", query = "SELECT s FROM StkComptable s"),
    @NamedQuery(name = "StkComptable.findByIdstk",
        query = "SELECT s FROM StkComptable s WHERE s.idstk = :idstk"),
    @NamedQuery(name = "StkComptable.findByDateTraitSTK",
        query = "SELECT s FROM StkComptable s WHERE s.dateTraitSTK = :dateTraitSTK"),
    @NamedQuery(name = "StkComptable.findByTypeEngin",
        query = "SELECT s FROM StkComptable s WHERE s.typeEngin = :typeEngin"),
    @NamedQuery(name = "StkComptable.findByLibStk",
        query = "SELECT s FROM StkComptable s WHERE s.libStk = :libStk"),
    @NamedQuery(name = "StkComptable.findByLigne",
        query = "SELECT s FROM StkComptable s WHERE s.ligne = :ligne"),
    @NamedQuery(name = "StkComptable.findByDateReelStk",
        query = "SELECT s FROM StkComptable s WHERE s.dateReelStk = :dateReelStk"),
    @NamedQuery(name = "StkComptable.findByPiece",
        query = "SELECT s FROM StkComptable s WHERE s.piece = :piece"),
    @NamedQuery(name = "StkComptable.findByCompte",
        query = "SELECT s FROM StkComptable s WHERE s.compte = :compte"),
    @NamedQuery(name = "StkComptable.findByAtelier",
        query = "SELECT s FROM StkComptable s WHERE s.atelier = :atelier"),
    @NamedQuery(name = "StkComptable.findByLibMvt",
        query = "SELECT s FROM StkComptable s WHERE s.libMvt = :libMvt"),
    @NamedQuery(name = "StkComptable.findByValeur",
        query = "SELECT s FROM StkComptable s WHERE s.valeur = :valeur"),
    @NamedQuery(name = "StkComptable.findBySigne",
        query = "SELECT s FROM StkComptable s WHERE s.signe = :signe"),
    @NamedQuery(name = "StkComptable.findByMonnaie",
        query = "SELECT s FROM StkComptable s WHERE s.monnaie = :monnaie"),
    @NamedQuery(name = "StkComptable.findByObservation",
        query = "SELECT s FROM StkComptable s WHERE s.observation = :observation")})
public class StkComptable implements Serializable {
  private static final long serialVersionUID = 1L;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  // @Basic(optional = false)
  // @NotNull
  @Column(name = "Id_stk")
  private Integer idstk;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitSTK")
  private int dateTraitSTK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "typeEngin")
  private String typeEngin;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "libStk")
  private String libStk;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "ligne")
  private String ligne;
  @Size(max = 8)
  @Column(name = "dateReelStk")
  private String dateReelStk;
  @Size(max = 4)
  @Column(name = "piece")
  private String piece;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "compte")
  private String compte;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "atelier")
  private String atelier;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "libMvt")
  private String libMvt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 18)
  @Column(name = "valeur")
  private String valeur;
  @Basic(optional = false)

  @Size(min = 1, max = 18)
  @Column(name = "valText")
  private String valText;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "signe")
  private String signe;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "monnaie")
  private String monnaie;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;

  public StkComptable() {
    idstk = 0;
  }

  public StkComptable(Integer idstk) {
    this.idstk = idstk;
  }

  public StkComptable(Integer idstk, int dateTraitSTK, String typeEngin, String libStk,
      String ligne, String compte, String atelier, String libMvt, String valeur, String signe,
      String monnaie) {
    this.idstk = idstk;
    this.dateTraitSTK = dateTraitSTK;
    this.typeEngin = typeEngin;
    this.libStk = libStk;
    this.ligne = ligne;
    this.compte = compte;
    this.atelier = atelier;
    this.libMvt = libMvt;
    this.valeur = valeur;
    this.signe = signe;
    this.monnaie = monnaie;
  }

  public Integer getIdstk() {
    return idstk;
  }

  public void setIdstk(Integer idstk) {
    this.idstk = idstk;
  }

  public int getDateTraitSTK() {
    return dateTraitSTK;
  }

  public void setDateTraitSTK(int dateTraitSTK) {
    this.dateTraitSTK = dateTraitSTK;
  }

  public String getTypeEngin() {
    return typeEngin;
  }

  public void setTypeEngin(String typeEngin) {
    this.typeEngin = typeEngin;
  }

  public String getLibStk() {
    return libStk;
  }

  public void setLibStk(String libStk) {
    this.libStk = libStk;
  }

  public String getLigne() {
    return ligne;
  }

  public void setLigne(String ligne) {
    this.ligne = ligne;
  }

  public String getDateReelStk() {
    return dateReelStk;
  }

  public void setDateReelStk(String dateReelStk) {
    this.dateReelStk = dateReelStk;
  }

  public String getPiece() {
    return piece;
  }

  public void setPiece(String piece) {
    this.piece = piece;
  }

  public String getCompte() {
    return compte;
  }

  public void setCompte(String compte) {
    this.compte = compte;
  }

  public String getAtelier() {
    return atelier;
  }

  public void setAtelier(String atelier) {
    this.atelier = atelier;
  }

  public String getLibMvt() {
    return libMvt;
  }

  public void setLibMvt(String libMvt) {
    this.libMvt = libMvt;
  }

  public String getValeur() {
    return valeur;
  }

  public void setValeur(String valeur) {
    this.valeur = valeur;
  }

  public String getSigne() {
    return signe;
  }

  public void setSigne(String signe) {
    this.signe = signe;
  }

  public String getMonnaie() {
    return monnaie;
  }

  public void setMonnaie(String monnaie) {
    this.monnaie = monnaie;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idstk != null ? idstk.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof StkComptable)) {
      return false;
    }
    StkComptable other = (StkComptable) object;
    if ((this.idstk == null && other.idstk != null)
        || (this.idstk != null && !this.idstk.equals(other.idstk))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.StkComptable[ idstk=" + idstk + " ]";
  }

  public String getValText() {
    return valText;
  }

  public void setValText(String valText) {
    this.valText = valText;
  }

}
