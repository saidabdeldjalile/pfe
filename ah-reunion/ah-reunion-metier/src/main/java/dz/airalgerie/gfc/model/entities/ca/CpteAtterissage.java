/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Administrateur
 */
@Entity
@Table(name = "CPTE_ATTERISSAGE", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CpteAtterissage.findAll", query = "SELECT c FROM CpteAtterissage c"),
    @NamedQuery(name = "CpteAtterissage.findById",
        query = "SELECT c FROM CpteAtterissage c WHERE c.id = :id"),
    @NamedQuery(name = "CpteAtterissage.findByDateTrt",
        query = "SELECT c FROM CpteAtterissage c WHERE c.dateTrt = :dateTrt"),
    @NamedQuery(name = "CpteAtterissage.findByCaeEsc",
        query = "SELECT c FROM CpteAtterissage c WHERE c.caeEsc = :caeEsc"),
    @NamedQuery(name = "CpteAtterissage.findByTypeApp",
        query = "SELECT c FROM CpteAtterissage c WHERE c.typeApp = :typeApp"),
    @NamedQuery(name = "CpteAtterissage.findByCoutAttEgsaInt",
        query = "SELECT c FROM CpteAtterissage c WHERE c.coutAttEgsaInt = :coutAttEgsaInt"),
    @NamedQuery(name = "CpteAtterissage.findByCoutAttEgsaDom",
        query = "SELECT c FROM CpteAtterissage c WHERE c.coutAttEgsaDom = :coutAttEgsaDom"),
    @NamedQuery(name = "CpteAtterissage.findByCoutStatAlg",
        query = "SELECT c FROM CpteAtterissage c WHERE c.coutStatAlg = :coutStatAlg"),
    @NamedQuery(name = "CpteAtterissage.findByCoutAttEtr",
        query = "SELECT c FROM CpteAtterissage c WHERE c.coutAttEtr = :coutAttEtr"),
    @NamedQuery(name = "CpteAtterissage.findByCoutStatEtr",
        query = "SELECT c FROM CpteAtterissage c WHERE c.coutStatEtr = :coutStatEtr"),
    @NamedQuery(name = "CpteAtterissage.findByCodeMon",
        query = "SELECT c FROM CpteAtterissage c WHERE c.codeMon = :codeMon")})
public class CpteAtterissage implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Size(max = 6)
  @Column(name = "CAE_ESC")
  private String caeEsc;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "TYPE_APP")
  private String typeApp;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "COUT_ATT_EGSA_INT")
  private BigDecimal coutAttEgsaInt;
  @Column(name = "COUT_ATT_EGSA_DOM")
  private BigDecimal coutAttEgsaDom;
  @Column(name = "COUT_STAT_ALG")
  private BigDecimal coutStatAlg;
  @Column(name = "COUT_ATT_ETR")
  private BigDecimal coutAttEtr;
  @Column(name = "COUT_STAT_ETR")
  private BigDecimal coutStatEtr;
  @Size(max = 3)
  @Column(name = "CODE_MON")
  private String codeMon;

  public CpteAtterissage() {}

  public CpteAtterissage(Integer id) {
    this.id = id;
  }

  public CpteAtterissage(Integer id, int dateTrt, String typeApp) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.typeApp = typeApp;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getCaeEsc() {
    return caeEsc;
  }

  public void setCaeEsc(String caeEsc) {
    this.caeEsc = caeEsc;
  }

  public String getTypeApp() {
    return typeApp;
  }

  public void setTypeApp(String typeApp) {
    this.typeApp = typeApp;
  }

  public BigDecimal getCoutAttEgsaInt() {
    return coutAttEgsaInt;
  }

  public void setCoutAttEgsaInt(BigDecimal coutAttEgsaInt) {
    this.coutAttEgsaInt = coutAttEgsaInt;
  }

  public BigDecimal getCoutAttEgsaDom() {
    return coutAttEgsaDom;
  }

  public void setCoutAttEgsaDom(BigDecimal coutAttEgsaDom) {
    this.coutAttEgsaDom = coutAttEgsaDom;
  }

  public BigDecimal getCoutStatAlg() {
    return coutStatAlg;
  }

  public void setCoutStatAlg(BigDecimal coutStatAlg) {
    this.coutStatAlg = coutStatAlg;
  }

  public BigDecimal getCoutAttEtr() {
    return coutAttEtr;
  }

  public void setCoutAttEtr(BigDecimal coutAttEtr) {
    this.coutAttEtr = coutAttEtr;
  }

  public BigDecimal getCoutStatEtr() {
    return coutStatEtr;
  }

  public void setCoutStatEtr(BigDecimal coutStatEtr) {
    this.coutStatEtr = coutStatEtr;
  }

  public String getCodeMon() {
    return codeMon;
  }

  public void setCodeMon(String codeMon) {
    this.codeMon = codeMon;
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
    if (!(object instanceof CpteAtterissage)) {
      return false;
    }
    CpteAtterissage other = (CpteAtterissage) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteAtterissage[ id=" + id + " ]";
  }

}
