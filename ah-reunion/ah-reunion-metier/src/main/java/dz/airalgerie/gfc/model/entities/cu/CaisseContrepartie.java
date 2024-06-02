/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.entities.commun.CompteComptable;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "CAISSE_CONTREPARTIE")
@NamedQueries({
    @NamedQuery(name = "CaisseContrepartie.findAll", query = "SELECT c FROM CaisseContrepartie c"),
    @NamedQuery(name = "CaisseContrepartie.findById",
        query = "SELECT c FROM CaisseContrepartie c WHERE c.id = :id"),
    @NamedQuery(name = "CaisseContrepartie.findByTypePaiment",
        query = "SELECT c FROM CaisseContrepartie c WHERE c.typePaiment = :typePaiment")})
public class CaisseContrepartie implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "TYPE_PAIMENT")
  private Character typePaiment;
  @JoinColumn(name = "CODE_CAISSE", referencedColumnName = "CODE_CAISSE")
  @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
  private Caisse codeCaisse;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrepartie", fetch = FetchType.LAZY)
  private List<PieceCaisseDetails> pieceCaisseDetailsList;
  @JoinColumn(name = "ID_COMPTE_COMPTABLE", referencedColumnName = "ID")
  @OneToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private CompteComptable compteComptable;

  public CaisseContrepartie() {
  }

  public CaisseContrepartie(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Character getTypePaiment() {
    return typePaiment;
  }

  public void setTypePaiment(Character typePaiment) {
    this.typePaiment = typePaiment;
  }

  public Caisse getCodeCaisse() {
    return codeCaisse;
  }

  public void setCodeCaisse(Caisse codeCaisse) {
    this.codeCaisse = codeCaisse;
  }

  public List<PieceCaisseDetails> getPieceCaisseDetailsList() {
    return pieceCaisseDetailsList;
  }

  public void setPieceCaisseDetailsList(List<PieceCaisseDetails> pieceCaisseDetailsList) {
    this.pieceCaisseDetailsList = pieceCaisseDetailsList;
  }

  public CompteComptable getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(CompteComptable compteComptable) {
    this.compteComptable = compteComptable;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if(object instanceof CaisseContrepartie){
        return (((CaisseContrepartie) object).getCompteComptable().getCompteComptable().equals(this.getCompteComptable().getCompteComptable()) && Objects.equals(((CaisseContrepartie) object).getCodeCaisse().getCodeCaisse(), this.getCodeCaisse().getCodeCaisse()));
    }
    return false;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.CaisseContrepartie[ id=" + id + " ]";
  }

}
