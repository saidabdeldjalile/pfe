/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.mail;

import java.io.File;
import java.util.Map;

/**
 *
 */
public interface MailMessage {

  /**
   * Permet d'ajouter un destinataire.
   * 
   * @param address Adresse du destinataire.
   * @return Builder.
   */
  public MailMessage to(String address);

  /**
   * Permet d'ajouter un objet au mail.
   * 
   * @param subject Objet du mail.
   * @return Builder.
   */
  public MailMessage subject(String subject);

  /**
   * Permet d'envoyer un mail.
   * 
   * @return Builder.
   */
  public MailMessage send();

  /**
   * Permet d'ajouter le corps d'un mail.
   * 
   * @param body Corps du mail.
   * @return Builder.
   */
  public MailMessage body(String body);

  /**
   * Permet d'ajouter un corps au mail avec un template.
   * 
   * @param model        Paramètres à passer au template.
   * @param templateName Nom du template à utiliser.
   * @return Builder.
   */
  public MailMessage body(Map<String, Object> model, String templateName);

  /**
   * Permet d'ajouter un pièce-jointe au mail.
   * 
   * @param fileName Nom du fichier.
   * @return Builder.
   */
  public MailMessage addFileAttachement(String fileName);

  /**
   * Permet d'ajouter un pièce-jointe au mail.
   * 
   * @param file Fichier à attacher.
   * @return Builder.
   */
  public MailMessage addFileAttachement(File file);

  /**
   * Permet d'ajouter un pièce-jointe au corps du mail.
   * 
   * @param fileName Nom du fichier.
   * @param tagName  Tag de destination au niveau du template.
   * @return Builder.
   */
  public MailMessage addFileAttachementToBody(String fileName, String tagName);

  /**
   * Permet d'ajouter un pièce-jointe au corps du mail.
   * 
   * @param file    Fichier à attacher.
   * @param tagName Tag de destination au niveau du template.
   * @return Builder.
   */
  public MailMessage addFileAttachementToBody(File file, String tagName);

}
