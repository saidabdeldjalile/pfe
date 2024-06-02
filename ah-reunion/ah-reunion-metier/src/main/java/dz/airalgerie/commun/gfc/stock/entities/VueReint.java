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
@Table(name = "STK.V_REINT")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VReint.findAll", query = "SELECT v FROM VueReint v"),
    @NamedQuery(name = "VReint.findByClasse",
        query = "SELECT v FROM VueReint v WHERE v.classe = :classe"),
    @NamedQuery(name = "VReint.findByMoteur",
        query = "SELECT v FROM VueReint v WHERE v.moteur = :moteur"),
    @NamedQuery(name = "VReint.findByTypeApp",
        query = "SELECT v FROM VueReint v WHERE v.typeApp = :typeApp"),
    @NamedQuery(name = "VReint.findByTypeStock",
        query = "SELECT v FROM VueReint v WHERE v.typeStock = :typeStock"),
    @NamedQuery(name = "VReint.findByCodeAppareil",
        query = "SELECT v FROM VueReint v WHERE v.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "VReint.findByPn", query = "SELECT v FROM VueReint v WHERE v.pn = :pn"),
    @NamedQuery(name = "VReint.findByDesignation",
        query = "SELECT v FROM VueReint v WHERE v.designation = :designation"),
    @NamedQuery(name = "VReint.findByCodeAH",
        query = "SELECT v FROM VueReint v WHERE v.codeAH = :codeAH"),
    @NamedQuery(name = "VReint.findByNumBonReint",
        query = "SELECT v FROM VueReint v WHERE v.numBonReint = :numBonReint"),
    @NamedQuery(name = "VReint.findByDateReint",
        query = "SELECT v FROM VueReint v WHERE v.dateReint = :dateReint"),
    @NamedQuery(name = "VReint.findByQuantite",
        query = "SELECT v FROM VueReint v WHERE v.quantite = :quantite"),
    @NamedQuery(name = "VReint.findByValeur",
        query = "SELECT v FROM VueReint v WHERE v.valeur = :valeur"),
    @NamedQuery(name = "VReint.findByDateTraitReint",
        query = "SELECT v FROM VueReint v WHERE v.dateTraitReint = :dateTraitReint")})
public class VueReint implements Serializable {
  private static final long serialVersionUID = 1L;
  @Size(max = 1)
  @Column(name = "classe")
  private String classe;
  @Size(max = 1)
  @Column(name = "moteur")
  private String moteur;
  @Size(max = 2)
  @Column(name = "typeApp")
  private String typeApp;
  @Size(max = 5)
  @Column(name = "typeStock")
  private String typeStock;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "pn")
  private String pn;
  @Size(max = 60)
  @Column(name = "designation")
  private String designation;
  @Size(max = 8)
  @Column(name = "codeAH")
  private String codeAH;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(max = 6)
  @Column(name = "numBonReint")
  private String numBonReint;
  @Column(name = "dateReint")
  @Temporal(TemporalType.DATE)
  private Date dateReint;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "quantite")
  private BigDecimal quantite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "valeur")
  private BigDecimal valeur;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitReint")
  private int dateTraitReint;
  @Column(name = "numBonSortie")
  private String numBonSortie;
  @Column(name = "dateSortie")
  @Temporal(TemporalType.DATE)
  private Date dateSortie;
  @Column(name = "dateCreation")
  @Temporal(TemporalType.DATE)
  private Date dateCreation;
  @Column(name = "dateModif")
  @Temporal(TemporalType.DATE)
  private Date dateModif;
  @Column(name = "app")
  private String app;
  @Column(name = "typeReint")
  private String typeReint;

  public VueReint() {}

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public String getMoteur() {
    return moteur;
  }

  public void setMoteur(String moteur) {
    this.moteur = moteur;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public String getTypeStock() {
    return typeStock;
  }

  public void setTypeStock(String typeStock) {
    this.typeStock = typeStock;
  }

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getCodeAH() {
    return codeAH;
  }

  public void setCodeAH(String codeAH) {
    this.codeAH = codeAH;
  }

  public String getNumBonReint() {
    return numBonReint;
  }

  public void setNumBonReint(String numBonReint) {
    this.numBonReint = numBonReint;
  }

  public Date getDateReint() {
    return dateReint;
  }

  public void setDateReint(Date dateReint) {
    this.dateReint = dateReint;
  }

  public BigDecimal getQuantite() {
    return quantite;
  }

  public void setQuantite(BigDecimal quantite) {
    this.quantite = quantite;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

  public int getDateTraitReint() {
    return dateTraitReint;
  }

  public void setDateTraitReint(int dateTraitReint) {
    this.dateTraitReint = dateTraitReint;
  }

  public String getNumBonSortie() {
    return numBonSortie;
  }

  public void setNumBonSortie(String numBonSortie) {
    this.numBonSortie = numBonSortie;
  }

  public Date getDateSortie() {
    return dateSortie;
  }

  public void setDateSortie(Date dateSortie) {
    this.dateSortie = dateSortie;
  }

  public Date getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(Date dateCreation) {
    this.dateCreation = dateCreation;
  }

  public Date getDateModif() {
    return dateModif;
  }

  public void setDateModif(Date dateModif) {
    this.dateModif = dateModif;
  }

  public String getApp() {
    return app;
  }

  public void setApp(String app) {
    this.app = app;
  }

  public String getTypeReint() {
    return typeReint;
  }

  public void setTypeReint(String typeReint) {
    this.typeReint = typeReint;
  }

}
