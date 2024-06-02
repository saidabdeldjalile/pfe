/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.dto.carriere;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Diaf
 */
public class Profil {

  private Integer matricule;
  private Date dateNaiss;
  private String lieuNaiss;
  private String paysNaiss;
  private String paysNaissCode;
  private String nom;
  private String prenom;
  private String NomDeJeuneFille;
  private String nationalite;
  private String sexe;
  private String sexeCode;
  private String sitFam;
  private String sitFamCode;
  private String tel;
  private String mobile;
  private String fax;
  private String quatechifres;
  private String ligneIp;
  private String email;
  private String adresse;
  private String codeNationalite;
  private String codeLieuNaiss;
  private String codePostal;
  private List<String> updatedFields;

  private boolean infosStatus = false;
  private boolean contactStatus = false;
  private Boolean formationStatus = false;

  public String getPaysNaiss() {
    return paysNaiss;
  }

  public void setPaysNaiss(String paysNaiss) {
    this.paysNaiss = paysNaiss;
  }

  public String getPaysNaissCode() {
    return paysNaissCode;
  }

  public void setPaysNaissCode(String paysNaissCode) {
    this.paysNaissCode = paysNaissCode;
  }

  public String getNomDeJeuneFille() {
    return NomDeJeuneFille;
  }

  public void setNomDeJeuneFille(String NomDeJeuneFille) {
    this.NomDeJeuneFille = NomDeJeuneFille;
  }

  public List<String> getUpdatedFields() {
    return updatedFields;
  }

  public void setUpdatedFields(List<String> updatedFields) {
    this.updatedFields = updatedFields;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSexeCode() {
    return sexeCode;
  }

  public void setSexeCode(String sexeCode) {
    this.sexeCode = sexeCode;
  }

  public String getSitFam() {
    return sitFam;
  }

  public void setSitFam(String sitFam) {
    this.sitFam = sitFam;
  }

  public String getSitFamCode() {
    return sitFamCode;
  }

  public void setSitFamCode(String sitFamCode) {
    this.sitFamCode = sitFamCode;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getCodeLieuNaiss() {
    return codeLieuNaiss;
  }

  public void setCodeLieuNaiss(String codeLieuNaiss) {
    this.codeLieuNaiss = codeLieuNaiss;
  }

  public String getCodeNationalite() {
    return codeNationalite;
  }

  public void setCodeNationalite(String codeNationalite) {
    this.codeNationalite = codeNationalite;
  }

  public boolean isInfosStatus() {
    return infosStatus;
  }

  public void setInfosStatus(boolean infosStatus) {
    this.infosStatus = infosStatus;
  }

  public boolean isContactStatus() {
    return contactStatus;
  }

  public void setContactStatus(boolean contactStatus) {
    this.contactStatus = contactStatus;
  }

  public Date getDateNaiss() {
    return dateNaiss;
  }

  public void setDateNaiss(Date dateNaiss) {
    this.dateNaiss = dateNaiss;
  }

  public String getLieuNaiss() {
    return lieuNaiss;
  }

  public void setLieuNaiss(String lieuNaiss) {
    this.lieuNaiss = lieuNaiss;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNationalite() {
    return nationalite;
  }

  public void setNationalite(String nationalite) {
    this.nationalite = nationalite;
  }

  public String getSexe() {
    return sexe;
  }

  public void setSexe(String sexe) {
    this.sexe = sexe;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getQuatechifres() {
    return quatechifres;
  }

  public void setQuatechifres(String quatechifres) {
    this.quatechifres = quatechifres;
  }

  public String getLigneIp() {
    return ligneIp;
  }

  public void setLigneIp(String ligneIp) {
    this.ligneIp = ligneIp;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }

  public Boolean getFormationStatus() {
    return formationStatus;
  }

  public void setFormationStatus(Boolean formationStatus) {
    this.formationStatus = formationStatus;
  }

  public Profil() {}

}
