/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Administrateur
 */
public class EmailService {

  public static void notifMe(String reci) {

    Properties props = System.getProperties();

    props.put("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.ssl.trust", "mail.airalgerie.dz");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "mail.airalgerie.dz");
    props.put("mail.smtp.port", "587");
    props.put("mail.transport.protocol", "smtp");

    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("notif.noreply@airalgerie.dz", "B28dAh@5");

      }
    });
    Message msg = new MimeMessage(session);

    try {

      msg.setFrom(new InternetAddress("notif.noreply@airalgerie.dz"));
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reci, false));
      msg.setSubject("Demande GP");
      msg.setContent(
          "<div class=\"\"><div class=\"aHl\"></div><div id=\":lq\" tabindex=\"-1\"></div><div id=\":n4\" class=\"ii gt\"><div id=\":n3\" class=\"a3s aXjCH msg1472262468986647585\"><u></u>\n"
              + "<div style=\"margin:0;padding:0\">\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody>\n" + "	<tr>\n" + "        <td bgcolor=\"#ffffff\">\n"
              + "            <div align=\"center\" style=\"padding:0px 15px 0px 15px\">\n"
              + "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n"
              + "                    \n" + "                    <tbody><tr>\n"
              + "                        <td style=\"padding:30px 0px 10px 0px\">\n"
              + "                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "                                <tbody><tr>\n"
              + "                                    <td bgcolor=\"#ffffff\" width=\"100\" align=\"center\"><a href=\"https://airalgerie.dz/\" target=\"_blank\" ><img alt=\"Logo\" src=\"https://airalgerie.dz/wp-content/uploads/2022/11/logotype-ah-air-algerie.svg\" width=\"364\" height=\"70\" style=\"display:block;font-family:Helvetica,Arial,sans-serif;color:#666666;font-size:16px\" border=\"0\" class=\"CToWUd\"></a></td>\n"
              + "                                </tr>\n"
              + "                            </tbody></table>\n" + "                        </td>\n"
              + "                    </tr>\n" + "                </tbody></table>\n"
              + "            </div>\n" + "        </td>\n" + "    </tr>\n" + "</tbody>\n"
              + "</table>\n" + "\n" + "\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody><tr>\n"
              + "        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding:10px 15px 20px 15px\">\n"
              + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n"
              + "                <tbody><tr>\n" + "                    <td>\n"
              + "                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                            <tbody><tr>\n"
              + "                                <td>\n" + "                                    \n"
              + "                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                                        <tbody><tr>\n"
              + "                                            <td align=\"center\" style=\"font-size:20px;font-family:Helvetica,Arial,sans-serif;font-weight:bold;color:#333333;padding-top:30px\">Bonjour ,\n"
              + "Nous avons bien reçu votre demande de GP.\n"
              + "La demande sera traitée dans les meilleurs délais. Nous vous informerons de son avancement par email.\n"
              + "                                        </tr>\n"
              + "                                        <tr>\n"
              + "                                            <td align=\"center\" style=\"padding:10px 0 0 0;font-size:13px;line-height:18px;font-family:Helvetica,Arial,sans-serif;color:#666666\">Cordialement, \n L'équipe AH\n</td>\n </td>\n"
              + "                                        </tr>\n"
              + "                                    </tbody></table>\n"
              + "                                </td>\n" + "                            </tr>\n"
              + "                            <tr>\n" + "                                <td>\n"
              + "                                    \n" + "                    </td>\n"
              + "                </tr>\n" + "            </tbody></table>\n" + "        </td>\n"
              + "    </tr>\n" + "</tbody></table>\n" + "\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody><tr>\n" + "        <td bgcolor=\"#ffffff\" align=\"center\">\n"
              + "            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
              + "                <tbody><tr>\n"
              + "                    <td style=\"padding:20px 20px 20px 20px\">\n"
              + "                        \n"
              + "                        <table width=\"500\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
              + "                            <tbody><tr>\n"
              + "                                <td align=\"center\" valign=\"middle\" style=\"font-size:12px;line-height:18px;font-family:Helvetica,Arial,sans-serif;color:#8b8b8b\">\n"
              + "                                    <span class=\"m_1472262468986647585appleFooter\" style=\"color:#8b8b8b\"> \n"
              + "                                        © "+LocalDate.now().getYear()+" AIR ALGERIE, Technopôle Air Algérie W13, Bachdjerah\n"
              + "                                    </span>\n"
              + "                            </td></tr>\n"
              + "                        </tbody></table>\n" + "                    </td>\n"
              + "                </tr>\n" + "            </tbody></table>\n" + "        </td>\n"
              + "    </tr>\n" + "</tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n"
              + "\n" + "</div></div><div class=\"adL\">\n" + "\n" + "\n"
              + "</div></div></div><div id=\":lv\" class=\"ii gt\" style=\"display:none\"><div id=\":lu\" class=\"a3s aXjCH undefined\"></div></div><div class=\"hi\"></div></div>",
          "text/html; charset=utf-8");

      Transport.send(msg);
      System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

  public static void notifMeValid(String reci) {

    Properties props = System.getProperties();

    props.put("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.ssl.trust", "mail.airalgerie.dz");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "mail.airalgerie.dz");
    props.put("mail.smtp.port", "587");
    props.put("mail.transport.protocol", "smtp");

    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("notif.noreply@airalgerie.dz", "B28dAh@5");

      }
    });
    Message msg = new MimeMessage(session);

    try {

      msg.setFrom(new InternetAddress("noreply-mail@airalgerie.dz"));
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reci, false));
      msg.setSubject("Demande GP");
      msg.setContent(
          "<div class=\"\"><div class=\"aHl\"></div><div id=\":lq\" tabindex=\"-1\"></div><div id=\":n4\" class=\"ii gt\"><div id=\":n3\" class=\"a3s aXjCH msg1472262468986647585\"><u></u>\n"
              + "<div style=\"margin:0;padding:0\">\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody>\n" + "	<tr>\n" + "        <td bgcolor=\"#ffffff\">\n"
              + "            <div align=\"center\" style=\"padding:0px 15px 0px 15px\">\n"
              + "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n"
              + "                    \n" + "                    <tbody><tr>\n"
              + "                        <td style=\"padding:30px 0px 10px 0px\">\n"
              + "                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "                                <tbody><tr>\n"
              + "                                    <td bgcolor=\"#ffffff\" width=\"100\" align=\"center\"><a href=\"https://airalgerie.dz/\" target=\"_blank\" ><img alt=\"Logo\" src=\"https://airalgerie.dz/wp-content/uploads/2022/11/logotype-ah-air-algerie.svg\" width=\"364\" height=\"70\" style=\"display:block;font-family:Helvetica,Arial,sans-serif;color:#666666;font-size:16px\" border=\"0\" class=\"CToWUd\"></a></td>\n"
              + "                                </tr>\n"
              + "                            </tbody></table>\n" + "                        </td>\n"
              + "                    </tr>\n" + "                </tbody></table>\n"
              + "            </div>\n" + "        </td>\n" + "    </tr>\n" + "</tbody>\n"
              + "</table>\n" + "\n" + "\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody><tr>\n"
              + "        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding:10px 15px 20px 15px\">\n"
              + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n"
              + "                <tbody><tr>\n" + "                    <td>\n"
              + "                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                            <tbody><tr>\n"
              + "                                <td>\n" + "                                    \n"
              + "                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                                        <tbody><tr>\n"
              + "                                            <td align=\"center\" style=\"font-size:20px;font-family:Helvetica,Arial,sans-serif;font-weight:bold;color:#333333;padding-top:30px\">Bonjour ,\n"
              + "votre demande a été validée ! \n" + "Cordialement,"
              + "                                        </tr>\n"
              + "                                        <tr>\n"
              + "                                            <td align=\"center\" style=\"padding:10px 0 0 0;font-size:13px;line-height:18px;font-family:Helvetica,Arial,sans-serif;color:#666666\">Cordialement, \n L'équipe AH\n</td>\n </td>\n"
              + "                                        </tr>\n"
              + "                                    </tbody></table>\n"
              + "                                </td>\n" + "                            </tr>\n"
              + "                            <tr>\n" + "                                <td>\n"
              + "                                    \n" + "                    </td>\n"
              + "                </tr>\n" + "            </tbody></table>\n" + "        </td>\n"
              + "    </tr>\n" + "</tbody></table>\n" + "\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody><tr>\n" + "        <td bgcolor=\"#ffffff\" align=\"center\">\n"
              + "            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
              + "                <tbody><tr>\n"
              + "                    <td style=\"padding:20px 20px 20px 20px\">\n"
              + "                        \n"
              + "                        <table width=\"500\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
              + "                            <tbody><tr>\n"
              + "                                <td align=\"center\" valign=\"middle\" style=\"font-size:12px;line-height:18px;font-family:Helvetica,Arial,sans-serif;color:#8b8b8b\">\n"
              + "                                    <span class=\"m_1472262468986647585appleFooter\" style=\"color:#8b8b8b\"> \n"
              + "                                        © "+LocalDate.now().getYear()+" AIR ALGERIE, Technopôle Air Algérie W13, Bachdjerah\n"
              + "                                    </span>\n"
              + "                            </td></tr>\n"
              + "                        </tbody></table>\n" + "                    </td>\n"
              + "                </tr>\n" + "            </tbody></table>\n" + "        </td>\n"
              + "    </tr>\n" + "</tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n"
              + "\n" + "</div></div><div class=\"adL\">\n" + "\n" + "\n"
              + "</div></div></div><div id=\":lv\" class=\"ii gt\" style=\"display:none\"><div id=\":lu\" class=\"a3s aXjCH undefined\"></div></div><div class=\"hi\"></div></div>",
          "text/html; charset=utf-8");
      Transport.send(msg);
      System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

  public static void notifMeVal(String reci, String code) {

    Properties props = System.getProperties();

    props.put("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.ssl.trust", "mail.airalgerie.dz");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "mail.airalgerie.dz");
    props.put("mail.smtp.port", "587");
    props.put("mail.transport.protocol", "smtp");

    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("notif.noreply@airalgerie.dz", "B28dAh@5");

      }
    });
    Message msg = new MimeMessage(session);

    try {

      msg.setFrom(new InternetAddress("notif.noreply@airalgerie.dz"));
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reci, false));
      msg.setSubject("Demande GP");
      msg.setContent(
          "<div class=\"\"><div class=\"aHl\"></div><div id=\":lq\" tabindex=\"-1\"></div><div id=\":n4\" class=\"ii gt\"><div id=\":n3\" class=\"a3s aXjCH msg1472262468986647585\"><u></u>\n"
              + "<div style=\"margin:0;padding:0\">\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody>\n" + "	<tr>\n" + "        <td bgcolor=\"#ffffff\">\n"
              + "            <div align=\"center\" style=\"padding:0px 15px 0px 15px\">\n"
              + "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n"
              + "                    \n" + "                    <tbody><tr>\n"
              + "                        <td style=\"padding:30px 0px 10px 0px\">\n"
              + "                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "                                <tbody><tr>\n"
              + "                                    <td bgcolor=\"#ffffff\" width=\"100\" align=\"center\"><a href=\"https://airalgerie.dz/\" target=\"_blank\" ><img alt=\"Logo\" src=\"https://airalgerie.dz/wp-content/uploads/2022/11/logotype-ah-air-algerie.svg\" width=\"364\" height=\"70\" style=\"display:block;font-family:Helvetica,Arial,sans-serif;color:#666666;font-size:16px\" border=\"0\" class=\"CToWUd\"></a></td>\n"
              + "                                </tr>\n"
              + "                            </tbody></table>\n" + "                        </td>\n"
              + "                    </tr>\n" + "                </tbody></table>\n"
              + "            </div>\n" + "        </td>\n" + "    </tr>\n" + "</tbody>\n"
              + "</table>\n" + "\n" + "\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody><tr>\n"
              + "        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding:10px 15px 20px 15px\">\n"
              + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n"
              + "                <tbody><tr>\n" + "                    <td>\n"
              + "                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                            <tbody><tr>\n"
              + "                                <td>\n" + "                                    \n"
              + "                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                                        <tbody><tr>\n"
              + "                                            <td align=\"center\" style=\"font-size:20px;font-family:Helvetica,Arial,sans-serif;font-weight:bold;color:#333333;padding-top:30px\">Votre code GP est : "
              + code + "</td>\n" + "                                        </tr>\n"
              + "                                        <tr>\n"
              + "                                            <td align=\"center\" style=\"padding:10px 0 0 0;font-size:13px;line-height:18px;font-family:Helvetica,Arial,sans-serif;color:#666666\"> vous pouvez demander un nouveau GP la prochaine fois que vous ouvrez l'application. </td>\n"
              + "                                        </tr>\n"
              + "                                    </tbody></table>\n"
              + "                                </td>\n" + "                            </tr>\n"
              + "                            <tr>\n" + "                                <td>\n"
              + "                                    \n"
              + "                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                                        <tbody><tr>\n"
              + "                                            <td align=\"center\" style=\"padding:25px 0 0 0\">\n"
              + "                                                <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                                                    <tbody><tr>\n"
              + "                                                        <td align=\"center\"><a href=\"https://www.google.fr/maps/search/agence+air+algerie\">Find a closest agency direction</a></td>\n"
              + "                                                    </tr>\n"
              + "                                                </tbody></table>\n"
              + "                                            </td>\n"
              + "                                        </tr>\n"
              + "                                    </tbody></table>\n"
              + "                                </td>\n" + "                            </tr>\n"
              + "                        </tbody></table>\n" + "                    </td>\n"
              + "                </tr>\n" + "            </tbody></table>\n" + "        </td>\n"
              + "    </tr>\n" + "</tbody></table>\n" + "\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody><tr>\n" + "        <td bgcolor=\"#ffffff\" align=\"center\">\n"
              + "            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
              + "                <tbody><tr>\n"
              + "                    <td style=\"padding:20px 20px 20px 20px\">\n"
              + "                        \n"
              + "                        <table width=\"500\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
              + "                            <tbody><tr>\n"
              + "                                <td align=\"center\" valign=\"middle\" style=\"font-size:12px;line-height:18px;font-family:Helvetica,Arial,sans-serif;color:#8b8b8b\">\n"
              + "                                    <span class=\"m_1472262468986647585appleFooter\" style=\"color:#8b8b8b\"> \n"
              + "                                        © "+LocalDate.now().getYear()+" AIR ALGERIE, Technopôle Air Algérie W13, Bachdjerah\n"
              + "                                    </span>\n"
              + "                            </td></tr>\n"
              + "                        </tbody></table>\n" + "                    </td>\n"
              + "                </tr>\n" + "            </tbody></table>\n" + "        </td>\n"
              + "    </tr>\n" + "</tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n"
              + "\n" + "</div></div><div class=\"adL\">\n" + "\n" + "\n"
              + "</div></div></div><div id=\":lv\" class=\"ii gt\" style=\"display:none\"><div id=\":lu\" class=\"a3s aXjCH undefined\"></div></div><div class=\"hi\"></div></div>",
          "text/html; charset=utf-8");
      Transport.send(msg);
      System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

  public static void notifMeLast(String reci) {

    Properties props = System.getProperties();

    props.put("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.ssl.trust", "mail.airalgerie.dz");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "mail.airalgerie.dz");
    props.put("mail.smtp.port", "587");
    props.put("mail.transport.protocol", "smtp");

    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("notif.noreply@airalgerie.dz", "B28dAh@5");

      }
    });
    Message msg = new MimeMessage(session);

    try {

      msg.setFrom(new InternetAddress("notif.noreply@airalgerie.dz"));
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reci, false));
      msg.setSubject("Demande GP");
      msg.setContent(
          "<div class=\"\"><div class=\"aHl\"></div><div id=\":lq\" tabindex=\"-1\"></div><div id=\":n4\" class=\"ii gt\"><div id=\":n3\" class=\"a3s aXjCH msg1472262468986647585\"><u></u>\n"
              + "<div style=\"margin:0;padding:0\">\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody>\n" + "	<tr>\n" + "        <td bgcolor=\"#ffffff\">\n"
              + "            <div align=\"center\" style=\"padding:0px 15px 0px 15px\">\n"
              + "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n"
              + "                    \n" + "                    <tbody><tr>\n"
              + "                        <td style=\"padding:30px 0px 10px 0px\">\n"
              + "                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "                                <tbody><tr>\n"
              + "                                    <td bgcolor=\"#ffffff\" width=\"100\" align=\"center\"><a href=\"https://airalgerie.dz/\" target=\"_blank\" ><img alt=\"Logo\" src=\"https://airalgerie.dz/wp-content/uploads/2022/11/logotype-ah-air-algerie.svg\" width=\"364\" height=\"70\" style=\"display:block;font-family:Helvetica,Arial,sans-serif;color:#666666;font-size:16px\" border=\"0\" class=\"CToWUd\"></a></td>\n"
              + "                                </tr>\n"
              + "                            </tbody></table>\n" + "                        </td>\n"
              + "                    </tr>\n" + "                </tbody></table>\n"
              + "            </div>\n" + "        </td>\n" + "    </tr>\n" + "</tbody>\n"
              + "</table>\n" + "\n" + "\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody><tr>\n"
              + "        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding:10px 15px 20px 15px\">\n"
              + "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\">\n"
              + "                <tbody><tr>\n" + "                    <td>\n"
              + "                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                            <tbody><tr>\n"
              + "                                <td>\n" + "                                    \n"
              + "                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
              + "                                        <tbody><tr>\n"
              + "                                            <td align=\"center\" style=\"font-size:20px;font-family:Helvetica,Arial,sans-serif;font-weight:bold;color:#333333;padding-top:30px\">Bonjour ,\n"
              + "Votre demande a été approuvée\n" + "Merci de vous être enregistré\n"
              + "                                        </tr>\n"
              + "                                        <tr>\n"
              + "                                            <td align=\"center\" style=\"padding:10px 0 0 0;font-size:13px;line-height:18px;font-family:Helvetica,Arial,sans-serif;color:#666666\">Cordialement, \n L'équipe AH\n</td>\n </td>\n"
              + "                                        </tr>\n"
              + "                                    </tbody></table>\n"
              + "                                </td>\n" + "                            </tr>\n"
              + "                            <tr>\n" + "                                <td>\n"
              + "                                    \n" + "                    </td>\n"
              + "                </tr>\n" + "            </tbody></table>\n" + "        </td>\n"
              + "    </tr>\n" + "</tbody></table>\n" + "\n"
              + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
              + "    <tbody><tr>\n" + "        <td bgcolor=\"#ffffff\" align=\"center\">\n"
              + "            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
              + "                <tbody><tr>\n"
              + "                    <td style=\"padding:20px 20px 20px 20px\">\n"
              + "                        \n"
              + "                        <table width=\"500\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n"
              + "                            <tbody><tr>\n"
              + "                                <td align=\"center\" valign=\"middle\" style=\"font-size:12px;line-height:18px;font-family:Helvetica,Arial,sans-serif;color:#8b8b8b\">\n"
              + "                                    <span class=\"m_1472262468986647585appleFooter\" style=\"color:#8b8b8b\"> \n"
              + "                                        © "+LocalDate.now().getYear()+" AIR ALGERIE, Technopôle Air Algérie W13, Bachdjerah\n"
              + "                                    </span>\n"
              + "                            </td></tr>\n"
              + "                        </tbody></table>\n" + "                    </td>\n"
              + "                </tr>\n" + "            </tbody></table>\n" + "        </td>\n"
              + "    </tr>\n" + "</tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n"
              + "\n" + "</div></div><div class=\"adL\">\n" + "\n" + "\n"
              + "</div></div></div><div id=\":lv\" class=\"ii gt\" style=\"display:none\"><div id=\":lu\" class=\"a3s aXjCH undefined\"></div></div><div class=\"hi\"></div></div>",
          "text/html; charset=utf-8");
      Transport.send(msg);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }


  /**
   * Permet d'envoyer un email de changement de mot de passe
   * 
   * @param recipient : l'email destinataire
   * @param password  : le nouveau mot de passe
   * @param subject   : le sujet de l'email
   */
  @Deprecated
  public static void notifResetPassword(String recipient, String password, String subject) {

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String resetPasswordDate = formatter.format(calendar.getTime());

    Properties props = System.getProperties();

    props.put("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.ssl.trust", "mail.airalgerie.dz");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "mail.airalgerie.dz");
    props.put("mail.smtp.port", "587");
    props.put("mail.transport.protocol", "smtp");

    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("notif.noreply@airalgerie.dz", "B28dAh@5");

      }
    });
    MimeMessage msg = new MimeMessage(session);

    try {

      msg.setFrom(new InternetAddress("notif.noreply@airalgerie.dz"));
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));
      msg.setSubject(subject, "UTF-8");
      msg.setContent("<html xmlns:v=\"urn:schemas-microsoft-com:vml\" \n"
          + "      xmlns:o=\"urn:schemas-microsoft-com:office:office\" \n"
          + "      xmlns:w=\"urn:schemas-microsoft-com:office:word\" \n"
          + "      xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\" \n"
          + "      xmlns=\"http://www.w3.org/TR/REC-html40\">\n" + "    <head>\n"
          + "        <meta http-equiv=Content-Type content=\"text/html; charset=iso-8859-1\">\n"
          + "            <meta name=Generator content=\"Microsoft Word 15 (filtered medium)\">\n"
          + "                <style>\n" + "                    <!--\n"
          + "                    /* Font Definitions */\n" + "                    @font-face\n"
          + "                    {font-family:Calibri;\n"
          + "                     panose-1:2 15 5 2 2 2 4 3 2 4;}\n"
          + "                    /* Style Definitions */\n"
          + "                    p.MsoNormal, li.MsoNormal, div.MsoNormal\n"
          + "                    {margin:0cm;\n" + "                     margin-bottom:.0001pt;\n"
          + "                     font-size:11.0pt;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     mso-fareast-language:EN-US;}\n"
          + "                    a:link, span.MsoHyperlink\n"
          + "                    {mso-style-priority:99;\n"
          + "                     color:#0563C1;\n"
          + "                     text-decoration:underline;}\n"
          + "                    a:visited, span.MsoHyperlinkFollowed\n"
          + "                    {mso-style-priority:99;\n"
          + "                     color:#954F72;\n"
          + "                     text-decoration:underline;}\n"
          + "                    span.EmailStyle17\n"
          + "                    {mso-style-type:personal-compose;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     color:windowtext;}\n" + "                    .MsoChpDefault\n"
          + "                    {mso-style-type:export-only;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     mso-fareast-language:EN-US;}\n"
          + "                    @page WordSection1\n"
          + "                    {size:612.0pt 792.0pt;\n"
          + "                     margin:70.85pt 70.85pt 70.85pt 70.85pt;}\n"
          + "                    div.WordSection1\n" + "                    {page:WordSection1;}\n"
          + "                    -->\n" + "                </style>\n"
          + "                <!--[if gte mso 9]><xml>\n"
          + "                <o:shapedefaults v:ext=\"edit\" spidmax=\"1026\" />\n"
          + "                </xml><![endif]--><!--[if gte mso 9]><xml>\n"
          + "                <o:shapelayout v:ext=\"edit\">\n"
          + "                <o:idmap v:ext=\"edit\" data=\"1\" />\n"
          + "                </o:shapelayout></xml><![endif]-->\n" + "    </head>\n"
          + "    <body lang=FR link=\"#0563C1\" vlink=\"#954F72\">\n"
          + "        <div class=WordSection1>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>Bonjour&nbsp;,<o:p></o:p></span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>\n"
          + "                    Suite à votre demande de réinitialisation de votre mot de passe pour votre compte sur l&#8217;ERP AH &nbsp;du \n"
          + "                    <b>" + resetPasswordDate + "</b>, \n"
          + "                    &nbsp;nous vous informons que votre mot de passe a été réinitialisé avec succès.<o:p></o:p>\n"
          + "                </span>\n" + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>\n"
          + "                    <o:p>&nbsp;</o:p>\n" + "                </span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>\n"
          + "                    Lien&nbsp;ERP : <b><a href=\"https://erp.airalgerie.dz\">https://erp.airalgerie.dz</a></b> <o:p></o:p>\n"
          + "                </span>\n" + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>\n"
          + "                    Votre identifiant&nbsp;: <b><span style='color:#1F497D;text-decoration:none'>"
          + recipient + "</span></b><o:p></o:p>\n" + "                </span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>\n"
          + "                    Votre nouveau mot de passe&nbsp;: <b>" + password
          + "</b><o:p></o:p>\n" + "                </span>\n" + "            </p>\n"
          + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>\n"
          + "                    Veuillez modifier votre mot de passe lors de votre première authentification via le menu «&nbsp;<b>Préférences</b>&nbsp;».<o:p></o:p>\n"
          + "                </span>\n" + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>Cordialement;<o:p></o:p></span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <b><span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>Direction des Systèmes d'Information<o:p></o:p></span></b>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <b><span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span></b>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;mso-fareast-language:FR'>__________________________________________________<o:p></o:p></span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <span style='font-size:14.0pt;color:#1F497D;mso-fareast-language:FR'>Ceci est un email automatique, merci de ne pas répondre.<o:p></o:p></span>\n"
          + "            </p>\n" + "            <p class=MsoNormal>\n"
          + "                <o:p>&nbsp;</o:p>\n" + "            </p>\n"
          + "            <p class=MsoNormal><o:p>&nbsp;</o:p></p>\n"
          + "            <p class=MsoNormal><o:p>&nbsp;</o:p></p>\n" + "        </div>\n"
          + "    </body>\n" + "</html>", "text/html; charset=UTF-8");

      Transport.send(msg);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Permet d'envoyer un email de changement de mot de passe
   * 
   * @param recipient        : l'email destinataire
   * @param confirmationCode : le code de confirmation de changement de mot de passe
   * @param subject          : le sujet de l'email
   */
  public static void notifConfirmationCode(String recipient, String confirmationCode,
      String subject) {

    Properties props = System.getProperties();

    props.put("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.ssl.trust", "mail.airalgerie.dz");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "mail.airalgerie.dz");
    props.put("mail.smtp.port", "587");
    props.put("mail.transport.protocol", "smtp");

    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("notif.noreply@airalgerie.dz", "B28dAh@5");

      }
    });
    MimeMessage msg = new MimeMessage(session);

    try {

      msg.setFrom(new InternetAddress("notif.noreply@airalgerie.dz"));
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));
      msg.setSubject(subject, "UTF-8");
      msg.setContent("<html xmlns:v=\"urn:schemas-microsoft-com:vml\" \n"
          + "      xmlns:o=\"urn:schemas-microsoft-com:office:office\" \n"
          + "      xmlns:w=\"urn:schemas-microsoft-com:office:word\" \n"
          + "      xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\" \n"
          + "      xmlns=\"http://www.w3.org/TR/REC-html40\">\n" + "    <head>\n"
          + "        <meta http-equiv=Content-Type content=\"text/html; charset=iso-8859-1\">\n"
          + "            <meta name=Generator content=\"Microsoft Word 15 (filtered medium)\">\n"
          + "                <style><!--\n" + "                    /* Font Definitions */\n"
          + "                    @font-face\n"
          + "                    {font-family:\"Cambria Math\";\n"
          + "                     panose-1:2 4 5 3 5 4 6 3 2 4;}\n"
          + "                    @font-face\n" + "                    {font-family:Calibri;\n"
          + "                     panose-1:2 15 5 2 2 2 4 3 2 4;}\n"
          + "                    /* Style Definitions */\n"
          + "                    p.MsoNormal, li.MsoNormal, div.MsoNormal\n"
          + "                    {margin:0cm;\n" + "                     margin-bottom:.0001pt;\n"
          + "                     font-size:11.0pt;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     mso-fareast-language:EN-US;}\n"
          + "                    a:link, span.MsoHyperlink\n"
          + "                    {mso-style-priority:99;\n"
          + "                     color:#0563C1;\n"
          + "                     text-decoration:underline;}\n"
          + "                    a:visited, span.MsoHyperlinkFollowed\n"
          + "                    {mso-style-priority:99;\n"
          + "                     color:#954F72;\n"
          + "                     text-decoration:underline;}\n"
          + "                    span.EmailStyle17\n"
          + "                    {mso-style-type:personal-compose;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     color:windowtext;}\n" + "                    .MsoChpDefault\n"
          + "                    {mso-style-type:export-only;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     mso-fareast-language:EN-US;}\n"
          + "                    @page WordSection1\n"
          + "                    {size:612.0pt 792.0pt;\n"
          + "                     margin:70.85pt 70.85pt 70.85pt 70.85pt;}\n"
          + "                    div.WordSection1\n" + "                    {page:WordSection1;}\n"
          + "                    --></style>\n" + "                </head>\n"
          + "                <body lang=FR link=\"#0563C1\" vlink=\"#954F72\">\n"
          + "                    <div class=WordSection1>\n"
          + "                        <p class=MsoNormal>\n"
          + "                            <b><span style='font-size:16.0pt;mso-fareast-language:FR'>Votre code de sécurité&nbsp;:<o:p></o:p></span></b>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <b><span style='mso-fareast-language:FR'><o:p>&nbsp;</o:p></span></b>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <b><span style='font-size:24.0pt;color:#00B050;mso-fareast-language:FR'>"
          + confirmationCode + "</span></b>\n"
          + "                            <span style='font-size:24.0pt;color:#00B050;mso-fareast-language:FR'><o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Salutation,<o:p></o:p></span>\n"
          + "                        </p><p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p><p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Nous avons reçu une demande de changement de mot de passe concernant votre compte sur ERP AH.<o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Veuillez saisir le code ci-dessus afin de vérifier que vous êtes bien le titulaire du compte.<o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal><b>\n"
          + "                                <span style='font-size:14.0pt;mso-fareast-language:FR'>Remarque&nbsp;: </span></b>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'> Ce code expirera dans 5 minutes. N&#8217;attendez pas pour l&#8217;utiliser.<o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Lien&nbsp;ERP : <b><span style='color:#1F497D'><a href=\"https://erp.airalgerie.dz\">https://erp.airalgerie.dz</a></span><o:p></o:p></b></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n"
          + "                        <p class=MsoNormal style='text-align:justify'>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Cordialement;</span> \n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <b><span style='font-size:14.0pt;mso-fareast-language:FR'>Direction des Systèmes d'Information</span></b>\n"
          + "                            <b><span style='font-size:14.0pt;mso-fareast-language:FR'><o:p></o:p></span></b>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>___________________________________________</span> \n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Ceci est un email automatique, merci de ne pas répondre.</span><o:p></o:p>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n"
          + "                        <p class=MsoNormal><o:p>&nbsp;</o:p></p>\n"
          + "                    </div>\n" + "                </body>\n"
          + "                </html>", "text/html; charset=UTF-8");

      Transport.send(msg);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
  
  
  /**
   * Permet d'envoyer un email avec le code d'insciption
   * 
   * @param recipient        : l'email destinataire
   * @param inscriptionCode : le code de confirmation de changement de mot de passe
   * @param subject          : le sujet de l'email
   */
  public static void notifInscriptionCode(String recipient, String inscriptionCode,
      String subject) {

    Properties props = System.getProperties();

    props.put("mail.smtp.auth", "true");
    props.setProperty("mail.smtp.ssl.trust", "mail.airalgerie.dz");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "mail.airalgerie.dz");
    props.put("mail.smtp.port", "587");
    props.put("mail.transport.protocol", "smtp");

    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("notif.noreply@airalgerie.dz", "B28dAh@5");

      }
    });
    MimeMessage msg = new MimeMessage(session);

    try {

      msg.setFrom(new InternetAddress("notif.noreply@airalgerie.dz"));
      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));
      msg.setSubject(subject, "UTF-8");
      msg.setContent("<html xmlns:v=\"urn:schemas-microsoft-com:vml\" \n"
          + "      xmlns:o=\"urn:schemas-microsoft-com:office:office\" \n"
          + "      xmlns:w=\"urn:schemas-microsoft-com:office:word\" \n"
          + "      xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\" \n"
          + "      xmlns=\"http://www.w3.org/TR/REC-html40\">\n" + "    <head>\n"
          + "        <meta http-equiv=Content-Type content=\"text/html; charset=iso-8859-1\">\n"
          + "            <meta name=Generator content=\"Microsoft Word 15 (filtered medium)\">\n"
          + "                <style><!--\n" + "                    /* Font Definitions */\n"
          + "                    @font-face\n"
          + "                    {font-family:\"Cambria Math\";\n"
          + "                     panose-1:2 4 5 3 5 4 6 3 2 4;}\n"
          + "                    @font-face\n" + "                    {font-family:Calibri;\n"
          + "                     panose-1:2 15 5 2 2 2 4 3 2 4;}\n"
          + "                    /* Style Definitions */\n"
          + "                    p.MsoNormal, li.MsoNormal, div.MsoNormal\n"
          + "                    {margin:0cm;\n" + "                     margin-bottom:.0001pt;\n"
          + "                     font-size:11.0pt;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     mso-fareast-language:EN-US;}\n"
          + "                    a:link, span.MsoHyperlink\n"
          + "                    {mso-style-priority:99;\n"
          + "                     color:#0563C1;\n"
          + "                     text-decoration:underline;}\n"
          + "                    a:visited, span.MsoHyperlinkFollowed\n"
          + "                    {mso-style-priority:99;\n"
          + "                     color:#954F72;\n"
          + "                     text-decoration:underline;}\n"
          + "                    span.EmailStyle17\n"
          + "                    {mso-style-type:personal-compose;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     color:windowtext;}\n" + "                    .MsoChpDefault\n"
          + "                    {mso-style-type:export-only;\n"
          + "                     font-family:\"Calibri\",\"sans-serif\";\n"
          + "                     mso-fareast-language:EN-US;}\n"
          + "                    @page WordSection1\n"
          + "                    {size:612.0pt 792.0pt;\n"
          + "                     margin:70.85pt 70.85pt 70.85pt 70.85pt;}\n"
          + "                    div.WordSection1\n" + "                    {page:WordSection1;}\n"
          + "                    --></style>\n" + "                </head>\n"
          + "                <body lang=FR link=\"#0563C1\" vlink=\"#954F72\">\n"
          + "                    <div class=WordSection1>\n"
          + "                        <p class=MsoNormal>\n"
          + "                            <b><span style='font-size:16.0pt;mso-fareast-language:FR'>Votre code d'inscription &nbsp;:<o:p></o:p></span></b>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <b><span style='mso-fareast-language:FR'><o:p>&nbsp;</o:p></span></b>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <b><span style='font-size:24.0pt;color:#00B050;mso-fareast-language:FR'>"
          + inscriptionCode + "</span></b>\n"
          + "                            <span style='font-size:24.0pt;color:#00B050;mso-fareast-language:FR'><o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Salutation,<o:p></o:p></span>\n"
          + "                        </p><p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p><p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Suite à votre demande d'inscription sur ERP AH.<o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Veuillez saisir le code ci-dessus afin de vérifier que vous êtes bien le titulaire du compte.<o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal><b>\n"
          + "                                <span style='font-size:14.0pt;mso-fareast-language:FR'>Remarque&nbsp;: </span></b>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'> Ce code expirera dans 5 minutes. N&#8217;attendez pas pour l&#8217;utiliser.<o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Lien&nbsp;ERP : <b><span style='color:#1F497D'><a href=\"https://erp.airalgerie.dz\">https://erp.airalgerie.dz</a></span><o:p></o:p></b></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n"
          + "                        <p class=MsoNormal style='text-align:justify'>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Cordialement;</span> \n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <b><span style='font-size:14.0pt;mso-fareast-language:FR'>Direction des Systèmes d'Information</span></b>\n"
          + "                            <b><span style='font-size:14.0pt;mso-fareast-language:FR'><o:p></o:p></span></b>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>___________________________________________</span> \n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'><o:p></o:p></span>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='font-size:14.0pt;mso-fareast-language:FR'>Ceci est un email automatique, merci de ne pas répondre.</span><o:p></o:p>\n"
          + "                        </p>\n" + "                        <p class=MsoNormal>\n"
          + "                            <span style='mso-fareast-language:FR'><o:p>&nbsp;</o:p></span>\n"
          + "                        </p>\n"
          + "                        <p class=MsoNormal><o:p>&nbsp;</o:p></p>\n"
          + "                    </div>\n" + "                </body>\n"
          + "                </html>", "text/html; charset=UTF-8");

      Transport.send(msg);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  
  
  
  
  
  
  
  
  
  
  

}
