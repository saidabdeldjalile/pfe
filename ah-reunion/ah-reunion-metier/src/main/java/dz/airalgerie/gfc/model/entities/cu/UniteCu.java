/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.gfc.model.entities.cu;

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

/**
 *
 */
@Entity
@Table(name = "UNITE_CU", schema = "CU")
@NamedQueries({@NamedQuery(name = "UniteCu.findAll", query = "SELECT u FROM UniteCu u")})
public class UniteCu implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_UNITE")
  private String codeUnite;
  @Size(max = 255)
  @Column(name = "LIBELLE")
  private String libelle;
  @Size(max = 6)
  @Column(name = "CLIENT_CC")
  private String clientCc;
  @Size(max = 30)
  @Column(name = "TELEPHONE")
  private String telephone;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax
  // format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using
  // this annotation to enforce field validation
  @Size(max = 30)
  @Column(name = "FAX")
  private String fax;
  @Size(max = 255)
  @Column(name = "ADRESSE")
  private String adresse;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
  // message="Invalid email")//if the field contains email address consider using this annotation to
  // enforce field validation
  @Size(max = 100)
  @Column(name = "EMAIL")
  private String email;
  @Column(name = "IS_FAC_CENTRAL")
  private boolean isFacCentral;
  @Size(max = 255)
  @Column(name = "BANQUE_LIBELLE")
  private String banqueLibelle;
  @Size(max = 255)
  @Column(name = "BANQUE_ADRESSE")
  private String banqueAdresse;
  @Size(max = 50)
  @Column(name = "BANQUE_NUM_COMPTE")
  private String banqueNumCompte;
  @Size(max = 50)
  @Column(name = "GRP_CHAP_FAC")
  private String grpChapFacturation;
  @Size(max = 255)
  @Column(name = "LIBELLE_FAC")
  private String libelleFac;
  @Size(max = 30)
  @Column(name = "RC")
  private String rc;
  @Size(max = 50)
  @Column(name = "NIS")
  private String nis;
  @Size(max = 50)
  @Column(name = "NIF")
  private String nif;
  @Size(max = 50)
  @Column(name = "NAI")
  private String nai;
  @Size(max = 50)
  @Column(name = "WILAYA")
  private String wilaya;

  public UniteCu() {
  }

  public UniteCu(String codeUnite) {
    this.codeUnite = codeUnite;
  }

  public String getCodeUnite() {
    return codeUnite;
  }

  public void setCodeUnite(String codeUnite) {
    this.codeUnite = codeUnite;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getClientCc() {
    return clientCc;
  }

  public void setClientCc(String clientCc) {
    this.clientCc = clientCc;
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

  public boolean isIsFacCentral() {
    return isFacCentral;
  }

  public void setIsFacCentral(boolean isFacCentral) {
    this.isFacCentral = isFacCentral;
  }

  public String getBanqueLibelle() {
    return banqueLibelle;
  }

  public void setBanqueLibelle(String banqueLibelle) {
    this.banqueLibelle = banqueLibelle;
  }

  public String getBanqueAdresse() {
    return banqueAdresse;
  }

  public void setBanqueAdresse(String banqueAdresse) {
    this.banqueAdresse = banqueAdresse;
  }

  public String getBanqueNumCompte() {
    return banqueNumCompte;
  }

  public void setBanqueNumCompte(String banqueNumCompte) {
    this.banqueNumCompte = banqueNumCompte;
  }

  public String getGrpChapFacturation() {
    return grpChapFacturation;
  }

  public void setGrpChapFacturation(String grpChapFacturation) {
    this.grpChapFacturation = grpChapFacturation;
  }

  public String getLibelleFac() {
    return libelleFac;
  }

  public void setLibelleFac(String libelleFac) {
    this.libelleFac = libelleFac;
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

  public String getNai() {
    return nai;
  }

  public void setNai(String nai) {
    this.nai = nai;
  }

  public String getWilaya() {
    return wilaya;
  }

  public void setWilaya(String wilaya) {
    this.wilaya = wilaya;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeUnite != null ? codeUnite.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UniteCu)) {
      return false;
    }
    UniteCu other = (UniteCu) object;
    if ((this.codeUnite == null && other.codeUnite != null)
        || (this.codeUnite != null && !this.codeUnite.equals(other.codeUnite))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.UniteCu[ codeUnite=" + codeUnite + " ]";
  }

}
