/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import dz.airalgerie.commun.grh.utils.StaticVariables;
import java.io.File;

/**
 *
 * @author Sofyane MAKERRI
 */
public interface ErpConstante {

  interface UnitName {

    // Datasource names / jndi
    final static String REF_JNDI_NAME = "jndi_ref";

    // Persistence Unit names
    final static String CPTA_PU_NAME = "cpta_pu";
    final static String FRET_PU_NAME = "fret_pu";
    final static String GRH_PU_NAME = "grh_pu";
    final static String GRH_HIST_PU_NAME = "grh_hist_pu";
    final static String IMMO_PU_NAME = "immo_pu";
    final static String REF_PU_NAME = "ref_pu";
    final static String STK_DMRA_PU_NAME = "stk_dmra_pu";
    final static String STK_CSV_PU_NAME = "stk_csv_pu";
    final static String SYGA_PU_NAME = "syga_pu";
    final static String TAUX_CHANGE_PU_NAME = "taux_change_pu";
    final static String DVOL_PU_NAME = "dvol_pu";
    final static String PAX_ODS_PU_NAME = "pax_ods_pu";
    final static String AGS_PU_NAME = "ags_pu";
    final static String BSP_PU_NAME = "bsp_pu";

    // TODO: A supprimer.
    // final static String GFC_PU_NAME = "cpta_pu";
    // final static String CPTA_PU_NAME = "comptab_glePU";
    // final static String TAUX_CHANGE_PU_NAME = "comptab_glePU2";
    // final static String STAT_PU_NAME = "stat_rhPU";
    // final static String GRH_PU_NAME = "AUTHPU";
    // final static String CPTA_PU_NAME = "fret_PU";
    // final static String CPTA_PU_NAME = "comptab_AnalPU";
    // final static String CPTA_PU_NAME = "comptab_AnalPU3";
    // final static String GRH_PU_NAME = "RET_pool";
    // final static String GRH_PU_NAME = "ttPU";
    // final static String GRH_PU_NAME = "GestionDesMaladiesAHPU";

  }

  interface DbSchemaName {
    final static String AGS_EV = "EV";
    final static String AGS_FPN = "FPN";
    final static String AGS_CAR = "CAR";
    final static String AGS_AUTH = "AUTH";
    final static String AGS_DBO = "DBO";
    final static String CPTA_FAC = "FAC";
    final static String REF_AUTH = "AUTH";
    final static String REF_DOC = "DOC";
    final static String OPS = "OPS";
    final static String PAX_ODS_PRG_EMD = "PRG_EMD";
    final static String CPTA_CV = "CV";
    final static String GRH_MLD = StaticVariables.GRH_MLD_DB_SCHEMA;
  }

  interface LoggerKey {
    final static String USER_KEY = "USER";
    final static String ACTION_KEY = "ACTION";
    final static String DETAIL_KEY = "DETAIL";
    final static String MATRICULE_KEY = "MATRICULE";
  }

  interface LoggerAction {
    final static String ADD = "ADD";
    final static String EDIT = "EDIT";
    final static String DELETE = "DELETE";
    final static String EXECUTE = "EXECUTE";
    final static String EXPORT = "EXPORT";
    final static String AUTH = "AUTH";
  }

  interface DirectoryName {
    final static String REF_DECISION_DIRECTORY = File.separator + "documents" + File.separator
        + "decisions" + File.separator + "%s" + File.separator;
    final static String REF_DOCUMENTATION_DIRECTORY = File.separator + "documents" + File.separator
        + "documentation" + File.separator + "%d" + File.separator;
    final static String GFC_CONTRAT_DIRECTORY =
        File.separator + "documents" + File.separator + "contrats" + File.separator;
    final static String GFC_ETKT_DIRECTORY = File.separator + "ETKT_Archives" + File.separator;
    final static String GFC_FACTURE_RECUE_DIRECTORY = File.separator + "Factures" + File.separator
        + "CU" + File.separator + "Recue" + File.separator + "%s" + File.separator;
    final static String PRT_ASR_DIRECTORY =
        File.separator + "ASR" + File.separator + "%s" + File.separator;
    final static String PRT_CSR_DIRECTORY =
        File.separator + "CSR" + File.separator + "%s" + File.separator;
  }

  interface FtpDirectoryName {
    final static String REF_DECISION_REMOTE_DIRECTORY = "DECISIONS";
    final static String REF_DOCUMENTATION_REMOTE_DIRECTORY = "DOCUMENTATION/%d/";
    final static String GFC_CONTRAT_REMOTE_DIRECTORY = "CONTRAT";
    final static String PRT_ASR_REMOTE_DIRECTORY = "ASR";
    final static String GFC_ETKT_REMOTE_DIRECTORY = "ETKT_Archives";
  }

  interface GlobalResources {
    final static String APP_ENV = "app.env";
    final static String APP_ENV_PRODUCTION = "Production";
    final static String APP_ENV_DEVELOPMENT = "Development";

    final static String RESOURCES_PACKAGE = "dz.airalgerie.i18n.ApplicationBundle";

    final static String FTP_CONFIGURATION_PARAMETERS = "ERPConfigurationParameters";
    final static String LOGO_FILE_IMAGE = "images" + File.separator + "Logo_Air_Algérie.png";

    // Mail const.
    final static String EMAIL_SENDER_LABEL = "Notifications ERP AH";
    final static String EMAIL_DEFAULT_SUBJECT = "Notification automatique";
    final static String EMAIL_SERVER_HOST = "app.mail.server.host";
    final static String EMAIL_SERVER_PORT = "app.mail.server.port";
    final static String EMAIL_SERVER_SSL_TRUST = "app.mail.server.ssl.trust";
    final static String EMAIL_SERVER_USERNAME = "app.mail.server.username";
    final static String EMAIL_SERVER_PASSWORD = "app.mail.server.password";
    final static String EMAIL_SERVER_ALIAS = "app.mail.server.alias";
    final static String EMAIL_TEST_ADDRESS = "app.mail.test.address";
  }

  // Mail address
  interface MailAddress {
    final static String FLIGHT_SAFETY = "app.mail.address.flightsafety";
  }

  interface SessionKey {
    final static String LOGGED_USER = "loggedUser";
  }

  interface DefaultGroupesUser {
    final static String PNT_USER = "defaultPNTGroupe";
    final static String PNC_USER = "defaultPNCGroupe";
    final static String SOL_USER = "defaultSOLGroupe";
  }

  interface OpsOptions {
    final static String EVENEMENT = "events";
    final static String INCIDENTS = "incidents";
    final static String SOLUTIONS = "solutions";
    final static String EVOLUTION = "evolutions";
  }

  interface OpsConstantes {
    final static Long NB_HOURS_ADDITION = 8L;
    final static Integer MIN_IMMOBILISATION_DURATION = NB_HOURS_ADDITION.intValue() * 60;
  }
}
