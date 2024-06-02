/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "RUB_SYSTEMATIQUE_T", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RubSystematique.findAll", query = "SELECT r FROM RubSystematique r")})
public class RubSystematique implements Serializable {

  private static final long serialVersionUID = 1L;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID_RSYST")
  private Integer idRsyst;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "VAL_MONTANT")
  private BigDecimal valMontant;
  @Column(name = "DATE_ECHEANCE")
  private Integer dateEcheance;
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer dateTrt;

  @JoinColumn(name = "CODE_RUB", referencedColumnName = "CODE_RUB")
  @ManyToOne(optional = false)
  private Rubrique codeRub;

  public RubSystematique() {}

  public RubSystematique(Integer idRsyst) {
    this.idRsyst = idRsyst;
  }

  public RubSystematique(Integer idRsyst, Integer matricule) {
    this.idRsyst = idRsyst;
    this.matricule = matricule;
  }

  public Integer getIdRsyst() {
    return idRsyst;
  }

  public void setIdRsyst(Integer idRsyst) {
    this.idRsyst = idRsyst;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public BigDecimal getValMontant() {
    return valMontant;
  }

  public void setValMontant(BigDecimal valMontant) {
    this.valMontant = valMontant;
  }

  public Integer getDateEcheance() {
    return dateEcheance;
  }

  public void setDateEcheance(Integer dateEcheance) {
    this.dateEcheance = dateEcheance;
  }

  public Rubrique getCodeRub() {
    if (codeRub == null) {
      codeRub = new Rubrique();
    }
    return codeRub;
  }

  public void setCodeRub(Rubrique codeRub) {
    this.codeRub = codeRub;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idRsyst != null ? idRsyst.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RubSystematique)) {
      return false;
    }
    RubSystematique other = (RubSystematique) object;
    if ((this.idRsyst == null && other.idRsyst != null)
        || (this.idRsyst != null && !this.idRsyst.equals(other.idRsyst))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.RubSystematique[ idRsyst=" + idRsyst + " ]";
  }

  public String toJSon() {
    return "\"RUB_SYSTEMATIQUE\" : [' {\"MATRICULE\":" + this.getMatricule() + ", \"DATE_TRT\": "
        + this.getDateTrt() + ", \"CODE_RUB\": '" + this.getCodeRub().getCodeRub()
        + "', \"VAL_MONTANT\": " + this.getValMontant() + ", \"DATE_ECHEANCE\": "
        + this.getDateEcheance() + "}";
  }

}
