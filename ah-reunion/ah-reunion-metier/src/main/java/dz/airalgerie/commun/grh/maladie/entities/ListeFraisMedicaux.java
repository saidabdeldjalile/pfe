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
public class ListeFraisMedicaux {
  private int id;
  private int matricule;
  private Date dateFM;
  private String codeBenef;
  private BigDecimal montantFM;
  private char codeActe;
  private Date dateSaisie;
  private Date dateRecCm;
  private String observation;
  private String nom;
  private String njfille;
  private String prenoms;
  private String numSs;
  private String name;

  public ListeFraisMedicaux(int id, int matricule, Date dateFM, String codeBenef,
      BigDecimal montantFM, char codeActe, Date dateSaisie, Date dateRecCm, String observation,
      String nom, String njfille, String prenoms, String numSs, String name) {
    this.id = id;
    this.matricule = matricule;
    this.dateFM = dateFM;
    this.codeBenef = codeBenef;
    this.montantFM = montantFM;
    this.codeActe = codeActe;
    this.dateSaisie = dateSaisie;
    this.dateRecCm = dateRecCm;
    this.observation = observation;
    this.nom = nom;
    this.njfille = njfille;
    this.prenoms = prenoms;
    this.numSs = numSs;
    this.name = name;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDateFM() {
    return dateFM;
  }

  public void setDateFM(Date dateFM) {
    this.dateFM = dateFM;
  }

  public String getCodeBenef() {
    return codeBenef;
  }

  public void setCodeBenef(String codeBenef) {
    this.codeBenef = codeBenef;
  }

  public BigDecimal getMontantFM() {
    return montantFM;
  }

  public void setMontantFM(BigDecimal montantFM) {
    this.montantFM = montantFM;
  }

  public char getCodeActe() {
    return codeActe;
  }

  public void setCodeActe(char codeActe) {
    this.codeActe = codeActe;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

}
