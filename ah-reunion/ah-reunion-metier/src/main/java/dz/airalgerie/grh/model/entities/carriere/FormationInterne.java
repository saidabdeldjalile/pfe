/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "FRM", name = "FORMATION_INT")
public class FormationInterne implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
  @Size(max = 100)
  @Column(name = "ORGANISME")
  private String organisme;
  @Size(max = 10)
  @Column(name = "DATE_DEB")
  private String dateDeb;
  @Size(max = 10)
  @Column(name = "DATE_FIN")
  private String dateFin;
  @Column(name = "DUR_CONT")
  private Integer durCont;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "COUT_FRM")
  private BigDecimal coutFrm;
  @JoinColumn(name = "CODE_THM", referencedColumnName = "CODE_THM")
  @ManyToOne(fetch = FetchType.LAZY)
  private Theme theme;
  @JoinColumn(name = "CODE_SFL", referencedColumnName = "CODE_SFL")
  @ManyToOne(fetch = FetchType.LAZY)
  private SousFiliere sousFiliere;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;
  @JoinColumn(name = "CODE_DIP", referencedColumnName = "CODE_DIP")
  @ManyToOne(fetch = FetchType.LAZY)
  private Diplome diplome;

  public FormationInterne() {}

  public FormationInterne(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrganisme() {
    return organisme;
  }

  public void setOrganisme(String organisme) {
    this.organisme = organisme;
  }

  public String getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(String dateDeb) {
    this.dateDeb = dateDeb;
  }

  public String getDateFin() {
    return dateFin;
  }

  public void setDateFin(String dateFin) {
    this.dateFin = dateFin;
  }

  public Integer getDurCont() {
    return durCont;
  }

  public void setDurCont(Integer durCont) {
    this.durCont = durCont;
  }

  public BigDecimal getCoutFrm() {
    return coutFrm;
  }

  public void setCoutFrm(BigDecimal coutFrm) {
    this.coutFrm = coutFrm;
  }

  public Theme getTheme() {
    return theme;
  }

  public void setTheme(Theme theme) {
    this.theme = theme;
  }

  public SousFiliere getSousFiliere() {
    return sousFiliere;
  }

  public void setSousFiliere(SousFiliere sousFiliere) {
    this.sousFiliere = sousFiliere;
  }

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public Diplome getDiplome() {
    return diplome;
  }

  public void setDiplome(Diplome diplome) {
    this.diplome = diplome;
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
    if (!(object instanceof FormationInterne)) {
      return false;
    }
    FormationInterne other = (FormationInterne) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.FormationInterne[ id=" + id + " ]";
  }

}
