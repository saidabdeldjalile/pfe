/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

/**
 *
 */
public enum UserRole {

  Directeur("Directeur"), Divisionaire("Divisionaire"), Administrateur(
      "Administrateur"), AdministrateurD("AdministrateurD"), AdministrateurDirsSol(
          "AdministrateurDirsSol"), AdministrateurGRP_CHAP(
              "AdministrateurGRP_CHAP"), AdministrateurNonDir(
                  "AdministrateurNonDir"), AdministrateurDirsEtrg(
                      "AdministrateurDirsEtrg"), AdministrateurDirs(
                          "AdministrateurDirs"), AdministrateurPN(
                              "AdministrateurPN"), divisionnaireDC(
                                  "divisionnaireDC"), divisionnaireDMRA(
                                      "divisionnaireDMRA"), divisionnaireExploitation(
                                          "divisionnaireExploitation"), DRHAdministrateurNonDirRecrut(
                                              "DRHAdministrateurNonDirRecrut"), DRHAdministrateurPNNonRecrut(
                                                  "DRHAdministrateurPNNonRecrut"), Retraite(
                                                      "Retraite"), SousDirecteur(
                                                          "SousDirecteur"), grhBulletinSearchAll(
                                                              "grhBulletinSearchAll"), prtCompensationSuperviseur(
                                                                  "prtCompensationSuperviseur"), prtCompensationApprove(
                                                                      "prtCompensationApprove"), prtFsbFlightAdmin(
                                                                          "prtFsbFlightAdmin"), prtFsbFlightStatsAdmin(
                                                                              "prtFsbFlightStatsAdmin"), prtFsbAsrAdminView(
                                                                                  "prtFsbAsrAdminView"), prtFsbCsrAdminView(
                                                                                      "prtFsbCsrAdminView"), gfcCuSuperviseur(
                                                                                          "gfcCuSuperviseur"), gfcEcofieSuperviseur(
                                                                                              "gfcEcofieSuperviseur"), opsCompensationEmdSuperviseur(
                                                                                                  "opsCompensationEmdSuperviseur"), opsCompensationEmdApprove(
                                                                                                      "opsCompensationEmdApprove");


  private final String label;

  private UserRole(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  @Override
  public String toString() {
    return "UserRole{" + "label=" + label + '}';
  }

}
