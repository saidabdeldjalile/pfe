/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Feelynn
 */
@Entity
@Table(schema = "GP", name = "CONTROL")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "ControlGp.findAll", query = "SELECT c FROM ControlGp c"),
    @NamedQuery(name = "ControlGp.findByMatricule",
        query = "SELECT c FROM ControlGp c WHERE c.matricule = :matricule"),
    @NamedQuery(name = "ControlGp.findByConjoints",
        query = "SELECT c FROM ControlGp c WHERE c.conjoints = :conjoints"),
    @NamedQuery(name = "ControlGp.findByParents",
        query = "SELECT c FROM ControlGp c WHERE c.parents = :parents"),
    @NamedQuery(name = "ControlGp.findByEnfants",
        query = "SELECT c FROM ControlGp c WHERE c.enfants = :enfants"),
    @NamedQuery(name = "ControlGp.findByFreresoeur",
        query = "SELECT c FROM ControlGp c WHERE c.freresoeur = :freresoeur"),
    @NamedQuery(name = "ControlGp.findByObservation",
        query = "SELECT c FROM ControlGp c WHERE c.observation = :observation"),
    @NamedQuery(name = "ControlGp.findByValidation",
        query = "SELECT c FROM ControlGp c WHERE c.validation = :validation")})
public class ControlGp implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Column(name = "CODE_DIR")
  private String codeDir;
  @Size(max = 50)
  @Column(name = "CONJOINTS")
  private String conjoints;
  @Size(max = 50)
  @Column(name = "PARENTS")
  private String parents;
  @Size(max = 50)
  @Column(name = "ENFANTS")
  private String enfants;
  @Size(max = 50)
  @Column(name = "FRERESOEUR")
  private String freresoeur;
  @Size(max = 255)
  @Column(name = "OBSERVATION")
  private String observation;
  @Column(name = "VALIDATION")
  private Boolean validation;
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  private PersonnelLite personnel;

  public ControlGp(Integer matricule,String codeDir, String conjoints, String parents, String enfants,
      String freresoeur, String observation, Boolean validation,PersonnelLite personnel) {
    this.matricule = matricule;
    this.codeDir = codeDir;
    this.conjoints = conjoints;
    this.parents = parents;
    this.enfants = enfants;
    this.freresoeur = freresoeur;
    this.observation = observation;
    this.validation = validation;
    this.personnel = personnel;
  }

  public ControlGp() {
  }

  public ControlGp(Integer matricule) {
    this.matricule = matricule;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getConjoints() {
    return conjoints;
  }

  public void setConjoints(String conjoints) {
    this.conjoints = conjoints;
  }

  public String getParents() {
    return parents;
  }

  public void setParents(String parents) {
    this.parents = parents;
  }

  public String getEnfants() {
    return enfants;
  }

  public void setEnfants(String enfants) {
    this.enfants = enfants;
  }

  public String getFreresoeur() {
    return freresoeur;
  }

  public void setFreresoeur(String freresoeur) {
    this.freresoeur = freresoeur;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Boolean getValidation() {
    return validation;
  }

  public void setValidation(Boolean validation) {
    this.validation = validation;
  }

  public PersonnelLite getPersonnel() {
    return personnel;
  }

  public void setPersonnel(PersonnelLite personnel) {
    this.personnel = personnel;
  }

  public String getCodeDir() {
    return codeDir;
  }

  public void setCodeDir(String codeDir) {
    this.codeDir = codeDir;
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
    if (!(object instanceof ControlGp)) {
      return false;
    }
    ControlGp other = (ControlGp) object;
    if ((this.matricule == null && other.matricule != null)
        || (this.matricule != null && !this.matricule.equals(other.matricule))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.grh.model.entities.gp.Control[ matricule=" + matricule + " ]";
  }

}
