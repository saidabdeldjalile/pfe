/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.fpn;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = ErpConstante.DbSchemaName.AGS_FPN, name = "OPTIONS")
@NamedQueries({@NamedQuery(name = "Options.findAll", query = "SELECT o FROM Options o")})
public class Options implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 150)
  @Column(name = "LIBELLE")
  private String libelle;
  @Column(name = "POSITION")
  private Integer position;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "optionId", fetch = FetchType.LAZY)
  private List<AsrEvents> asrEventsList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "optionId", fetch = FetchType.LAZY)
  private List<CsrEvents> csrEventsList;
  @JoinColumn(name = "CATEGORIE_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private OptionsCategorie categorieId;

  public Options() {
  }

  public Options(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public List<AsrEvents> getAsrEventsList() {
    return asrEventsList;
  }

  public void setAsrEventsList(List<AsrEvents> asrEventsList) {
    this.asrEventsList = asrEventsList;
  }

  public List<CsrEvents> getCsrEventsList() {
    return csrEventsList;
  }

  public void setCsrEventsList(List<CsrEvents> csrEventsList) {
    this.csrEventsList = csrEventsList;
  }

  public OptionsCategorie getCategorieId() {
    return categorieId;
  }

  public void setCategorieId(OptionsCategorie categorieId) {
    this.categorieId = categorieId;
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
    if (!(object instanceof Options)) {
      return false;
    }
    Options other = (Options) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.fpn.Option[ id=" + id + " ]";
  }

}
