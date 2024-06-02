/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "bien_amorti")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "BienAmorti.findAll", query = "SELECT f FROM BienAmorti f"),
    @NamedQuery(name = "BienAmorti.findById",
        query = "SELECT f FROM BienAmorti f WHERE f.id = :id"),
    @NamedQuery(name = "BienAmorti.findByCodeNom",
        query = "SELECT f FROM BienAmorti f WHERE f.codeNom = :codeNom"),
    @NamedQuery(name = "BienAmorti.findByUniteId",
        query = "SELECT f FROM BienAmorti f WHERE f.uniteId = :uniteId"),
    @NamedQuery(name = "BienAmorti.findByDatecompte",
        query = "SELECT f FROM BienAmorti f WHERE f.datecompte = :datecompte"),
    @NamedQuery(name = "BienAmorti.findByDesignation",
        query = "SELECT f FROM BienAmorti f WHERE f.designation = :designation"),
    @NamedQuery(name = "BienAmorti.findByMarque",
        query = "SELECT f FROM BienAmorti f WHERE f.marque = :marque"),
    @NamedQuery(name = "BienAmorti.findByType",
        query = "SELECT f FROM BienAmorti f WHERE f.type = :type"),
    @NamedQuery(name = "BienAmorti.findByNumser",
        query = "SELECT f FROM BienAmorti f WHERE f.numser = :numser"),
    @NamedQuery(name = "BienAmorti.findByPrixStr",
        query = "SELECT f FROM BienAmorti f WHERE f.prixStr = :prixStr"),
    @NamedQuery(name = "BienAmorti.findByFraisappStr",
        query = "SELECT f FROM BienAmorti f WHERE f.fraisappStr = :fraisappStr"),
    @NamedQuery(name = "BienAmorti.findByTaxeStr",
        query = "SELECT f FROM BienAmorti f WHERE f.taxeStr = :taxeStr"),
    @NamedQuery(name = "BienAmorti.findByValeurStr",
        query = "SELECT f FROM BienAmorti f WHERE f.valeurStr = :valeurStr"),
    @NamedQuery(name = "BienAmorti.findByAmortissementMensuelStr",
        query = "SELECT f FROM BienAmorti f WHERE f.amortissementMensuelStr = :amortissementMensuelStr"),
    @NamedQuery(name = "BienAmorti.findByAmortissementCumuleStr",
        query = "SELECT f FROM BienAmorti f WHERE f.amortissementCumuleStr = :amortissementCumuleStr"),
    @NamedQuery(name = "BienAmorti.findByCreated",
        query = "SELECT f FROM BienAmorti f WHERE f.created = :created")})
public class BienAmorti implements Serializable, Comparable<BienAmorti> {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(name = "SEQb", sequenceName = "SEQUENCE1", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQb")
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "codeNom")
  private String codeNom;
  @Size(max = 50)
  @Column(name = "uniteId")
  private String uniteId;
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
  @Size(max = 255)
  @Column(name = "numser")
  private String numser;
  @Size(max = 255)
  @Column(name = "prixStr")
  private String prixStr;
  @Size(max = 255)
  @Column(name = "fraisappStr")
  private String fraisappStr;
  @Size(max = 255)
  @Column(name = "taxeStr")
  private String taxeStr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "valeurStr")
  private String valeurStr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "amortissementMensuelStr")
  private String amortissementMensuelStr;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "amortissementCumuleStr")
  private String amortissementCumuleStr;
  @Basic(optional = false)
  @NotNull
  @Column(name = "created")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Basic(optional = false)
  @NotNull
  @Column(name = "residu")
  private BigDecimal residu = BigDecimal.ZERO;

  public BigDecimal getResidu() {
    return residu;
  }

  public void setResidu(BigDecimal residu) {
    this.residu = residu;
  }

  public BienAmorti() {}

  public BienAmorti(Integer id) {
    this.id = id;
  }

  public BienAmorti(Integer id, String codeNom, String valeurStr, String amortissementMensuelStr,
      String amortissementCumuleStr, Date created) {
    this.id = id;
    this.codeNom = codeNom;
    this.valeurStr = valeurStr;
    this.amortissementMensuelStr = amortissementMensuelStr;
    this.amortissementCumuleStr = amortissementCumuleStr;
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

  public String getUniteId() {
    return uniteId;
  }

  public void setUniteId(String uniteId) {
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

  public String getPrixStr() {
    return prixStr;
  }

  public void setPrixStr(String prixStr) {
    this.prixStr = prixStr;
  }

  public String getFraisappStr() {
    return fraisappStr;
  }

  public void setFraisappStr(String fraisappStr) {
    this.fraisappStr = fraisappStr;
  }

  public String getTaxeStr() {
    return taxeStr;
  }

  public void setTaxeStr(String taxeStr) {
    this.taxeStr = taxeStr;
  }

  public String getValeurStr() {
    return valeurStr;
  }

  public void setValeurStr(String valeurStr) {
    this.valeurStr = valeurStr;
  }

  public String getAmortissementMensuelStr() {
    return amortissementMensuelStr;
  }

  public void setAmortissementMensuelStr(String amortissementMensuelStr) {
    this.amortissementMensuelStr = amortissementMensuelStr;
  }

  public String getAmortissementCumuleStr() {
    return amortissementCumuleStr;
  }

  public void setAmortissementCumuleStr(String amortissementCumuleStr) {
    this.amortissementCumuleStr = amortissementCumuleStr;
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
    if (!(object instanceof BienAmorti)) {
      return false;
    }
    BienAmorti other = (BienAmorti) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.dsi.immo.model.BienAmorti[ id=" + id + " ]";
  }

  @Override
  public int compareTo(BienAmorti o) {
    return o.created.compareTo(created);
  }

}
