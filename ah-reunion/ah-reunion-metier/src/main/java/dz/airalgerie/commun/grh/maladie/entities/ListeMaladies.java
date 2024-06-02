/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author user
 */
public class ListeMaladies {

  private int matricule;
  private Date dateDebMld;
  private Date dateFinMld;
  private Date dateSaisie;
  private Date dateRecCm;
  private Date dateCerMed;
  private Integer nbrJourMld;
  private BigDecimal montantIj;
  private Character ats;
  private String etat;
  private String obsMld;
  private String obsAts;
  private String nom;
  private String njfille;
  private String prenoms;
  private String numSs;
  private String name;
  private String libEtat;

  public ListeMaladies(int matricule, Date dateDebMld, Date dateFinMld, Date dateSaisie,
      Date dateRecCm, Date dateCerMed, Integer nbrJourMld, BigDecimal montantIj, Character ats,
      String etat, String obsMld, String obsAts, String nom, String njfille, String prenoms,
      String numSs, String name, String libEtat) {
    this.matricule = matricule;
    this.dateDebMld = dateDebMld;
    this.dateFinMld = dateFinMld;
    this.dateSaisie = dateSaisie;
    this.dateRecCm = dateRecCm;
    this.dateCerMed = dateCerMed;
    this.nbrJourMld = nbrJourMld;
    this.montantIj = montantIj;
    this.ats = ats;
    this.etat = etat;
    this.obsMld = obsMld;
    this.obsAts = obsAts;
    this.nom = nom;
    this.njfille = njfille;
    this.prenoms = prenoms;
    this.numSs = numSs;
    this.name = name;
    this.libEtat = libEtat;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDateDebMld() {
    return dateDebMld;
  }

  public void setDateDebMld(Date dateDebMld) {
    this.dateDebMld = dateDebMld;
  }

  public Date getDateFinMld() {
    return dateFinMld;
  }

  public void setDateFinMld(Date dateFinMld) {
    this.dateFinMld = dateFinMld;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public Date getDateRecCm() {
    return dateRecCm;
  }

  public void setDateRecCm(Date dateRecCm) {
    this.dateRecCm = dateRecCm;
  }

  public Date getDateCerMed() {
    return dateCerMed;
  }

  public void setDateCerMed(Date dateCerMed) {
    this.dateCerMed = dateCerMed;
  }

  public Integer getNbrJourMld() {
    return nbrJourMld;
  }

  public void setNbrJourMld(Integer nbrJourMld) {
    this.nbrJourMld = nbrJourMld;
  }

  public BigDecimal getMontantIj() {
    return montantIj;
  }

  public void setMontantIj(BigDecimal montantIj) {
    this.montantIj = montantIj;
  }

  public Character getAts() {
    return ats;
  }

  public void setAts(Character ats) {
    this.ats = ats;
  }

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

  public String getObsMld() {
    return obsMld;
  }

  public void setObsMld(String obsMld) {
    this.obsMld = obsMld;
  }

  public String getObsAts() {
    return obsAts;
  }

  public void setObsAts(String obsAts) {
    this.obsAts = obsAts;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getNjfille() {
    return njfille;
  }

  public void setNjfille(String njfille) {
    this.njfille = njfille;
  }

  public String getPrenoms() {
    return prenoms;
  }

  public void setPrenoms(String prenoms) {
    this.prenoms = prenoms;
  }

  public String getNumSs() {
    return numSs;
  }

  public void setNumSs(String numSs) {
    this.numSs = numSs;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLibEtat() {
    return libEtat;
  }

  public void setLibEtat(String libEtat) {
    this.libEtat = libEtat;
  }

}
