/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.producer;

import dz.airalgerie.commun.helper.mail.MailSessionConfigImpl;
import dz.airalgerie.commun.helper.mail.MailSessionConfig;
import dz.airalgerie.commun.utils.CheckConfigurationParameters;
import static dz.airalgerie.commun.utils.ErpConstante.GlobalResources;
import dz.airalgerie.commun.utils.ErpConstante.MailAddress;
import dz.airalgerie.commun.utils.Strings;
import dz.airalgerie.commun.utils.Util;
import java.util.Properties;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 */
@Dependent
public class MailConfigProducer {

  @Inject
  CheckConfigurationParameters checkConfigurationParameters;

  /**
   * Permet d'initialiser la configuration du sercice mail.
   * 
   * @return Configuration du service mail.
   * @throws NamingException
   */
  @Produces
  @ApplicationScoped
  public MailSessionConfig getMailConfig() throws NamingException {
    MailSessionConfigImpl config = new MailSessionConfigImpl();

    Properties prop = Util.loadApplicationFile();

    String tempProperty;

    tempProperty = checkConfigurationParameters
        .getConfigurationParameters(prop.getProperty(GlobalResources.EMAIL_SERVER_HOST));

    if (!Strings.isNullOrBlank(tempProperty)) {
      config.setServerHost(tempProperty);
    }

    tempProperty = checkConfigurationParameters
        .getConfigurationParameters(prop.getProperty(GlobalResources.EMAIL_SERVER_PORT));
    if (!Strings.isNullOrBlank(tempProperty)) {
      config.setServerPort(tempProperty);
    }

    tempProperty = checkConfigurationParameters
        .getConfigurationParameters(prop.getProperty(GlobalResources.EMAIL_SERVER_SSL_TRUST));
    if (!Strings.isNullOrBlank(tempProperty)) {
      config.setSslTrust(tempProperty);
    }

    tempProperty = checkConfigurationParameters
        .getConfigurationParameters(prop.getProperty(GlobalResources.EMAIL_SERVER_USERNAME));
    if (!Strings.isNullOrBlank(tempProperty)) {
      config.setUsername(tempProperty);
    }

    tempProperty = checkConfigurationParameters
        .getConfigurationParameters(prop.getProperty(GlobalResources.EMAIL_SERVER_PASSWORD));
    if (!Strings.isNullOrBlank(tempProperty)) {
      config.setPassword(tempProperty);
    }

    tempProperty = checkConfigurationParameters
        .getConfigurationParameters(prop.getProperty(GlobalResources.EMAIL_SERVER_ALIAS));
    if (!Strings.isNullOrBlank(tempProperty)) {
      config.setAlias(tempProperty);
    }

    String testAddress = checkConfigurationParameters
        .getConfigurationParameters(prop.getProperty(GlobalResources.EMAIL_TEST_ADDRESS));
    if (!Strings.isNullOrBlank(testAddress)) {
      config.setTestAdress(testAddress);
    }

    tempProperty = prop.getProperty(GlobalResources.APP_ENV);
    if (!Strings.isNullOrBlank(tempProperty)) {
      config.setEnabled(
          Strings.equalsIgnoreCaseWithTrim(tempProperty, GlobalResources.APP_ENV_PRODUCTION));
    }

    // Récupération des adresse de destination
    tempProperty = checkConfigurationParameters
        .getConfigurationParameters(prop.getProperty(MailAddress.FLIGHT_SAFETY));
    if (!Strings.isNullOrBlank(tempProperty)) {
      config.getAddressList().put(MailAddress.FLIGHT_SAFETY, tempProperty);
    } else {
      config.getAddressList().put(MailAddress.FLIGHT_SAFETY, testAddress);
    }

    return config;
  }

}
