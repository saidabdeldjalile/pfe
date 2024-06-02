/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

package dz.airalgerie.grh.model.entities.gp;

/**
 *
 * @author Root
 */
public enum GpConstants {
  R1("R1"), 
  R2("R2"), 
  R3("R3"), 
  R3NATIONAL("R3N"), 
  NORMALE("N"), 
  RETRAITE("R"),
  ETRANGER("F"),
  ANTICIPE("A"),
  EXCEPTIONNEL("E"),
  PNTTECH("T"), 
  PNCTECH("C"), 
  SPOUSE("CNJ"),
  PARENT("PRT"),
  CHILD("ENF"),
  EMP("EMP"), 
  PNT("PNT"),
  RET("RET"), 
  FORFAITAIRE("FF3"), 
  VALIDE("validé"), 
  CONSOMME("consommé"), 
  APPROUVE("approuvé"), 
  ENCOURS("en cours"),
  REJETE("rejeté"),
  ANNULE("annulé"),
  GPGROUP("grhGpDashConsultation"),
  EXPATRIE("E"),
  LOCAL("L");

  private GpConstants(String value) {
    this.value = value;
  }

  private final String value;

  public String getValue() {
    return value;
  }
}
