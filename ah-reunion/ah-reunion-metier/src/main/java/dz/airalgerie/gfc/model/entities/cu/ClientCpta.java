/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.entities.commun.CompteComptable;
import dz.airalgerie.gfc.model.entities.fac.FactureFac;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "CLIENT")
public class ClientCpta implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_CLIENT")
  private Integer codeClient;
  @Column(name = "LIBELLE")
  private String libelle;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "TYPE_CLIENT")
  private String typeClient;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "IMPUTATION")
  private String imputation;
  @Size(max = 30)
  @Column(name = "TELEPHONE")
  private String telephone;
  @Size(max = 30)
  @Column(name = "FAX")
  private String fax;
  @Size(max = 150)
  @Column(name = "ADRESSE")
  private String adresse;
  @Size(max = 100)
  @Column(name = "EMAIL")
  private String email;
  @Size(max = 30)
  @Column(name = "RC")
  private String rc;
  @Size(max = 50)
  @Column(name = "NIS")
  private String nis;
  @Size(max = 50)
  @Column(name = "NIF")
  private String nif;
  @Column(name = "IS_IA")
  private boolean isIa;
  @Column(name = "IS_EXONERE")
  private boolean isExonere;
  @Size(max = 255)
  @Column(name = "UNITE_BANQUE_LIBELLE")
  private String uniteBanqueLibelle;
  @Size(max = 255)
  @Column(name = "UNITE_BANQUE_ADRESSE")
  private String uniteBanqueAdresse;
  @Size(max = 50)
  @Column(name = "UNITE_BANQUE_NUM_COMPTE")
  private String uniteBanqueNumCompte;
  @JoinColumn(name = "ID_ORGANISME", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private Organisme organisme;
  @JoinColumn(name = "ID_COMPTE_COMPTABLE", referencedColumnName = "ID")
  @OneToOne(fetch = FetchType.LAZY)
  private CompteComptable compteComptable;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
  private List<FactureFac> facturesList;

  public ClientCpta() {
    this.isIa = false;
  }

  public ClientCpta(Integer codeClient) {
    this();
    this.codeClient = codeClient;
  }

  public ClientCpta(Integer codeClient, String typeClient, String imputation) {
    this.codeClient = codeClient;
    this.typeClient = typeClient;
    this.imputation = imputation;
  }

  public ClientCpta(Integer codeClient, String libelle, String typeClient, String imputation,
      Organisme organisme, CompteComptable compteComptable) {
    this.codeClient = codeClient;
    this.libelle = libelle;
    this.typeClient = typeClient;
    this.imputation = imputation;
    this.organisme = organisme;
    this.compteComptable = compteComptable;
  }

  public ClientCpta(Integer codeClient, String libelle, String typeClient, String imputation,
      Organisme organisme, CompteComptable compteComptable, String telephone, String fax,
      String adresse, String email, String rc, String nis, String nif, boolean isIa,
      boolean isExonere, String uniteBanqueLibelle, String uniteBanqueAdresse,
      String uniteBanqueNumCompte) {
    this.codeClient = codeClient;
    this.libelle = libelle;
    this.typeClient = typeClient;
    this.imputation = imputation;
    this.organisme = organisme;
    this.compteComptable = compteComptable;
    this.telephone = telephone;
    this.fax = fax;
    this.adresse = adresse;
    this.email = email;
    this.rc = rc;
    this.nis = nis;
    this.nif = nif;
    this.isIa = isIa;
    this.isExonere = isExonere;
    this.uniteBanqueLibelle = uniteBanqueLibelle;
    this.uniteBanqueAdresse = uniteBanqueAdresse;
    this.uniteBanqueNumCompte = uniteBanqueNumCompte;
  }

  public Integer getCodeClient() {
    return codeClient;
  }

  public void setCodeClient(Integer codeClient) {
    this.codeClient = codeClient;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getTypeClient() {
    return typeClient;
  }

  public void setTypeClient(String typeClient) {
    this.typeClient = typeClient;
  }

  public String getImputation() {
    return imputation;
  }

  public void setImputation(String imputation) {
    this.imputation = imputation;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getRc() {
    return rc;
  }

  public void setRc(String rc) {
    this.rc = rc;
  }

  public String getNis() {
    return nis;
  }

  public void setNis(String nis) {
    this.nis = nis;
  }

  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isIsIa() {
    return isIa;
  }

  public void setIsIa(boolean isIa) {
    this.isIa = isIa;
  }

  public boolean isIsExonere() {
    return isExonere;
  }

  public void setIsExonere(boolean isExonere) {
    this.isExonere = isExonere;
  }

  public String getUniteBanqueLibelle() {
    return uniteBanqueLibelle;
  }

  public void setUniteBanqueLibelle(String uniteBanqueLibelle) {
    this.uniteBanqueLibelle = uniteBanqueLibelle;
  }

  public String getUniteBanqueAdresse() {
    return uniteBanqueAdresse;
  }

  public void setUniteBanqueAdresse(String uniteBanqueAdresse) {
    this.uniteBanqueAdresse = uniteBanqueAdresse;
  }

  public String getUniteBanqueNumCompte() {
    return uniteBanqueNumCompte;
  }

  public void setUniteBanqueNumCompte(String uniteBanqueNumCompte) {
    this.uniteBanqueNumCompte = uniteBanqueNumCompte;
  }

  public Organisme getOrganisme() {
    return organisme;
  }

  public void setOrganisme(Organisme organisme) {
    this.organisme = organisme;
  }

  public CompteComptable getCompteComptable() {
    return compteComptable;
  }

  public void setCompteComptable(CompteComptable compteComptable) {
    this.compteComptable = compteComptable;
  }

  public List<FactureFac> getFacturesList() {
    return facturesList;
  }

  public void setFacturesList(List<FactureFac> facturesList) {
    this.facturesList = facturesList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeClient != null ? codeClient.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ClientCpta)) {
      return false;
    }
    ClientCpta other = (ClientCpta) object;
    if ((this.codeClient == null && other.codeClient != null)
        || (this.codeClient != null && !this.codeClient.equals(other.codeClient))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.Client[ codeClient=" + codeClient + " ]";
  }

}
