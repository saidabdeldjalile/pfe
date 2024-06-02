/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.dto.safety;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 */
public class CsrNotifsDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Integer matricule;
  private String nom;
  private String fonction;
  private LocalDateTime eventDate;
  private String aircraft;
  private String flt;
  private String dep;
  private String arr;
  private Integer nbComments;
  private Integer piloteMatricule;
  private String piloteNom;
  private boolean isRead;
  private LocalDateTime csrDate;
  private Integer nbNewComments;
  private Integer priorite;
  private Integer statut;
  private Integer traiteParMatricule;
  private String traiteParNom;

  public CsrNotifsDto() {
  }

  public CsrNotifsDto(Integer id, Integer matricule, String nom, String fonction,
      LocalDateTime eventDate, String aircraft, String flt, String dep, String arr,
      Integer nbComments, Integer piloteMatricule, String piloteNom, boolean isRead,
      LocalDateTime csrDate, Integer nbNewComments, Integer priorite, Integer statut,
      Integer traiteParMatricule, String traiteParNom) {
    this.id = id;
    this.matricule = matricule;
    this.nom = nom;
    this.fonction = fonction;
    this.eventDate = eventDate;
    this.aircraft = aircraft;
    this.flt = flt;
    this.dep = dep;
    this.arr = arr;
    this.nbComments = nbComments;
    this.piloteMatricule = piloteMatricule;
    this.piloteNom = piloteNom;
    this.isRead = isRead;
    this.csrDate = csrDate;
    this.nbNewComments = nbNewComments;
    this.priorite = priorite;
    this.statut = statut;
    this.traiteParMatricule = traiteParMatricule;
    this.traiteParNom = traiteParNom;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getFonction() {
    return fonction;
  }

  public void setFonction(String fonction) {
    this.fonction = fonction;
  }

  public LocalDateTime getEventDate() {
    return eventDate;
  }

  public void setEventDate(LocalDateTime eventDate) {
    this.eventDate = eventDate;
  }

  public String getAircraft() {
    return aircraft;
  }

  public void setAircraft(String aircraft) {
    this.aircraft = aircraft;
  }

  public String getFlt() {
    return flt;
  }

  public void setFlt(String flt) {
    this.flt = flt;
  }

  public String getDep() {
    return dep;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }

  public String getArr() {
    return arr;
  }

  public void setArr(String arr) {
    this.arr = arr;
  }

  public Integer getNbComments() {
    return nbComments;
  }

  public void setNbComments(Integer nbComments) {
    this.nbComments = nbComments;
  }

  public Integer getPiloteMatricule() {
    return piloteMatricule;
  }

  public void setPiloteMatricule(Integer piloteMatricule) {
    this.piloteMatricule = piloteMatricule;
  }

  public String getPiloteNom() {
    return piloteNom;
  }

  public void setPiloteNom(String piloteNom) {
    this.piloteNom = piloteNom;
  }

  public boolean isIsRead() {
    return isRead;
  }

  public void setIsRead(boolean isRead) {
    this.isRead = isRead;
  }

  public LocalDateTime getCsrDate() {
    return csrDate;
  }

  public void setCsrDate(LocalDateTime csrDate) {
    this.csrDate = csrDate;
  }

  public Integer getNbNewComments() {
    return nbNewComments;
  }

  public void setNbNewComments(Integer nbNewComments) {
    this.nbNewComments = nbNewComments;
  }

  public Integer getPriorite() {
    return priorite;
  }

  public void setPriorite(Integer priorite) {
    this.priorite = priorite;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Integer getTraiteParMatricule() {
    return traiteParMatricule;
  }

  public void setTraiteParMatricule(Integer traiteParMatricule) {
    this.traiteParMatricule = traiteParMatricule;
  }

  public String getTraiteParNom() {
    return traiteParNom;
  }

  public void setTraiteParNom(String traiteParNom) {
    this.traiteParNom = traiteParNom;
  }

}
