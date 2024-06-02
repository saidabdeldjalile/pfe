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
@Table(name = "STK.V_SORTIE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VSortie.findAll", query = "SELECT v FROM VueSortie v"),
    @NamedQuery(name = "VSortie.findByClasse",
        query = "SELECT v FROM VueSortie v WHERE v.classe = :classe"),
    @NamedQuery(name = "VSortie.findByMoteur",
        query = "SELECT v FROM VueSortie v WHERE v.moteur = :moteur"),
    @NamedQuery(name = "VSortie.findByTypeApp",
        query = "SELECT v FROM VueSortie v WHERE v.typeApp = :typeApp"),
    @NamedQuery(name = "VSortie.findByTypeStock",
        query = "SELECT v FROM VueSortie v WHERE v.typeStock = :typeStock"),
    @NamedQuery(name = "VSortie.findByCodeAppareil",
        query = "SELECT v FROM VueSortie v WHERE v.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "VSortie.findByPn", query = "SELECT v FROM VueSortie v WHERE v.pn = :pn"),
    @NamedQuery(name = "VSortie.findByDesignation",
        query = "SELECT v FROM VueSortie v WHERE v.designation = :designation"),
    @NamedQuery(name = "VSortie.findByCodeAH",
        query = "SELECT v FROM VueSortie v WHERE v.codeAH = :codeAH"),
    @NamedQuery(name = "VSortie.findByNumBonSortie",
        query = "SELECT v FROM VueSortie v WHERE v.numBonSortie = :numBonSortie"),
    @NamedQuery(name = "VSortie.findByCodeCI",
        query = "SELECT v FROM VueSortie v WHERE v.codeCI = :codeCI"),
    @NamedQuery(name = "VSortie.findByDateSortie",
        query = "SELECT v FROM VueSortie v WHERE v.dateSortie = :dateSortie"),
    @NamedQuery(name = "VSortie.findByQuantite",
        query = "SELECT v FROM VueSortie v WHERE v.quantite = :quantite"),
    @NamedQuery(name = "VSortie.findByValeur",
        query = "SELECT v FROM VueSortie v WHERE v.valeur = :valeur"),
    @NamedQuery(name = "VSortie.findByCodeAtelier",
        query = "SELECT v FROM VueSortie v WHERE v.codeAtelier = :codeAtelier"),
    @NamedQuery(name = "VSortie.findByCodeClient",
        query = "SELECT v FROM VueSortie v WHERE v.codeClient = :codeClient"),
    @NamedQuery(name = "VSortie.findByDateTraitSortie",
        query = "SELECT v FROM VueSortie v WHERE v.dateTraitSortie = :dateTraitSortie"),
    @NamedQuery(name = "VSortie.findByTypeMVT",
        query = "SELECT v FROM VueSortie v WHERE v.typeMVT = :typeMVT")})
public class VueSortie implements Serializable {

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
  @Size(max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;
  @Size(max = 25)
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
  @Column(name = "numBonSortie")
  private String numBonSortie;
  @Size(max = 12)
  @Column(name = "codeCI")
  private String codeCI;
  @Column(name = "dateSortie")
  @Temporal(TemporalType.DATE)
  private Date dateSortie;
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
  @Size(max = 6)
  @Column(name = "codeAtelier")
  private String codeAtelier;
  @Size(max = 10)
  @Column(name = "codeClient")
  private String codeClient;
  @Column(name = "dateTraitSortie")
  private Integer dateTraitSortie;
  @Column(name = "typeMVT")
  private int typeMVT;
  @Column(name = "immatriculation")
  private String immatriculation;
  @Column(name = "numLot")
  private String numLot;
  @Column(name = "visite")
  private String visite;
  @Column(name = "dateCreation")
  @Temporal(TemporalType.DATE)
  private Date dateCreation;
  @Column(name = "dateModif")
  @Temporal(TemporalType.DATE)
  private Date dateModif;
  @Column(name = "app")
  private String app;
  @Column(name = "typeSortie")
  private String typeSortie;

  public VueSortie() {}

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

  public String getNumBonSortie() {
    return numBonSortie;
  }

  public void setNumBonSortie(String numBonSortie) {
    this.numBonSortie = numBonSortie;
  }

  public String getCodeCI() {
    return codeCI;
  }

  public void setCodeCI(String codeCI) {
    this.codeCI = codeCI;
  }

  public Date getDateSortie() {
    return dateSortie;
  }

  public void setDateSortie(Date dateSortie) {
    this.dateSortie = dateSortie;
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

  public String getCodeAtelier() {
    return codeAtelier;
  }

  public void setCodeAtelier(String codeAtelier) {
    this.codeAtelier = codeAtelier;
  }

  public String getCodeClient() {
    return codeClient;
  }

  public void setCodeClient(String codeClient) {
    this.codeClient = codeClient;
  }

  public Integer getDateTraitSortie() {
    return dateTraitSortie;
  }

  public void setDateTraitSortie(Integer dateTraitSortie) {
    this.dateTraitSortie = dateTraitSortie;
  }

  public int getTypeMVT() {
    return typeMVT;
  }

  public void setTypeMVT(int typeMVT) {
    this.typeMVT = typeMVT;
  }

  public String getImmatriculation() {
    return immatriculation;
  }

  public void setImmatriculation(String immatriculation) {
    this.immatriculation = immatriculation;
  }

  public String getNumLot() {
    return numLot;
  }

  public void setNumLot(String numLot) {
    this.numLot = numLot;
  }

  public String getVisite() {
    return visite;
  }

  public void setVisite(String visite) {
    this.visite = visite;
  }

  public String getApp() {
    return app;
  }

  public void setApp(String app) {
    this.app = app;
  }

  public String getTypeSortie() {
    return typeSortie;
  }

  public void setTypeSortie(String typeSortie) {
    this.typeSortie = typeSortie;
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

}
