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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "CAISSE")
@NamedQueries({@NamedQuery(name = "Caisse.findAll", query = "SELECT c FROM Caisse c"),
    @NamedQuery(name = "Caisse.findByCodeCaisse",
        query = "SELECT c FROM Caisse c WHERE c.codeCaisse = :codeCaisse"),
    @NamedQuery(name = "Caisse.findByCodeMonnaie",
        query = "SELECT c FROM Caisse c WHERE c.codeMonnaie = :codeMonnaie")})
public class Caisse implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_CAISSE")
  private Integer codeCaisse;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_MONNAIE")
  private String codeMonnaie;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeCaisse", fetch = FetchType.LAZY)
  private List<PieceCaisse> pieceCaisseList;
  @ManyToMany
  @JoinTable(schema = "CU", name = "CAISSE_BANQUE", joinColumns = @JoinColumn(name = "CODE_CAISSE"),
      inverseJoinColumns = @JoinColumn(name = "CODE_BANQUE"))
  private List<BanqueCpta> caisseBanqueList;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "codeCaisse",
      fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<CaisseContrepartie> caisseContrepartieList;
  @JoinColumn(name = "ID_STRUCTURE", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private StructureCpta structure;
  @Column(name = "IS_CAPTURE")
  private boolean isCapture;

  public Caisse() {
  }

  public Caisse(Integer codeCaisse, String codeMonnaie, StructureCpta structure) {
    this.codeCaisse = codeCaisse;
    this.codeMonnaie = codeMonnaie;
    this.structure = structure;
  }

  public Caisse(Integer codeCaisse, String codeMonnaie, StructureCpta structure,
      boolean isCapture) {
    this.codeCaisse = codeCaisse;
    this.codeMonnaie = codeMonnaie;
    this.structure = structure;
    this.isCapture = isCapture;
  }

  public Caisse(Integer codeCaisse) {
    this.codeCaisse = codeCaisse;
  }

  public Caisse(Integer codeCaisse, String codeMonnaie) {
    this.codeCaisse = codeCaisse;
    this.codeMonnaie = codeMonnaie;
  }

  public Integer getCodeCaisse() {
    return codeCaisse;
  }

  public void setCodeCaisse(Integer codeCaisse) {
    this.codeCaisse = codeCaisse;
  }

  public String getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(String codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public List<PieceCaisse> getPieceCaisseList() {
    return pieceCaisseList;
  }

  public void setPieceCaisseList(List<PieceCaisse> pieceCaisseList) {
    this.pieceCaisseList = pieceCaisseList;
  }

  public List<BanqueCpta> getCaisseBanqueList() {
    return caisseBanqueList;
  }

  public void setCaisseBanqueList(List<BanqueCpta> caisseBanqueList) {
    this.caisseBanqueList = caisseBanqueList;
  }

  public List<CaisseContrepartie> getCaisseContrepartieList() {
    return caisseContrepartieList;
  }

  public void setCaisseContrepartieList(List<CaisseContrepartie> caisseContrepartieList) {
    this.caisseContrepartieList = caisseContrepartieList;
  }

  public StructureCpta getStructure() {
    return structure;
  }

  public void setStructure(StructureCpta structure) {
    this.structure = structure;
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
    hash += (codeCaisse != null ? codeCaisse.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Caisse)) {
      return false;
    }
    Caisse other = (Caisse) object;
    if ((this.codeCaisse == null && other.codeCaisse != null)
        || (this.codeCaisse != null && !this.codeCaisse.equals(other.codeCaisse))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.Caisse[ codeCaisse=" + codeCaisse + " ]";
  }

}
