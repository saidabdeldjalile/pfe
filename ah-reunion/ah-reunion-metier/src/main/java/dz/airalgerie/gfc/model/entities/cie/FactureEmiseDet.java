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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "FACTURE_EMISE_DET", catalog = "CPTA", schema = "CE")
@XmlRootElement

public class FactureEmiseDet implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "CPT_PREST", nullable = false, length = 12)
  private String cptPrest;
  @Size(max = 30)
  @Column(name = "LIB_PREST", length = 30)
  private String libPrest;
  @Size(max = 1)
  @Column(name = "CODE_IMP")
  private String codeImp;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "MNT_PREST", nullable = false, precision = 12, scale = 3)
  private BigDecimal mntPrest;
  @JoinColumns({@JoinColumn(name = "NUM_CIE", referencedColumnName = "NUM_CIE", nullable = false),
      @JoinColumn(name = "NUM_FCT", referencedColumnName = "NUM_FCT", nullable = false),
      @JoinColumn(name = "DATE_FCT", referencedColumnName = "DATE_FCT", nullable = false)})
  @ManyToOne(optional = false)
  private FactureEmise factureEmise;

  public FactureEmiseDet() {}

  public FactureEmiseDet(Integer id) {
    this.id = id;
  }

  public FactureEmiseDet(Integer id, String cptPrest, BigDecimal mntPrest) {
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

  public FactureEmise getFactureEmise() {
    return factureEmise;
  }

  public void setFactureEmise(FactureEmise factureEmise) {
    this.factureEmise = factureEmise;
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
    if (!(object instanceof FactureEmiseDet)) {
      return false;
    }
    FactureEmiseDet other = (FactureEmiseDet) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.FactureEmiseDet[ id=" + id + " ]";
  }

  public String getCodeImp() {
    return codeImp;
  }

  public void setCodeImp(String codeImp) {
    this.codeImp = codeImp;
  }

}
