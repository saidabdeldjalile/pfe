/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.mail;

import dz.airalgerie.commun.exception.mail.InvalidAddressException;
import dz.airalgerie.commun.exception.mail.MailException;
import dz.airalgerie.commun.exception.mail.SendFailedException;
import static dz.airalgerie.commun.utils.ErpConstante.GlobalResources;
import dz.airalgerie.commun.utils.FreeMarker;
import dz.airalgerie.commun.utils.Strings;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 */
public class MailMessageImpl implements MailMessage {

  Session sessionConfig;
  MailSessionConfig mailConfig;

  String subject;

  MimeMessage message;

  MimeMultipart multipart;

  /**
   * Permet de construire une mail à partir de la configuration de la session.
   * 
   * @param mailConfig Configuration du service.
   */
  public MailMessageImpl(MailSessionConfig mailConfig) {
    this.mailConfig = mailConfig;

    sessionConfig = createSession(mailConfig);

    message = new MimeMessage(sessionConfig);
    multipart = new MimeMultipart("related");

    try {
      message.setSentDate(new Date());
    } catch (MessagingException e) {
      throw new MailException(e);
    }

    try {
      message.setFrom(new InternetAddress(mailConfig.getUsername(), mailConfig.getAlias()));
    } catch (UnsupportedEncodingException | MessagingException e) {
      throw new InvalidAddressException(e);
    }

  }

  @Override
  public MailMessage to(String address) throws InvalidAddressException {
    try {
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address, false));

      return this;
    } catch (MessagingException e) {
      throw new InvalidAddressException(e);
    }
  }

  @Override
  public MailMessage subject(String subject) {
    try {
      message.setSubject(subject, "UTF-8");
    } catch (MessagingException e) {
      throw new MailException(e);
    }
    return this;
  }

  @Override
  public MailMessage body(String body) {
    try {
      BodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent(body, "text/html; charset=UTF-8");

      multipart.addBodyPart(messageBodyPart);
    } catch (MessagingException e) {
      throw new MailException(e);
    }

    return this;
  }

  @Override
  public MailMessage body(Map<String, Object> model, String templateName) {
    try {
      BodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent(contentFromTemplate(model, templateName),
          "text/html; charset=UTF-8");

      multipart.addBodyPart(messageBodyPart);

      return this;
    } catch (MessagingException e) {
      throw new MailException(e);
    } catch (Exception ex) {
      throw new MailException(ex);
    }
  }

  @Override
  public MailMessage addFileAttachementToBody(String fileName, String tagName) {
    File file = new File(fileName);

    return addFileAttachementToBody(file, tagName);
  }

  @Override
  public MailMessage addFileAttachementToBody(File file, String tagName) {
    try {
      BodyPart messageBodyPart = new MimeBodyPart();
      DataSource fileData = new FileDataSource(file);
      messageBodyPart.setDataHandler(new DataHandler(fileData));
      messageBodyPart.setHeader("Content-ID", tagName);

      multipart.addBodyPart(messageBodyPart);

      return this;
    } catch (MessagingException e) {
      throw new MailException(e);
    }
  }

  @Override
  public MailMessage addFileAttachement(String fileName) {
    File file = new File(fileName);

    return addFileAttachement(file);
  }

  @Override
  public MailMessage addFileAttachement(File file) {
    try {
      BodyPart messageBodyPart = new MimeBodyPart();
      DataSource dataFile = new FileDataSource(file);
      messageBodyPart.setDataHandler(new DataHandler(dataFile));
      messageBodyPart.setFileName(file.getName());

      multipart.addBodyPart(messageBodyPart);

      return this;
    } catch (MessagingException e) {
      throw new MailException(e);
    }
  }

  @Override
  public MailMessage send() {
    try {
      message.setContent(multipart);

      if (!this.mailConfig.isEnabled()) {
        this.to(this.mailConfig.getTestAdress());
      }

      Transport.send(message);

      return this;
    } catch (MessagingException | InvalidAddressException e) {
      throw new SendFailedException(e);
    }
  }

  private static Session createSession(MailSessionConfig mailConfig) {

    Session session;

    Properties props = System.getProperties();

    if (!Strings.isNullOrBlank(mailConfig.getServerHost())
        && !Strings.isNullOrBlank(mailConfig.getServerPort())) {
      props.setProperty("mail.smtp.host", mailConfig.getServerHost());
      props.setProperty("mail.smtp.port", mailConfig.getServerPort());
      props.setProperty("mail.smtp.auth", mailConfig.getAuth());
      props.setProperty("mail.smtp.ssl.trust", mailConfig.getSslTrust());
      props.setProperty("mail.smtp.starttls.enable", mailConfig.getEnableTls());
      props.setProperty("mail.transport.protocol", mailConfig.getProtocol());
    } else {
      // throw exception;
    }

    if (!Strings.isNullOrBlank(mailConfig.getUsername())
        && !Strings.isNullOrBlank(mailConfig.getPassword())) {

      session = Session.getInstance(props, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(mailConfig.getUsername(), mailConfig.getPassword());

        }
      });
    } else {
      session = Session.getInstance(props, null);
    }

    return session;

  }

  private static String contentFromTemplate(Map data, String templateName) throws Exception {
    try {
      StringWriter content = new StringWriter();

      Template template = FreeMarker.mailConfig().getTemplate(templateName);
      template.process(data, content);

      return content.toString();
    } catch (TemplateException | IOException ex) {
      throw new Exception(ex);
    }
  }

}
