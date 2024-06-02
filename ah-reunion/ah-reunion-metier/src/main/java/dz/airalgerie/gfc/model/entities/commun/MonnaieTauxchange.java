/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diaf
 */
@Entity
@Table(name = "MONNAIE", schema = "CHANGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonnaieTauxchange.findAll", query = "SELECT m FROM MonnaieTauxchange m"),
    @NamedQuery(name = "MonnaieTauxchange.findByMonnaieId",
        query = "SELECT m FROM MonnaieTauxchange m WHERE m.monnaieId = :monnaieId"),
    @NamedQuery(name = "MonnaieTauxchange.findByMonnaieCode",
        query = "SELECT m FROM MonnaieTauxchange m WHERE m.monnaieCode = :monnaieCode"),
    @NamedQuery(name = "MonnaieTauxchange.findByLibelle",
        query = "SELECT m FROM MonnaieTauxchange m WHERE m.libelle = :libelle"),})
public class MonnaieTauxchange implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_MONNAIE")
  private Integer monnaieId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "CODE_ALPHA_NUM")
  private String monnaieCode;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  // @Size(max = 50)
  // @Column(name = "PAYS")
  // private String pays;
  // @OneToMany(cascade = CascadeType.ALL, mappedBy = "monnaieId")
  // private List<TauxDeChange> tauxDeChangeList;

  public MonnaieTauxchange() {}

  public MonnaieTauxchange(Integer monnaieId) {
    this.monnaieId = monnaieId;
  }

  public MonnaieTauxchange(Integer monnaieId, String monnaieCode) {
    this.monnaieId = monnaieId;
    this.monnaieCode = monnaieCode;
  }

  public Integer getMonnaieId() {
    return monnaieId;
  }

  public void setMonnaieId(Integer monnaieId) {
    this.monnaieId = monnaieId;
  }

  public String getMonnaieCode() {
    return monnaieCode;
  }

  public void setMonnaieCode(String monnaieCode) {
    this.monnaieCode = monnaieCode;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }
  
  public String getCodeMonnaieAsChar(){
      String temp = "000" + this.monnaieId;
      return temp.substring(temp.length() - 3);
  }

  // public String getPays() {
  // return pays;
  // }
  //
  // public void setPays(String pays) {
  // this.pays = pays;
  // }

  // @XmlTransient
  // public List<TauxDeChange> getTauxDeChangeList() {
  // return tauxDeChangeList;
  // }
  //
  // public void setTauxDeChangeList(List<TauxDeChange> tauxDeChangeList) {
  // this.tauxDeChangeList = tauxDeChangeList;
  // }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (monnaieId != null ? monnaieId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MonnaieTauxchange)) {
      return false;
    }
    MonnaieTauxchange other = (MonnaieTauxchange) object;
    if ((this.monnaieId == null && other.monnaieId != null)
        || (this.monnaieId != null && !this.monnaieId.equals(other.monnaieId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.commun.MonnaieTauxchange[ monnaieId=" + monnaieId
        + " ]";
  }

}
