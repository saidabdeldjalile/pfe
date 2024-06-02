/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "FACTURE_RECUE_DET", schema = "CE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactureRecueDet.findAll", query = "SELECT f FROM FactureRecueDet f"),
    @NamedQuery(name = "FactureRecueDet.findById",
        query = "SELECT f FROM FactureRecueDet f WHERE f.id = :id"),
    @NamedQuery(name = "FactureRecueDet.findByCptPrest",
        query = "SELECT f FROM FactureRecueDet f WHERE f.cptPrest = :cptPrest"),
    @NamedQuery(name = "FactureRecueDet.findByLibPrest",
        query = "SELECT f FROM FactureRecueDet f WHERE f.libPrest = :libPrest"),
    @NamedQuery(name = "FactureRecueDet.findByMntPrest",
        query = "SELECT f FROM FactureRecueDet f WHERE f.mntPrest = :mntPrest"),
    @NamedQuery(name = "FactureRecueDet.findByCodeImp",
        query = "SELECT f FROM FactureRecueDet f WHERE f.codeImp = :codeImp")})
public class FactureRecueDet implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "CPT_PREST")
  private String cptPrest;
  @Size(max = 30)
  @Column(name = "LIB_PREST")
  private String libPrest;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "MNT_PREST")
  private BigDecimal mntPrest;
  @Size(max = 1)
  @Column(name = "CODE_IMP")
  private String codeImp;
  @JoinColumns({@JoinColumn(name = "NUM_CIE", referencedColumnName = "NUM_CIE"),
      @JoinColumn(name = "NUM_FCT", referencedColumnName = "NUM_FCT"),
      @JoinColumn(name = "DATE_FCT", referencedColumnName = "DATE_FCT")})
  @ManyToOne(optional = false)
  private FactureRecue factureRecue;

  public FactureRecueDet() {}

  public FactureRecueDet(Integer id) {
    this.id = id;
  }

  public FactureRecueDet(Integer id, String cptPrest, BigDecimal mntPrest) {
    this.id = id;
    this.cptPrest = cptPrest;
    this.mntPrest = mntPrest;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCptPrest() {
    return cptPrest;
  }

  public void setCptPrest(String cptPrest) {
    this.cptPrest = cptPrest;
  }

  public String getLibPrest() {
    return libPrest;
  }

  public void setLibPrest(String libPrest) {
    this.libPrest = libPrest;
  }

  public BigDecimal getMntPrest() {
    if (mntPrest != null)
      return mntPrest;// .setScale(2, RoundingMode.CEILING);
    else
      return mntPrest;
  }

  public void setMntPrest(BigDecimal mntPrest) {
    this.mntPrest = mntPrest;// .setScale(2, RoundingMode.CEILING);
  }

  public String getCodeImp() {
    return codeImp;
  }

  public void setCodeImp(String codeImp) {
    this.codeImp = codeImp;
  }

  public FactureRecue getFactureRecue() {
    return factureRecue;
  }

  public void setFactureRecue(FactureRecue factureRecue) {
    this.factureRecue = factureRecue;
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
    if (!(object instanceof FactureRecueDet)) {
      return false;
    }
    FactureRecueDet other = (FactureRecueDet) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.FactureRecueDet[ id=" + id + " ]";
  }

}
