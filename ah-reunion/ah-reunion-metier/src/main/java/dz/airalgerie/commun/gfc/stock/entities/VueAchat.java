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
@Table(name = "STK.V_ACHAT")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VueAchat.findAll", query = "SELECT v FROM VueAchat v"),
    @NamedQuery(name = "VueAchat.findByClasse",
        query = "SELECT v FROM VueAchat v WHERE v.classe = :classe"),
    @NamedQuery(name = "VueAchat.findByMoteur",
        query = "SELECT v FROM VueAchat v WHERE v.moteur = :moteur"),
    @NamedQuery(name = "VueAchat.findByTypeApp",
        query = "SELECT v FROM VueAchat v WHERE v.typeApp = :typeApp"),
    @NamedQuery(name = "VueAchat.findByTypeStock",
        query = "SELECT v FROM VueAchat v WHERE v.typeStock = :typeStock"),
    @NamedQuery(name = "VueAchat.findByCodeAppareil",
        query = "SELECT v FROM VueAchat v WHERE v.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "VueAchat.findByPn", query = "SELECT v FROM VueAchat v WHERE v.pn = :pn"),
    @NamedQuery(name = "VueAchat.findByDesignation",
        query = "SELECT v FROM VueAchat v WHERE v.designation = :designation"),
    @NamedQuery(name = "VueAchat.findByCodeAH",
        query = "SELECT v FROM VueAchat v WHERE v.codeAH = :codeAH"),
    @NamedQuery(name = "VueAchat.findByNumBonAchat",
        query = "SELECT v FROM VueAchat v WHERE v.numBonAchat = :numBonAchat"),
    @NamedQuery(name = "VueAchat.findByDateAchat",
        query = "SELECT v FROM VueAchat v WHERE v.dateAchat = :dateAchat"),
    @NamedQuery(name = "VueAchat.findByQuantite",
        query = "SELECT v FROM VueAchat v WHERE v.quantite = :quantite"),
    @NamedQuery(name = "VueAchat.findByValeur",
        query = "SELECT v FROM VueAchat v WHERE v.valeur = :valeur"),
    @NamedQuery(name = "VueAchat.findByCodePays",
        query = "SELECT v FROM VueAchat v WHERE v.codePays = :codePays"),
    @NamedQuery(name = "VueAchat.findByCodeFournisseur",
        query = "SELECT v FROM VueAchat v WHERE v.codeFournisseur = :codeFournisseur"),
    @NamedQuery(name = "VueAchat.findByNumFacture",
        query = "SELECT v FROM VueAchat v WHERE v.numFacture = :numFacture"),
    @NamedQuery(name = "VueAchat.findByDateFacture",
        query = "SELECT v FROM VueAchat v WHERE v.dateFacture = :dateFacture"),
    @NamedQuery(name = "VueAchat.findByDateTraitAchat",
        query = "SELECT v FROM VueAchat v WHERE v.dateTraitAchat = :dateTraitAchat"),
    @NamedQuery(name = "VueAchat.findByNumCMD",
        query = "SELECT v FROM VueAchat v WHERE v.numCMD = :numCMD"),
    @NamedQuery(name = "VueAchat.findByTypeCMD",
        query = "SELECT v FROM VueAchat v WHERE v.typeCMD = :typeCMD")})
public class VueAchat implements Serializable {
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
  @Column(name = "numBonAchat")
  private String numBonAchat;
  @Column(name = "dateAchat")
  @Temporal(TemporalType.DATE)
  private Date dateAchat;
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
  @Column(name = "codePays")
  private Integer codePays;
  @Size(max = 5)
  @Column(name = "codeFournisseur")
  private String codeFournisseur;
  @Size(max = 20)
  @Column(name = "numFacture")
  private String numFacture;
  @Column(name = "dateFacture")
  @Temporal(TemporalType.DATE)
  private Date dateFacture;
  @Column(name = "dateTraitAchat")
  private Integer dateTraitAchat;
  @Size(max = 10)
  @Column(name = "numCMD")
  private String numCMD;
  @Size(max = 10)
  @Column(name = "typeCMD")
  private String typeCMD;
  @Column(name = "libelle")
  private String libelle;

  public VueAchat() {}

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

  public String getNumBonAchat() {
    return numBonAchat;
  }

  public void setNumBonAchat(String numBonAchat) {
    this.numBonAchat = numBonAchat;
  }

  public Date getDateAchat() {
    return dateAchat;
  }

  public void setDateAchat(Date dateAchat) {
    this.dateAchat = dateAchat;
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

  public Integer getCodePays() {
    return codePays;
  }

  public void setCodePays(Integer codePays) {
    this.codePays = codePays;
  }

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

  public Integer getDateTraitAchat() {
    return dateTraitAchat;
  }

  public void setDateTraitAchat(Integer dateTraitAchat) {
    this.dateTraitAchat = dateTraitAchat;
  }

  public String getNumCMD() {
    return numCMD;
  }

  public void setNumCMD(String numCMD) {
    this.numCMD = numCMD;
  }

  public String getTypeCMD() {
    return typeCMD;
  }

  public void setTypeCMD(String typeCMD) {
    this.typeCMD = typeCMD;
  }

  public Date getDateFacture() {
    return dateFacture;
  }

  public void setDateFacture(Date dateFacture) {
    this.dateFacture = dateFacture;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

}
