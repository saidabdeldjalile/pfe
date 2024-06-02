/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.dto.vol;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 */
public class PlanningNettoyageReportDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  protected Logger log;

  private Integer id;
  private String reg;
  private String libelle;
  private String typeCode;
  private String typeLibelle;
  private LocalDateTime dateDebut;
  private LocalDateTime dateFin;
  private Integer statut;
  private LocalDateTime dateDebutPre;
  private LocalDateTime dateFinPre;
  private Integer nbChangements;

  public PlanningNettoyageReportDTO() {
  }

  public PlanningNettoyageReportDTO(Integer id) {
    this.id = id;
  }

  public PlanningNettoyageReportDTO(Integer id, String reg, String libelle, String typeCode,
      String typeLibelle, LocalDateTime dateDebut, LocalDateTime dateFin, Integer statut,
      LocalDateTime dateDebutPre, LocalDateTime dateFinPre, Integer nbChangements) {
    this.id = id;
    this.reg = reg;
    this.libelle = libelle;
    this.typeCode = typeCode;
    this.typeLibelle = typeLibelle;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.statut = statut;
    this.dateDebutPre = dateDebutPre;
    this.dateFinPre = dateFinPre;
    this.nbChangements = nbChangements;
  }

  public Logger getLog() {
    return log;
  }

  public void setLog(Logger log) {
    this.log = log;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getTypeLibelle() {
    return typeLibelle;
  }

  public void setTypeLibelle(String typeLibelle) {
    this.typeLibelle = typeLibelle;
  }

  public LocalDateTime getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(LocalDateTime dateDebut) {
    this.dateDebut = dateDebut;
  }

  public LocalDateTime getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDateTime dateFin) {
    this.dateFin = dateFin;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public LocalDateTime getDateDebutPre() {
    return dateDebutPre;
  }

  public void setDateDebutPre(LocalDateTime dateDebutPre) {
    this.dateDebutPre = dateDebutPre;
  }

  public LocalDateTime getDateFinPre() {
    return dateFinPre;
  }

  public void setDateFinPre(LocalDateTime dateFinPre) {
    this.dateFinPre = dateFinPre;
  }

  public Integer getNbChangements() {
    return nbChangements;
  }

  public void setNbChangements(Integer nbChangements) {
    this.nbChangements = nbChangements;
  }

}
