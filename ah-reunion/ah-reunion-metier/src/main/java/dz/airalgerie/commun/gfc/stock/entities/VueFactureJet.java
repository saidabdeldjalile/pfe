/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "STK.V_FACTURE_JET")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VFactureJet.findAll", query = "SELECT v FROM VueFactureJet v"),
    @NamedQuery(name = "VFactureJet.findByCodeFournisseur",
        query = "SELECT v FROM VueFactureJet v WHERE v.codeFournisseur = :codeFournisseur"),
    @NamedQuery(name = "VFactureJet.findByNumFacture",
        query = "SELECT v FROM VueFactureJet v WHERE v.numFacture = :numFacture"),
    @NamedQuery(name = "VFactureJet.findByNumBonAchat",
        query = "SELECT v FROM VueFactureJet v WHERE v.numBonAchat = :numBonAchat"),
    @NamedQuery(name = "VFactureJet.findByDateFacture",
        query = "SELECT v FROM VueFactureJet v WHERE v.dateFacture = :dateFacture"),
    @NamedQuery(name = "VFactureJet.findByDateTraitAchat",
        query = "SELECT v FROM VueFactureJet v WHERE v.dateTraitAchat = :dateTraitAchat"),
    @NamedQuery(name = "VFactureJet.findByTFac",
        query = "SELECT v FROM VueFactureJet v WHERE v.tFac = :tFac")})
public class VueFactureJet implements Serializable {

  private static final long serialVersionUID = 1L;
  @Column(name = "dateAchat")
  @Temporal(TemporalType.DATE)
  private Date dateAchat;
  @Size(max = 5)
  @Column(name = "codeFournisseur")
  private String codeFournisseur;
  @Size(max = 20)
  @Column(name = "numFacture")
  private String numFacture;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(max = 6)
  @Column(name = "numBonAchat")
  private String numBonAchat;
  @Column(name = "dateFacture")
  @Temporal(TemporalType.DATE)
  private Date dateFacture;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitAchat")
  private int dateTraitAchat;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "T_FAC")
  private BigDecimal tFac;

  public VueFactureJet() {}

  public String getCodeFournisseur() {
    return codeFournisseur;
  }

  public void setCodeFournisseur(String codeFournisseur) {
    this.codeFournisseur = codeFournisseur;
  }

  public String getNumFacture() {
    return numFacture;
  }

  public void setNumFacture(String numFacture) {
    this.numFacture = numFacture;
  }

  public String getNumBonAchat() {
    return numBonAchat;
  }

  public void setNumBonAchat(String numBonAchat) {
    this.numBonAchat = numBonAchat;
  }

  public Date getDateFacture() {
    return dateFacture;
  }

  public void setDateFacture(Date dateFacture) {
    this.dateFacture = dateFacture;
  }

  public int getDateTraitAchat() {
    return dateTraitAchat;
  }

  public void setDateTraitAchat(int dateTraitAchat) {
    this.dateTraitAchat = dateTraitAchat;
  }

  public BigDecimal getTFac() {
    return tFac;
  }

  public void setTFac(BigDecimal tFac) {
    this.tFac = tFac;
  }

  public Date getDateAchat() {
    return dateAchat;
  }

  public void setDateAchat(Date dateAchat) {
    this.dateAchat = dateAchat;
  }

}
