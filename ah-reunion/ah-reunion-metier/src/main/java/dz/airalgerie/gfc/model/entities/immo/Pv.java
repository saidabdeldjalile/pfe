/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import dz.airalgerie.gfc.model.entities.commun.UniteImmo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Administrateur
 */
@Entity
@Table(name = "PV")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Pv.findAll", query = "SELECT p FROM Pv p")})
public class Pv implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "CODENOM")
  private String codeNom;
  @Size(max = 255)
  @Column(name = "DESIGNATION")
  private String designation;
  @Size(max = 255)
  @Column(name = "NUMSER")
  private String numser;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "VALEUR")
  private BigDecimal valeur;
  @Column(name = "AMORTISSEMENT_MENSUEL")
  private BigDecimal amortissementMensuel;
  @Column(name = "AMORTISSEMENT_CUMULE")
  private BigDecimal amortissementCumule;
  @Size(max = 255)
  @Column(name = "MARQUE")
  private String marque;
  @Size(max = 255)
  @Column(name = "TYPE")
  private String type;
  @Basic(optional = false)
  @NotNull
  @Column(name = "PRIX")
  private BigDecimal prix;
  @Column(name = "FRAISAPP")
  private BigDecimal fraisapp;
  @Column(name = "TAXE")
  private BigDecimal taxe;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CREATED")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "STATUT")
  private String statut;
  @Basic(optional = false)
  @NotNull
  @Column(name = "LOT")
  private long lot;
  @Column(name = "TAUX_AMORT")
  private Double tauxAmort;
  @Column(name = "DUREE")
  private Double duree;
  @Column(name = "PRIX_DZD")
  private Double prixDzd;
  @Column(name = "TAXE_DZD")
  private Double taxeDzd;
  @Column(name = "FRAISAPP_DZD")
  private Double fraisappDzd;
  @Size(max = 50)
  @Column(name = "code_ATA100")
  private String codeATA100;
  @Size(max = 50)
  @Column(name = "part_number")
  private String partNumber;
  @Column(name = "FAMILLEID")
  private Long familleid;
  @Size(max = 255)
  @Column(name = "code_avion")
  private String codeAvion;
  @Size(max = 255)
  @Column(name = "compte28")
  private String compte28;
  @Size(max = 255)
  @Column(name = "compte68")
  private String compte68;
  @Basic(optional = false)
  @NotNull
  @Column(name = "gv")
  private boolean gv;
  @Column(name = "PAGE")
  private Double page;
  @JoinColumn(name = "DOSSIERID", referencedColumnName = "DOSSIERID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Dossier dossier;
  @JoinColumn(name = "ITEMID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item item;
  @JoinColumn(name = "STRUCTUREID", referencedColumnName = "STRUCTUREID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Structure structure;
  @JoinColumn(name = "LOCALISATION", referencedColumnName = "UNITEID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private UniteImmo unite;

  public Pv() {}

  public Pv(String codeNom) {
    this.codeNom = codeNom;
  }

  public Pv(String codeNom, BigDecimal valeur, BigDecimal prix, Date created, String statut,
      long lot, boolean gv) {
    this.codeNom = codeNom;
    this.valeur = valeur;
    this.prix = prix;
    this.created = created;
    this.statut = statut;
    this.lot = lot;
    this.gv = gv;
  }

  public String getCodeNom() {
    return codeNom;
  }

  public void setCodeNom(String codeNom) {
    this.codeNom = codeNom;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getNumser() {
    return numser;
  }

  public void setNumser(String numser) {
    this.numser = numser;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

  public BigDecimal getAmortissementMensuel() {
    return amortissementMensuel;
  }

  public void setAmortissementMensuel(BigDecimal amortissementMensuel) {
    this.amortissementMensuel = amortissementMensuel;
  }

  public BigDecimal getAmortissementCumule() {
    return amortissementCumule;
  }

  public void setAmortissementCumule(BigDecimal amortissementCumule) {
    this.amortissementCumule = amortissementCumule;
  }

  public String getMarque() {
    return marque;
  }

  public void setMarque(String marque) {
    this.marque = marque;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public BigDecimal getPrix() {
    return prix;
  }

  public void setPrix(BigDecimal prix) {
    this.prix = prix;
  }

  public BigDecimal getFraisapp() {
    return fraisapp;
  }

  public void setFraisapp(BigDecimal fraisapp) {
    this.fraisapp = fraisapp;
  }

  public BigDecimal getTaxe() {
    return taxe;
  }

  public void setTaxe(BigDecimal taxe) {
    this.taxe = taxe;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  public long getLot() {
    return lot;
  }

  public void setLot(long lot) {
    this.lot = lot;
  }

  public Double getTauxAmort() {
    return tauxAmort;
  }

  public void setTauxAmort(Double tauxAmort) {
    this.tauxAmort = tauxAmort;
  }

  public Double getDuree() {
    return duree;
  }

  public void setDuree(Double duree) {
    this.duree = duree;
  }

  public Double getPrixDzd() {
    return prixDzd;
  }

  public void setPrixDzd(Double prixDzd) {
    this.prixDzd = prixDzd;
  }

  public Double getTaxeDzd() {
    return taxeDzd;
  }

  public void setTaxeDzd(Double taxeDzd) {
    this.taxeDzd = taxeDzd;
  }

  public Double getFraisappDzd() {
    return fraisappDzd;
  }

  public void setFraisappDzd(Double fraisappDzd) {
    this.fraisappDzd = fraisappDzd;
  }

  public String getCodeATA100() {
    return codeATA100;
  }

  public void setCodeATA100(String codeATA100) {
    this.codeATA100 = codeATA100;
  }

  public String getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(String partNumber) {
    this.partNumber = partNumber;
  }

  public Long getFamilleid() {
    return familleid;
  }

  public void setFamilleid(Long familleid) {
    this.familleid = familleid;
  }

  public String getCodeAvion() {
    return codeAvion;
  }

  public void setCodeAvion(String codeAvion) {
    this.codeAvion = codeAvion;
  }

  public String getCompte28() {
    return compte28;
  }

  public void setCompte28(String compte28) {
    this.compte28 = compte28;
  }

  public String getCompte68() {
    return compte68;
  }

  public void setCompte68(String compte68) {
    this.compte68 = compte68;
  }

  public boolean getGv() {
    return gv;
  }

  public void setGv(boolean gv) {
    this.gv = gv;
  }

  public Double getPage() {
    return page;
  }

  public void setPage(Double page) {
    this.page = page;
  }

  public Dossier getDossier() {
    return dossier;
  }

  public void setDossier(Dossier dossier) {
    this.dossier = dossier;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Structure getStructure() {
    return structure;
  }

  public void setStructure(Structure structure) {
    this.structure = structure;
  }

  public UniteImmo getUnite() {
    return unite;
  }

  public void setUnite(UniteImmo unite) {
    this.unite = unite;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeNom != null ? codeNom.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Pv)) {
      return false;
    }
    Pv other = (Pv) object;
    if ((this.codeNom == null && other.codeNom != null)
        || (this.codeNom != null && !this.codeNom.equals(other.codeNom))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.gfc.entity.Pv[ codeNom=" + codeNom + " ]";
  }

}
