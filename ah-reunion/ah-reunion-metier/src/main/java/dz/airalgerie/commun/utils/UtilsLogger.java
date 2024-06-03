/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import dz.airalgerie.grh.model.dto.commun.PersonnelDTO;
import org.slf4j.Logger;
import org.slf4j.MDC;

/**
 *
 * @author kehli
 */
public class UtilsLogger {

  /**
   * Permet d'écrire les logs
   * 
   * @param logger
   * @param user
   * @param action
   * @param detail
   * @param message 
   */  
  public static void doLog(Logger logger, String action, String detail, String message) {
    MDC.put(ErpConstante.LoggerKey.ACTION_KEY, action);
    MDC.put(ErpConstante.LoggerKey.DETAIL_KEY, detail);
    logger.info(message);
  }

  /**
   * Permet de vider les valeurs de MDC
   */
  public static void clear() {
    MDC.clear();
  }

  /**
   * Permet d'ajouter les valeurs à le MDC
   * 
   * @param user 
   */
  public static void userDetails(PersonnelDTO user) {
    if (user != null) {
      MDC.put(ErpConstante.LoggerKey.MATRICULE_KEY, user.getMatricule().toString());
    } else {
      MDC.put(ErpConstante.LoggerKey.USER_KEY, "Anonymous");
      MDC.put(ErpConstante.LoggerKey.MATRICULE_KEY, "Anonymous");
    }
  }
}
