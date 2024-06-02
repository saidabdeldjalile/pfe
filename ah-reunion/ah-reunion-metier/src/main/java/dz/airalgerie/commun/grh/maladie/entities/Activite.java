/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

/**
 *
 * @author user
 */
public class Activite {
  private int matricule;
  private int datePaie;
  private int nbrJour;
  private int codPoin;
  private String libPoin;

  public Activite(int matricule, int datePaie, int nbrJour, int codPoin, String libPoin) {
    this.matricule = matricule;
    this.datePaie = datePaie;
    this.nbrJour = nbrJour;
    this.codPoin = codPoin;
    this.libPoin = libPoin;

  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public int getDatePaie() {
    return datePaie;
  }

  public void setDatePaie(int datePaie) {
    this.datePaie = datePaie;
  }

  public int getNbrJour() {
    return nbrJour;
  }

  public void setNbrJour(int nbrJour) {
    this.nbrJour = nbrJour;
  }

  public int getCodPoin() {
    return codPoin;
  }

  public void setCodPoin(int codPoin) {
    this.codPoin = codPoin;
  }

  public String getLibPoin() {
    return libPoin;
  }

  public void setLibPoin(String libPoin) {
    this.libPoin = libPoin;
  }

}
