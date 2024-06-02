/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.cu;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "BANQUE")
public class BanqueCpta implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_BANQUE")
  private Integer codeBanque;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @JoinColumn(name = "ID_BANQUE", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private BanqueMere banqueMere;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "banqueCpta", fetch = FetchType.LAZY)
  private List<BanqueContrepartie> banqueContrepartieList;
  @ManyToMany(mappedBy = "caisseBanqueList")
  private List<Caisse> caisseList;

  public BanqueCpta() {
  }

  public BanqueCpta(Integer codeBanque) {
    this.codeBanque = codeBanque;
  }

  public BanqueCpta(Integer codeBanque, String libelle, BanqueMere banqueMere) {
    this.codeBanque = codeBanque;
    this.libelle = libelle;
    this.banqueMere = banqueMere;
  }

  public Integer getCodeBanque() {
    return codeBanque;
  }

  public void setCodeBanque(Integer codeBanque) {
    this.codeBanque = codeBanque;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BanqueMere getBanqueMere() {
    return banqueMere;
  }

  public void setBanqueMere(BanqueMere banqueMere) {
    this.banqueMere = banqueMere;
  }

  public List<BanqueContrepartie> getBanqueContrepartieList() {
    return banqueContrepartieList;
  }

  public void setBanqueContrepartieList(List<BanqueContrepartie> banqueContrepartieList) {
    this.banqueContrepartieList = banqueContrepartieList;
  }

  public List<Caisse> getCaisseList() {
    return caisseList;
  }

  public void setCaisseList(List<Caisse> caisseList) {
    this.caisseList = caisseList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeBanque != null ? codeBanque.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof BanqueCpta) {
      return (Objects.equals(this.getCodeBanque(), ((BanqueCpta) object).getCodeBanque()));
    }
    return false;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.Banque[ codeBanque=" + codeBanque + " ]";
  }
}
