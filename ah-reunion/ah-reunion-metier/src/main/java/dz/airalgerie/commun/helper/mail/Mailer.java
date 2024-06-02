/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.mail;

import static dz.airalgerie.commun.utils.ErpConstante.GlobalResources;
import java.io.File;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 */
@RequestScoped
public class Mailer {

  @Inject
  private MailSessionConfig mailConfig;

  /**
   * Permet d'initialiser le service d'envoi de mails.
   * 
   * @return Service d'envoi de mails.
   */
  public MailMessage initMessage() {
    return new MailMessageImpl(this.mailConfig);
  }

  /**
   * Permet d'initialiser le service d'envoi de mails avec le template par défaut.
   * 
   * @param resourcesFolderPath Répertoire contenant les assets.
   * @return Service d'envoi de mails.
   */
  public MailMessage initMessageWithDefaultTemplate(String resourcesFolderPath) {
    MailMessage message = this.initMessage();

    message.subject(GlobalResources.EMAIL_DEFAULT_SUBJECT);

    String logoFileName = resourcesFolderPath + File.separator + GlobalResources.LOGO_FILE_IMAGE;

    message.addFileAttachementToBody(logoFileName, "<logo>");

    return message;
  }

  public MailSessionConfig getMailConfig() {
    return mailConfig;
  }

  public void setMailConfig(MailSessionConfig mailConfig) {
    this.mailConfig = mailConfig;
  }

}
