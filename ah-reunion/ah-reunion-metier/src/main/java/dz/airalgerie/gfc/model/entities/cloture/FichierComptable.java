/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cloture;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "fichier_comptable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichierComptable.findAll", query = "SELECT f FROM FichierComptable f"),
    @NamedQuery(name = "FichierComptable.findById",
        query = "SELECT f FROM FichierComptable f WHERE f.id = :id"),
    @NamedQuery(name = "FichierComptable.findByCodeNom",
        query = "SELECT f FROM FichierComptable f WHERE f.codeNom = :codeNom"),
    @NamedQuery(name = "FichierComptable.findByUniteId",
        query = "SELECT f FROM FichierComptable f WHERE f.uniteId = :uniteId"),
    @NamedQuery(name = "FichierComptable.findByDatecompte",
        query = "SELECT f FROM FichierComptable f WHERE f.datecompte = :datecompte"),
    @NamedQuery(name = "FichierComptable.findByDesignation",
        query = "SELECT f FROM FichierComptable f WHERE f.designation = :designation"),
    @NamedQuery(name = "FichierComptable.findByMarque",
        query = "SELECT f FROM FichierComptable f WHERE f.marque = :marque"),
    @NamedQuery(name = "FichierComptable.findByType",
        query = "SELECT f FROM FichierComptable f WHERE f.type = :type"),
    @NamedQuery(name = "FichierComptable.findByNumser",
        query = "SELECT f FROM FichierComptable f WHERE f.numser = :numser"),
    @NamedQuery(name = "FichierComptable.findByPrixStr",
        query = "SELECT f FROM FichierComptable f WHERE f.prix = :prix"),
    @NamedQuery(name = "FichierComptable.findByFraisappStr",
        query = "SELECT f FROM FichierComptable f WHERE f.fraisapp = :fraisapp"),
    @NamedQuery(name = "FichierComptable.findByTaxeStr",
        query = "SELECT f FROM FichierComptable f WHERE f.taxe = :taxe"),
    @NamedQuery(name = "FichierComptable.findByValeurStr",
        query = "SELECT f FROM FichierComptable f WHERE f.valeur = :valeur"),
    @NamedQuery(name = "FichierComptable.findByAmortissementMensuel",
        query = "SELECT f FROM FichierComptable f WHERE f.amortissementMensuel = :amortissementMensuel"),
    @NamedQuery(name = "FichierComptable.findByAmortissementCumule",
        query = "SELECT f FROM FichierComptable f WHERE f.amortissementCumule = :amortissementCumule"),
    @NamedQuery(name = "FichierComptable.findByCreated",
        query = "SELECT f FROM FichierComptable f WHERE f.created = :created")})
public class FichierComptable implements Serializable, Comparable<FichierComptable> {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name = "SEQf", sequenceName = "SEQUENCE2", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQf")
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "codeNom")
  private String codeNom;
  @Column(name = "uniteId")
  private Integer uniteId;
  @Column(name = "datecompte")
  @Temporal(TemporalType.DATE)
  private Date datecompte;
  @Size(max = 255)
  @Column(name = "designation")
  private String designation;
  @Size(max = 255)
  @Column(name = "marque")
  private String marque;
  @Size(max = 255)
  @Column(name = "type")
  private String type;
  @Column(name = "familleId")
  private Integer familleId;
  @Size(max = 255)
  @Column(name = "numser")
  private String numser;
  @Column(name = "prix")
  private BigDecimal prix;
  @Column(name = "fraisapp")
  private BigDecimal fraisapp = BigDecimal.ZERO;
  @Column(name = "taxe")
  private BigDecimal taxe = BigDecimal.ZERO;
  @Column(name = "valeur")
  private BigDecimal valeur;
  @Basic(optional = false)
  @NotNull
  @Column(name = "created")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Basic(optional = false)
  @NotNull
  @Column(name = "amortissement_mensuel")
  private BigDecimal amortissementMensuel;
  @Basic(optional = false)
  @NotNull
  @Column(name = "amortissement_cumule")
  private BigDecimal amortissementCumule = BigDecimal.ZERO;
  @Column(name = "duplique")
  private Integer duplique;
  @Column(name = "DATEACQ")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateAcq;

  public Date getDateAcq() {
    return dateAcq;
  }

  public void setDateAcq(Date dateAcq) {
    this.dateAcq = dateAcq;
  }

  public Integer getDuplique() {
    return duplique;
  }

  public void setDuplique(Integer duplique) {
    this.duplique = duplique;
  }

  public Integer getFamilleId() {
    return familleId;
  }

  public void setFamilleId(Integer familleId) {
    this.familleId = familleId;
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

  public BigDecimal getResidu() {
    if (this.amortissementCumule != null) {
      return this.valeur.subtract(this.amortissementCumule);
    }
    return BigDecimal.ZERO;
  }

  public String getAmortissementMensuelStr() {
    BigDecimal t = amortissementMensuel;
    t = t.setScale(2, RoundingMode.HALF_UP);
    DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
    symbols.setGroupingSeparator(' ');
    DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
    return formatter.format(t);
  }

  public String getAmortissementCumuleStr() {
    BigDecimal t = amortissementCumule;
    t = t.setScale(2, RoundingMode.HALF_UP);
    DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
    symbols.setGroupingSeparator(' ');
    DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
    return formatter.format(t);
  }

  public FichierComptable() {}

  public FichierComptable(Integer id) {
    this.id = id;
  }

  public FichierComptable(Integer id, String codeNom, BigDecimal valeur,
      BigDecimal amortissementMensuelStr, BigDecimal amortissementCumuleStr, Date created) {
    this.id = id;
    this.codeNom = codeNom;
    this.valeur = valeur;
    this.amortissementMensuel = amortissementMensuelStr;
    this.amortissementCumule = amortissementCumuleStr;
    this.created = created;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCodeNom() {
    return codeNom;
  }

  public void setCodeNom(String codeNom) {
    this.codeNom = codeNom;
  }

  public Integer getUniteId() {
    return uniteId;
  }

  public void setUniteId(Integer uniteId) {
    this.uniteId = uniteId;
  }

  public Date getDatecompte() {
    return datecompte;
  }

  public Date getDatecompteOrder() throws ParseException {
    if (datecompte == null) {
      SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
      return formater.parse("1800-01-01");
    }
    return datecompte;
  }

  public void setDatecompte(Date datecompte) {
    this.datecompte = datecompte;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
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

  public String getNumser() {
    return numser;
  }

  public void setNumser(String numser) {
    this.numser = numser;
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

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
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
    if (!(object instanceof FichierComptable)) {
      return false;
    }
    FichierComptable other = (FichierComptable) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.dsi.immo.model.FichierComptable[ id=" + id + " ]";
  }

  @Override
  public int compareTo(FichierComptable o) {
    return o.created.compareTo(created);
  }

}
