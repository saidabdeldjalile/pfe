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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "CPTE_SURVOL", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CpteSurvol.findAll", query = "SELECT c FROM CpteSurvol c"),
    @NamedQuery(name = "CpteSurvol.findByDateTrt",
        query = "SELECT c FROM CpteSurvol c WHERE c.cpteSurvolPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "CpteSurvol.findByNumLigne",
        query = "SELECT c FROM CpteSurvol c WHERE c.cpteSurvolPK.numLigne = :numLigne"),
    @NamedQuery(name = "CpteSurvol.findByTypeApp",
        query = "SELECT c FROM CpteSurvol c WHERE c.cpteSurvolPK.typeApp = :typeApp"),
    @NamedQuery(name = "CpteSurvol.findByRelation",
        query = "SELECT c FROM CpteSurvol c WHERE c.cpteSurvolPK.relation = :relation"),
    @NamedQuery(name = "CpteSurvol.findByCodeMonnaie",
        query = "SELECT c FROM CpteSurvol c WHERE c.codeMonnaie = :codeMonnaie"),
    @NamedQuery(name = "CpteSurvol.findByCoutEnna",
        query = "SELECT c FROM CpteSurvol c WHERE c.coutEnna = :coutEnna"),
    @NamedQuery(name = "CpteSurvol.findByCoutSurvolEtg",
        query = "SELECT c FROM CpteSurvol c WHERE c.coutSurvolEtg = :coutSurvolEtg"),
    @NamedQuery(name = "CpteSurvol.findByTauxConv",
        query = "SELECT c FROM CpteSurvol c WHERE c.tauxConv = :tauxConv")})
public class CpteSurvol implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CpteSurvolPK cpteSurvolPK;
  @Size(max = 3)
  @Column(name = "CODE_MON")
  private String codeMonnaie;

  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "COUT_ENNA")
  private BigDecimal coutEnna;
  @Column(name = "COUT_SURVOL_ETG")
  private BigDecimal coutSurvolEtg;
  @Column(name = "TAUX_CONV")
  private BigDecimal tauxConv;
  @JoinColumns({
      @JoinColumn(name = "NUM_LIGNE", referencedColumnName = "NUM_LIGNE", insertable = false,
          updatable = false),
      @JoinColumn(name = "RELATION", referencedColumnName = "RELATION", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private CpteLigne cpteLigne;

  public CpteSurvol() {}

  public CpteSurvol(CpteSurvolPK cpteSurvolPK) {
    this.cpteSurvolPK = cpteSurvolPK;
  }

  public CpteSurvol(int dateTrt, short numLigne, String typeApp, String relation) {
    this.cpteSurvolPK = new CpteSurvolPK(dateTrt, numLigne, typeApp, relation);
  }

  public CpteSurvolPK getCpteSurvolPK() {

    if (cpteSurvolPK == null)
      cpteSurvolPK = new CpteSurvolPK();

    return cpteSurvolPK;
  }

  public void setCpteSurvolPK(CpteSurvolPK cpteSurvolPK) {
    this.cpteSurvolPK = cpteSurvolPK;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public BigDecimal getCoutEnna() {
    return coutEnna;
  }

  public void setCoutEnna(BigDecimal coutEnna) {
    this.coutEnna = coutEnna;
  }

  public BigDecimal getCoutSurvolEtg() {
    return coutSurvolEtg;
  }

  public void setCoutSurvolEtg(BigDecimal coutSurvolEtg) {
    this.coutSurvolEtg = coutSurvolEtg;
  }

  public BigDecimal getTauxConv() {
    return tauxConv;
  }

  public void setTauxConv(BigDecimal tauxConv) {
    this.tauxConv = tauxConv;
  }

  public CpteLigne getCpteLigne() {
    return cpteLigne;
  }

  public void setCpteLigne(CpteLigne cpteLigne) {
    this.cpteLigne = cpteLigne;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cpteSurvolPK != null ? cpteSurvolPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteSurvol)) {
      return false;
    }
    CpteSurvol other = (CpteSurvol) object;
    if ((this.cpteSurvolPK == null && other.cpteSurvolPK != null)
        || (this.cpteSurvolPK != null && !this.cpteSurvolPK.equals(other.cpteSurvolPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteSurvol[ cpteSurvolPK=" + cpteSurvolPK + " ]";
  }

}
