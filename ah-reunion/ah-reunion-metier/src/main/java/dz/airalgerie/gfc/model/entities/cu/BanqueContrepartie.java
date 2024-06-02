/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.entities.commun.CompteComptable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "BANQUE_CONTREPARTIE")
@NamedQueries({
    @NamedQuery(name = "BanqueContrepartie.findAll", query = "SELECT b FROM BanqueContrepartie b"),
    @NamedQuery(name = "BanqueContrepartie.findById",
        query = "SELECT b FROM BanqueContrepartie b WHERE b.id = :id"),
    @NamedQuery(name = "BanqueContrepartie.findByCodeMonnaie",
        query = "SELECT b FROM BanqueContrepartie b WHERE b.codeMonnaie = :codeMonnaie")})
public class BanqueContrepartie implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Size(max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  @Column(name = "IS_CIB")
  private boolean isCib;
  @Column(name = "IS_CC")
  private boolean isCc;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "banqueContrepartie", fetch = FetchType.LAZY)
  private List<PieceBanqueDetails> pieceBanqueDetailsList;
  @JoinColumn(name = "ID_COMPTE_COMPTABLE", referencedColumnName = "ID")
  @OneToOne(fetch = FetchType.LAZY)
  private CompteComptable compteComptable;
  @JoinColumn(name = "CODE_BANQUE", referencedColumnName = "CODE_BANQUE")
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private BanqueCpta banqueCpta;


  public BanqueContrepartie() {
  }

  public BanqueContrepartie(Integer id, String codeMonnaie, CompteComptable compteComptable,
      BanqueCpta banqueCpta) {
    this.id = id;
    this.codeMonnaie = codeMonnaie;
    this.compteComptable = compteComptable;
    this.banqueCpta = banqueCpta;
  }

  public BanqueContrepartie(Integer id, String codeMonnaie, CompteComptable compteComptable,
      BanqueCpta banqueCpta, boolean isCib, boolean isCc) {
    this.id = id;
    this.codeMonnaie = codeMonnaie;
    this.compteComptable = compteComptable;
    this.banqueCpta = banqueCpta;
    this.isCib = isCib;
    this.isCc = isCc;
  }

  public BanqueContrepartie(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CompteComptable getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(CompteComptable compteComptable) {
    this.compteComptable = compteComptable;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public List<PieceBanqueDetails> getPieceBanqueDetailsList() {
    return pieceBanqueDetailsList;
  }

  public void setPieceBanqueDetailsList(List<PieceBanqueDetails> pieceBanqueDetailsList) {
    this.pieceBanqueDetailsList = pieceBanqueDetailsList;
  }

  public BanqueCpta getBanqueCpta() {
    return banqueCpta;
  }

  public void setBanqueCpta(BanqueCpta banqueCpta) {
    this.banqueCpta = banqueCpta;
  }

  public boolean isIsCib() {
    return isCib;
  }

  public void setIsCib(boolean isCib) {
    this.isCib = isCib;
  }

  public boolean isIsCc() {
    return isCc;
  }

  public void setIsCc(boolean isCc) {
    this.isCc = isCc;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    BanqueContrepartie other = (BanqueContrepartie) object;
    if ((this.compteComptable.getCompteComptable() != null && !this.compteComptable
        .getCompteComptable().equals(other.getCompteComptable().getCompteComptable()))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.BanqueContrepartie[ id=" + id + " ]";
  }

}
