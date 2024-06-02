/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.commun.model.entities.commun.DirectionCpta;
import dz.airalgerie.gfc.model.entities.fac.FactureFac;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "STRUCTURE")
public class StructureCpta implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(min = 1, max = 2)
  @Column(name = "CODE_UNITE")
  private String codeUnite;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Size(max = 15)
  @Column(name = "CODE_IATA")
  private String codeIata;
  @Size(max = 50)
  @Column(name = "ABBR")
  private String libelleAbbr;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "structure", fetch = FetchType.LAZY)
  private List<Caisse> caisseList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "structure", fetch = FetchType.LAZY)
  private List<JournalOd> journalOd;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "structure", fetch = FetchType.LAZY)
  private List<FactureFac> FactureList;


  public StructureCpta() {
  }

  public StructureCpta(Integer id) {
    this.id = id;
  }

  public StructureCpta(Integer id, String libelle, String grpChap, String codeIata,
      DirectionCpta direction) {
    this.id = id;
    this.libelle = libelle;
    this.grpChap = grpChap;
    this.codeIata = codeIata;
  }

  public StructureCpta(Integer id, String libelle, String grpChap, String codeIata) {
    this.id = id;
    this.libelle = libelle;
    this.grpChap = grpChap;
    this.codeIata = codeIata;
  }

  public StructureCpta(Integer id, String libelle, String grpChap, String codeIata,
      String libelleAbbr) {
    this.id = id;
    this.libelle = libelle;
    this.grpChap = grpChap;
    this.codeIata = codeIata;
    this.libelleAbbr = libelleAbbr;
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

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public String getCodeIata() {
    return codeIata;
  }

  public void setCodeIata(String codeIata) {
    this.codeIata = codeIata;
  }

  public String getLibelleAbbr() {
    return libelleAbbr;
  }

  public void setLibelleAbbr(String libelleAbbr) {
    this.libelleAbbr = libelleAbbr;
  }

  public List<Caisse> getCaisseList() {
    return caisseList;
  }

  public void setCaisseList(List<Caisse> caisseList) {
    this.caisseList = caisseList;
  }

  public List<JournalOd> getJournalOd() {
    return journalOd;
  }

  public void setJournalOd(List<JournalOd> journalOd) {
    this.journalOd = journalOd;
  }

  public String getCodeUnite() {
    return codeUnite;
  }

  public void setCodeUnite(String codeUnite) {
    this.codeUnite = codeUnite;
  }

  public List<FactureFac> getFactureList() {
    return FactureList;
  }

  public void setFactureList(List<FactureFac> FactureList) {
    this.FactureList = FactureList;
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
    if (!(object instanceof StructureCpta)) {
      return false;
    }
    StructureCpta other = (StructureCpta) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.Structure[ id=" + id + " ]";
  }

}
