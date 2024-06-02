/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.dto.cu;

import java.io.Serializable;

/**
 *
 * @author kehli
 */
public class DTOCentreComptableDirection implements Serializable {

  private String codeDirection;
  private String libelleDirection;
  private String codeCentreCpt;
  private String libelleCentreComtpable;

  public DTOCentreComptableDirection() {
  }

  public DTOCentreComptableDirection(String codeDirection, String libelleDirection,
      String codeCentreCpt, String libelleCentreComtpable) {
    this.codeDirection = codeDirection;
    this.libelleDirection = libelleDirection;
    this.codeCentreCpt = codeCentreCpt;
    this.libelleCentreComtpable = libelleCentreComtpable;
  }

  public String getCodeDirection() {
    return codeDirection;
  }

  public void setCodeDirection(String codeDirection) {
    this.codeDirection = codeDirection;
  }

  public String getLibelleDirection() {
    return libelleDirection;
  }

  public void setLibelleDirection(String libelleDirection) {
    this.libelleDirection = libelleDirection;
  }

  public String getCodeCentreCpt() {
    return codeCentreCpt;
  }

  public void setCodeCentreCpt(String codeCentreCpt) {
    this.codeCentreCpt = codeCentreCpt;
  }

  public String getLibelleCentreComtpable() {
    return libelleCentreComtpable;
  }

  public void setLibelleCentreComtpable(String libelleCentreComtpable) {
    this.libelleCentreComtpable = libelleCentreComtpable;
  }

}
