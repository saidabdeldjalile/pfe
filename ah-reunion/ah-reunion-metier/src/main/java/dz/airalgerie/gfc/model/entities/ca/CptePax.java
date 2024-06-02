/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CPTE_PAX", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CptePax.findAll", query = "SELECT c FROM CptePax c"),
    @NamedQuery(name = "CptePax.findByDateTrt",
        query = "SELECT c FROM CptePax c WHERE c.cptePaxPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "CptePax.findByCaeEsc",
        query = "SELECT c FROM CptePax c WHERE c.cptePaxPK.caeEsc = :caeEsc"),
    @NamedQuery(name = "CptePax.findByCoutUnitPaxEsc",
        query = "SELECT c FROM CptePax c WHERE c.coutUnitPaxEsc = :coutUnitPaxEsc"),
    @NamedQuery(name = "CptePax.findByCodeMonnaie",
        query = "SELECT c FROM CptePax c WHERE c.codeMonnaie = :codeMonnaie")})
public class CptePax implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CptePaxPK cptePaxPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "COUT_UNIT_PAX_ESC")
  private BigDecimal coutUnitPaxEsc;
  @Size(max = 3)
  @Column(name = "CODE_MON")
  private String codeMonnaie;

  public CptePax() {}

  public CptePax(CptePaxPK cptePaxPK) {
    this.cptePaxPK = cptePaxPK;
  }

  public CptePax(int dateTrt, String caeEsc) {
    this.cptePaxPK = new CptePaxPK(dateTrt, caeEsc);
  }

  public CptePaxPK getCptePaxPK() {
    if (cptePaxPK == null)
      cptePaxPK = new CptePaxPK();

    return cptePaxPK;
  }

  public void setCptePaxPK(CptePaxPK cptePaxPK) {
    this.cptePaxPK = cptePaxPK;
  }

  public BigDecimal getCoutUnitPaxEsc() {
    return coutUnitPaxEsc;
  }

  public void setCoutUnitPaxEsc(BigDecimal coutUnitPaxEsc) {
    this.coutUnitPaxEsc = coutUnitPaxEsc;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cptePaxPK != null ? cptePaxPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CptePax)) {
      return false;
    }
    CptePax other = (CptePax) object;
    if ((this.cptePaxPK == null && other.cptePaxPK != null)
        || (this.cptePaxPK != null && !this.cptePaxPK.equals(other.cptePaxPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CptePax[ cptePaxPK=" + cptePaxPK + " ]";
  }

}
