/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import java.io.Serializable;

/**
 *
 * @author Administrateur
 */
public class FreeMarker implements Serializable {

  private static final long serialVersionUID = 1L;

  public static Configuration config() {
    // Init FreeMarker params
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
    cfg.setClassForTemplateLoading(FreeMarker.class, "/dz/airalgerie/gfc/templates/");
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    cfg.setWrapUncheckedExceptions(true);
    cfg.setFallbackOnNullLoopVariable(false);

    return cfg;
  }

  /**
   * Initialise la configuration du service d'envoi de mail.
   * 
   * @return La congifuration.
   */
  public static Configuration mailConfig() {
    // Init FreeMarker params
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
    cfg.setClassForTemplateLoading(FreeMarker.class, "/dz/airalgerie/commun/templates/");
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    cfg.setWrapUncheckedExceptions(true);
    cfg.setFallbackOnNullLoopVariable(false);

    return cfg;
  }

}
