/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import dz.airalgerie.gfc.model.entities.immo.Dossierreforme;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "UNITE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "UniteImmo.findAll", query = "SELECT u FROM UniteImmo u")})
public class UniteImmo implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "UNITEID")
  private Integer uniteId;
  @Size(max = 5)
  @Column(name = "CPTSIGLE")
  private String cptsigle;
  @Column(name = "CODEMONNAIE")
  private Long codemonnaie;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "COMPTE_COMPTABLE")
  private Long compteComptable;
  @Column(name = "CODE_ANALYTIQUE")
  private Long codeAnalytique;
  @Size(max = 255)
  @Column(name = "ADRESSE")
  private String adresse;
  @Size(max = 255)
  @Column(name = "VILLE")
  private String ville;
  @Size(max = 255)
  @Column(name = "TEL")
  private String tel;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax
  // format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using
  // this annotation to enforce field validation
  @Size(max = 255)
  @Column(name = "FAX")
  private String fax;
  @Size(max = 255)
  @Column(name = "unite_groupe")
  private String uniteGroupe;
  @OneToMany(mappedBy = "unite", fetch = FetchType.LAZY)
  private List<Dossierreforme> dossierreformeList;

  public UniteImmo() {}

  public UniteImmo(Integer uniteId) {
    this.uniteId = uniteId;
  }

  public Integer getUniteId() {
    return uniteId;
  }

  public void setUniteId(Integer uniteId) {
    this.uniteId = uniteId;
  }

  public String getCptsigle() {
    return cptsigle;
  }

  public void setCptsigle(String cptsigle) {
    this.cptsigle = cptsigle;
  }

  public Long getCodemonnaie() {
    return codemonnaie;
  }

  public void setCodemonnaie(Long codemonnaie) {
    this.codemonnaie = codemonnaie;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Long getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(Long compteComptable) {
    this.compteComptable = compteComptable;
  }

  public Long getCodeAnalytique() {
    return codeAnalytique;
  }

  public void setCodeAnalytique(Long codeAnalytique) {
    this.codeAnalytique = codeAnalytique;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getUniteGroupe() {
    return uniteGroupe;
  }

  public void setUniteGroupe(String uniteGroupe) {
    this.uniteGroupe = uniteGroupe;
  }

  @XmlTransient
  public List<Dossierreforme> getDossierreformeList() {
    return dossierreformeList;
  }

  public void setDossierreformeList(List<Dossierreforme> dossierreformeList) {
    this.dossierreformeList = dossierreformeList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (uniteId != null ? uniteId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UniteImmo)) {
      return false;
    }
    UniteImmo other = (UniteImmo) object;
    if ((this.uniteId == null && other.uniteId != null)
        || (this.uniteId != null && !this.uniteId.equals(other.uniteId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.UniteImmo[ uniteid=" + uniteId + " ]";
  }

}
