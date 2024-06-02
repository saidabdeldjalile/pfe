/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.dto;

/**
 * DTO pour la gestion des clôtures.
 */
public class ClotureDto {

  /**
   * Récupère la date à clôturer.
   */
  private int dateTrt;
  /**
   * Récupère l'exercice de la clôture.
   */
  private int exercice;
  /**
   * Permission de clôturer.
   */
  private boolean canCloture;
  /**
   * Permission d'annuler la dernière clôture.
   */
  private boolean canCancelCloture;

  public ClotureDto() {
    canCloture = false;
    canCancelCloture = false;
  }

  public ClotureDto(int dateTrt, boolean canCloture, boolean canCancelCloture) {
    this.dateTrt = dateTrt;
    this.canCloture = canCloture;
    this.canCancelCloture = canCancelCloture;
  }

  public ClotureDto(int dateTrt, int exercice, boolean canCloture, boolean canCancelCloture) {
    this.dateTrt = dateTrt;
    this.exercice = exercice;
    this.canCloture = canCloture;
    this.canCancelCloture = canCancelCloture;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public int getExercice() {
    return exercice;
  }

  public void setExercice(int exercice) {
    this.exercice = exercice;
  }

  public boolean isCanCloture() {
    return canCloture;
  }

  public void setCanCloture(boolean canCloture) {
    this.canCloture = canCloture;
  }

  public boolean isCanCancelCloture() {
    return canCancelCloture;
  }

  public void setCanCancelCloture(boolean canCancelCloture) {
    this.canCancelCloture = canCancelCloture;
  }

}
