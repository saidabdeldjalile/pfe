/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.cu;

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

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "CAISSE_BANQUE")
@NamedQueries({@NamedQuery(name = "CaisseBanque.findAll", query = "SELECT c FROM CaisseBanque c"),
    @NamedQuery(name = "CaisseBanque.findById",
        query = "SELECT c FROM CaisseBanque c WHERE c.id = :id")})
public class CaisseBanque implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @JoinColumn(name = "CODE_CAISSE", referencedColumnName = "CODE_CAISSE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Caisse codeCaisse;
  @JoinColumn(name = "CODE_BANQUE", referencedColumnName = "CODE_BANQUE")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private BanqueCpta codeBanque;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "caisseBanque", fetch = FetchType.LAZY)
  private List<PieceBanque> pieceBanqueList;
  @Basic(optional = false)
  @Column(name = "IS_CAPTURE")
  private boolean isCapture;

  public CaisseBanque() {
  }

  public CaisseBanque(Integer id, Caisse codeCaisse) {
    this.id = id;
    this.codeCaisse = codeCaisse;
  }

  public CaisseBanque(Integer id, Caisse codeCaisse, BanqueCpta codeBanque) {
    this.id = id;
    this.codeCaisse = codeCaisse;
    this.codeBanque = codeBanque;
  }


  public CaisseBanque(Integer id, Caisse codeCaisse, BanqueCpta codeBanque, boolean isCapture) {
    this.id = id;
    this.codeCaisse = codeCaisse;
    this.codeBanque = codeBanque;
    this.isCapture = isCapture;
  }

  public CaisseBanque(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Caisse getCodeCaisse() {
    return codeCaisse;
  }

  public void setCodeCaisse(Caisse codeCaisse) {
    this.codeCaisse = codeCaisse;
  }

  public BanqueCpta getCodeBanque() {
    return codeBanque;
  }

  public void setCodeBanque(BanqueCpta codeBanque) {
    this.codeBanque = codeBanque;
  }

  public List<PieceBanque> getPieceBanqueList() {
    return pieceBanqueList;
  }

  public void setPieceBanqueList(List<PieceBanque> pieceBanqueList) {
    this.pieceBanqueList = pieceBanqueList;
  }

  public boolean isIsCapture() {
    return isCapture;
  }

  public void setIsCapture(boolean isCapture) {
    this.isCapture = isCapture;
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
    if (!(object instanceof CaisseBanque)) {
      return false;
    }
    CaisseBanque other = (CaisseBanque) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.CaisseBanque[ id=" + id + " ]";
  }

}
