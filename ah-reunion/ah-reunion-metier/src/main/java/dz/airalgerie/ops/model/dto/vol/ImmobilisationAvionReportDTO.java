/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.dto.vol;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.inject.Inject;
import javax.persistence.Transient;
import org.slf4j.Logger;

/**
 *
 */
public class ImmobilisationAvionReportDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  protected Logger log;

  private String reg;
  private Integer idPrevious;
  private String libellePrevious;
  private String typePrevious;
  private String libelleTypePrevious;
  private LocalDateTime dateDebutPrevious;
  private LocalDateTime dateFinPrevious;
  private Integer statutPrevious;
  private LocalDateTime dateNextPrevu;
  private Integer nbJoursRestantPrevu;
  private Integer idImmo;
  private LocalDate dateImmo;
  private Integer disponibiliteImmo;
  private LocalDateTime debutImmo;
  private LocalDateTime finImmo;
  private Integer idNext;
  private String libelleNext;
  private String typeNext;
  private String libelleTypeNext;
  private LocalDateTime dateDebutNext;
  private LocalDateTime dateFinNext;
  private String statutNext;
  @Transient
  private String readableDisponibilite;

  public ImmobilisationAvionReportDTO() {
  }

  public ImmobilisationAvionReportDTO(String reg, Integer idPrevious, String libellePrevious,
      String typePrevious, String libelleTypePrevious, LocalDateTime dateDebutPrevious,
      LocalDateTime dateFinPrevious, Integer statutPrevious, LocalDateTime dateNextPrevu,
      Integer nbJoursRestantPrevu, Integer idImmo, LocalDate dateImmo, Integer disponibiliteImmo,
      LocalDateTime debutImmo, LocalDateTime finImmo, Integer idNext, String libelleNext,
      String typeNext, String libelleTypeNext, LocalDateTime dateDebutNext,
      LocalDateTime dateFinNext, String statutNext) {
    this.reg = reg;
    this.idPrevious = idPrevious;
    this.libellePrevious = libellePrevious;
    this.typePrevious = typePrevious;
    this.libelleTypePrevious = libelleTypePrevious;
    this.dateDebutPrevious = dateDebutPrevious;
    this.dateFinPrevious = dateFinPrevious;
    this.statutPrevious = statutPrevious;
    this.dateNextPrevu = dateNextPrevu;
    this.nbJoursRestantPrevu = nbJoursRestantPrevu;
    this.idImmo = idImmo;
    this.dateImmo = dateImmo;
    this.disponibiliteImmo = disponibiliteImmo;
    this.debutImmo = debutImmo;
    this.finImmo = finImmo;
    this.idNext = idNext;
    this.libelleNext = libelleNext;
    this.typeNext = typeNext;
    this.libelleTypeNext = libelleTypeNext;
    this.dateDebutNext = dateDebutNext;
    this.dateFinNext = dateFinNext;
    this.statutNext = statutNext;

    formatDiponibilite();
  }

  public ImmobilisationAvionReportDTO(String reg, Integer idPrevious, String libellePrevious,
      String typePrevious, String libelleTypePrevious, LocalDateTime dateDebutPrevious,
      LocalDateTime dateFinPrevious, Integer statutPrevious, LocalDateTime dateNextPrevu,
      Integer nbJoursRestantPrevu, Integer idNext, String libelleNext, String typeNext,
      String libelleTypeNext, LocalDateTime dateDebutNext, LocalDateTime dateFinNext,
      String statutNext) {
    this.reg = reg;
    this.idPrevious = idPrevious;
    this.libellePrevious = libellePrevious;
    this.typePrevious = typePrevious;
    this.libelleTypePrevious = libelleTypePrevious;
    this.dateDebutPrevious = dateDebutPrevious;
    this.dateFinPrevious = dateFinPrevious;
    this.statutPrevious = statutPrevious;
    this.dateNextPrevu = dateNextPrevu;
    this.nbJoursRestantPrevu = nbJoursRestantPrevu;
    this.idNext = idNext;
    this.libelleNext = libelleNext;
    this.typeNext = typeNext;
    this.libelleTypeNext = libelleTypeNext;
    this.dateDebutNext = dateDebutNext;
    this.dateFinNext = dateFinNext;
    this.statutNext = statutNext;
  }

  private void formatDiponibilite() {
    readableDisponibilite =
        String.format("%dh%02d", (disponibiliteImmo / 60), disponibiliteImmo % 60);
  }

  public Logger getLog() {
    return log;
  }

  public void setLog(Logger log) {
    this.log = log;
  }

  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }

  public Integer getIdPrevious() {
    return idPrevious;
  }

  public void setIdPrevious(Integer idPrevious) {
    this.idPrevious = idPrevious;
  }

  public String getLibellePrevious() {
    return libellePrevious;
  }

  public void setLibellePrevious(String libellePrevious) {
    this.libellePrevious = libellePrevious;
  }

  public String getTypePrevious() {
    return typePrevious;
  }

  public void setTypePrevious(String typePrevious) {
    this.typePrevious = typePrevious;
  }

  public String getLibelleTypePrevious() {
    return libelleTypePrevious;
  }

  public void setLibelleTypePrevious(String libelleTypePrevious) {
    this.libelleTypePrevious = libelleTypePrevious;
  }

  public LocalDateTime getDateDebutPrevious() {
    return dateDebutPrevious;
  }

  public void setDateDebutPrevious(LocalDateTime dateDebutPrevious) {
    this.dateDebutPrevious = dateDebutPrevious;
  }

  public LocalDateTime getDateFinPrevious() {
    return dateFinPrevious;
  }

  public void setDateFinPrevious(LocalDateTime dateFinPrevious) {
    this.dateFinPrevious = dateFinPrevious;
  }

  public Integer getStatutPrevious() {
    return statutPrevious;
  }

  public void setStatutPrevious(Integer statutPrevious) {
    this.statutPrevious = statutPrevious;
  }

  public LocalDateTime getDateNextPrevu() {
    return dateNextPrevu;
  }

  public void setDateNextPrevu(LocalDateTime dateNextPrevu) {
    this.dateNextPrevu = dateNextPrevu;
  }

  public Integer getNbJoursRestantPrevu() {
    return nbJoursRestantPrevu;
  }

  public void setNbJoursRestantPrevu(Integer nbJoursRestantPrevu) {
    this.nbJoursRestantPrevu = nbJoursRestantPrevu;
  }

  public Integer getIdImmo() {
    return idImmo;
  }

  public void setIdImmo(Integer idImmo) {
    this.idImmo = idImmo;
  }

  public LocalDate getDateImmo() {
    return dateImmo;
  }

  public void setDateImmo(LocalDate dateImmo) {
    this.dateImmo = dateImmo;
  }

  public Integer getDisponibiliteImmo() {
    return disponibiliteImmo;
  }

  public void setDisponibiliteImmo(Integer disponibiliteImmo) {
    this.disponibiliteImmo = disponibiliteImmo;
  }

  public LocalDateTime getDebutImmo() {
    return debutImmo;
  }

  public void setDebutImmo(LocalDateTime debutImmo) {
    this.debutImmo = debutImmo;
  }

  public LocalDateTime getFinImmo() {
    return finImmo;
  }

  public void setFinImmo(LocalDateTime finImmo) {
    this.finImmo = finImmo;
  }

  public Integer getIdNext() {
    return idNext;
  }

  public void setIdNext(Integer idNext) {
    this.idNext = idNext;
  }

  public String getLibelleNext() {
    return libelleNext;
  }

  public void setLibelleNext(String libelleNext) {
    this.libelleNext = libelleNext;
  }

  public String getTypeNext() {
    return typeNext;
  }

  public void setTypeNext(String typeNext) {
    this.typeNext = typeNext;
  }

  public String getLibelleTypeNext() {
    return libelleTypeNext;
  }

  public void setLibelleTypeNext(String libelleTypeNext) {
    this.libelleTypeNext = libelleTypeNext;
  }

  public LocalDateTime getDateDebutNext() {
    return dateDebutNext;
  }

  public void setDateDebutNext(LocalDateTime dateDebutNext) {
    this.dateDebutNext = dateDebutNext;
  }

  public LocalDateTime getDateFinNext() {
    return dateFinNext;
  }

  public void setDateFinNext(LocalDateTime dateFinNext) {
    this.dateFinNext = dateFinNext;
  }

  public String getStatutNext() {
    return statutNext;
  }

  public void setStatutNext(String statutNext) {
    this.statutNext = statutNext;
  }

  public String getReadableDisponibilite() {
    return readableDisponibilite;
  }

  public void setReadableDisponibilite(String readableDisponibilite) {
    this.readableDisponibilite = readableDisponibilite;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ImmobilisationAvionReportDTO{");
    sb.append("log=").append(log);
    sb.append(", reg=").append(reg);
    sb.append(", idPrevious=").append(idPrevious);
    sb.append(", libellePrevious=").append(libellePrevious);
    sb.append(", typePrevious=").append(typePrevious);
    sb.append(", libelleTypePrevious=").append(libelleTypePrevious);
    sb.append(", dateDebutPrevious=").append(dateDebutPrevious);
    sb.append(", dateFinPrevious=").append(dateFinPrevious);
    sb.append(", statutPrevious=").append(statutPrevious);
    sb.append(", dateNextPrevu=").append(dateNextPrevu);
    sb.append(", nbJoursRestantPrevu=").append(nbJoursRestantPrevu);
    sb.append(", idImmo=").append(idImmo);
    sb.append(", dateImmo=").append(dateImmo);
    sb.append(", disponibiliteImmo=").append(disponibiliteImmo);
    sb.append(", debutImmo=").append(debutImmo);
    sb.append(", finImmo=").append(finImmo);
    sb.append(", idNext=").append(idNext);
    sb.append(", libelleNext=").append(libelleNext);
    sb.append(", typeNext=").append(typeNext);
    sb.append(", libelleTypeNext=").append(libelleTypeNext);
    sb.append(", dateDebutNext=").append(dateDebutNext);
    sb.append(", dateFinNext=").append(dateFinNext);
    sb.append(", statutNext=").append(statutNext);
    sb.append(", readableDisponibilite=").append(readableDisponibilite);
    sb.append('}');
    return sb.toString();
  }

}
