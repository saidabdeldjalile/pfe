/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.fpn;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.portail.model.entities.events.Crew;
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

/**
 *
 */
@Entity
@Table(schema = ErpConstante.DbSchemaName.AGS_CAR, name = "V_PERSONNEL")
@NamedQueries({@NamedQuery(name = "PersonnelAgs.findAll", query = "SELECT p FROM PersonnelAgs p")})
public class PersonnelAgs implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Size(max = 150)
  @Column(name = "NOM")
  private String nom;
  @Column(name = "CODE_TECH")
  private String codeTech;
  @Size(max = 150)
  @Column(name = "FONCTION")
  private String fonction;
  @OneToMany(mappedBy = "personnel", fetch = FetchType.LAZY)
  private List<Crew> crewList;
  @OneToMany(mappedBy = "personnelAgs", fetch = FetchType.LAZY)
  private List<Asr> asrList;
  @OneToMany(mappedBy = "secondPilote", fetch = FetchType.LAZY)
  private List<Asr> mentionedAsrList;
  @OneToMany(mappedBy = "personnelAgs", fetch = FetchType.LAZY)
  private List<AsrComments> asrCommentsList;
  @OneToMany(mappedBy = "personnelAgs", fetch = FetchType.LAZY)
  private List<Csr> csrList;
  @OneToMany(mappedBy = "pilote", fetch = FetchType.LAZY)
  private List<Csr> piloteCsrList;
  @OneToMany(mappedBy = "personnelAgs", fetch = FetchType.LAZY)
  private List<CsrComments> csrCommentsList;

  public PersonnelAgs() {
  }

  public PersonnelAgs(Integer matricule) {
    this.matricule = matricule;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(String codeTech) {
    this.codeTech = codeTech;
  }

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public List<Crew> getCrewList() {
    return crewList;
  }

  public void setCrewList(List<Crew> crewList) {
    this.crewList = crewList;
  }

  public List<Asr> getAsrList() {
    return asrList;
  }

  public void setAsrList(List<Asr> asrList) {
    this.asrList = asrList;
  }

  public List<Asr> getMentionedAsrList() {
    return mentionedAsrList;
  }

  public void setMentionedAsrList(List<Asr> mentionedAsrList) {
    this.mentionedAsrList = mentionedAsrList;
  }

  public List<AsrComments> getAsrCommentsList() {
    return asrCommentsList;
  }

  public void setAsrCommentsList(List<AsrComments> asrCommentsList) {
    this.asrCommentsList = asrCommentsList;
  }

  public List<Csr> getCsrList() {
    return csrList;
  }

  public void setCsrList(List<Csr> csrList) {
    this.csrList = csrList;
  }

  public List<Csr> getPiloteCsrList() {
    return piloteCsrList;
  }

  public void setPiloteCsrList(List<Csr> piloteCsrList) {
    this.piloteCsrList = piloteCsrList;
  }

  public List<CsrComments> getCsrCommentsList() {
    return csrCommentsList;
  }

  public void setCsrCommentsList(List<CsrComments> csrCommentsList) {
    this.csrCommentsList = csrCommentsList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (matricule != null ? matricule.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PersonnelAgs)) {
      return false;
    }
    PersonnelAgs other = (PersonnelAgs) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.fpn.PersonnelAgs[ matricule=" + matricule + " ]";
  }

}
