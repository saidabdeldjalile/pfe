/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cu;

import dz.airalgerie.gfc.model.entities.commun.CompteComptable;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "FOURNISSEUR")
public class FournisseurCpta implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_FOURNISSEUR")
  private Integer codeFournisseur;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "TYPE_FOURNISSEUR")
  private String typeFournisseur;
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

  public FournisseurCpta() {
  }

  public FournisseurCpta(Integer codeFournisseur) {
    this.codeFournisseur = codeFournisseur;
  }

  public FournisseurCpta(Integer codeFournisseur, String libelle, Organisme organisme,
      CompteComptable compteComptable) {
    this.codeFournisseur = codeFournisseur;
    this.libelle = libelle;
    this.organisme = organisme;
    this.compteComptable = compteComptable;
  }

  public FournisseurCpta(Integer codeFournisseur, String libelle, String typeFournisseur,
      String imputation, String telephone, String fax, String adresse, String email, String rc,
      String nis, String nif, String uniteBanqueLibelle, String uniteBanqueAdresse,
      String uniteBanqueNumCompte, Organisme organisme, CompteComptable compteComptable) {
    this.codeFournisseur = codeFournisseur;
    this.libelle = libelle;
    this.typeFournisseur = typeFournisseur;
    this.imputation = imputation;
    this.telephone = telephone;
    this.fax = fax;
    this.adresse = adresse;
    this.email = email;
    this.rc = rc;
    this.nis = nis;
    this.nif = nif;
    this.uniteBanqueLibelle = uniteBanqueLibelle;
    this.uniteBanqueAdresse = uniteBanqueAdresse;
    this.uniteBanqueNumCompte = uniteBanqueNumCompte;
    this.organisme = organisme;
    this.compteComptable = compteComptable;
  }

  public FournisseurCpta(FournisseurCpta oldFournisseurCpta) {
    this.codeFournisseur = oldFournisseurCpta.codeFournisseur;
    this.libelle = oldFournisseurCpta.libelle;
    this.organisme = oldFournisseurCpta.organisme;
    this.compteComptable = oldFournisseurCpta.compteComptable;
  }

  public Integer getCodeFournisseur() {
    return codeFournisseur;
  }

  public void setCodeFournisseur(Integer codeFournisseur) {
    this.codeFournisseur = codeFournisseur;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getTypeFournisseur() {
    return typeFournisseur;
  }

  public void setTypeFournisseur(String typeFournisseur) {
    this.typeFournisseur = typeFournisseur;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeFournisseur != null ? codeFournisseur.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FournisseurCpta)) {
      return false;
    }
    FournisseurCpta other = (FournisseurCpta) object;
    if ((this.codeFournisseur == null && other.codeFournisseur != null)
        || (this.codeFournisseur != null && !this.codeFournisseur.equals(other.codeFournisseur))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.Fournisseur[ codeFournisseur=" + codeFournisseur
        + " ]";
  }

}
