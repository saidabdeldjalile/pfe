/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.portail.model.entities.fpn;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.ExistenceChecking;
import org.eclipse.persistence.annotations.ExistenceType;

/**
 *
 */
@Entity
@ExistenceChecking(ExistenceType.ASSUME_EXISTENCE)
@Table(name = "PHASE_VOL", schema = "FPN")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "PhaseVol.findAll", query = "SELECT p FROM PhaseVol p")})
public class PhaseVol implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "CODE_TECH")
  private String codeTech;
  @Size(max = 70)
  @Column(name = "LIBELLE")
  private String libelle;
  @Basic(optional = false)
  @NotNull
  @Column(name = "POSITION")
  private short position;
  @ManyToMany(mappedBy = "phaseVolList", fetch = FetchType.LAZY)
  private List<FormEventPnc> formEventPncList;

  public PhaseVol() {
  }

  public PhaseVol(Integer id) {
    this.id = id;
  }

  public PhaseVol(Integer id, short position) {
    this.id = id;
    this.position = position;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(String codeTech) {
    this.codeTech = codeTech;
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
    if (!(object instanceof PhaseVol)) {
      return false;
    }
    PhaseVol other = (PhaseVol) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.fpn.PhaseVol[ id=" + id + " ]";
  }


  @XmlTransient
  public List<FormEventPnc> getFormEventPncList() {
    return formEventPncList;
  }

  public void setFormEventPncList(List<FormEventPnc> formEventPncList) {
    this.formEventPncList = formEventPncList;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public short getPosition() {
    return position;
  }

  public void setPosition(short position) {
    this.position = position;
  }

}
