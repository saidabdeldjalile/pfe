/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author KEHLI Moussab Amine
 */
public class Util {

  @Inject
  private Logger log;

  /**
   * Permet de formater BigDecimal
   * 
   * @param input
   * @return
   */
  public static BigDecimal formatBigDecimal(BigDecimal input) {

    BigDecimal output;
    String tempValue = "";
    String firstPart = "";
    String secondPart = "";

    tempValue = "" + input;
    firstPart = tempValue.substring(0, tempValue.indexOf("."));
    secondPart = tempValue.substring(tempValue.indexOf("."), tempValue.indexOf(".") + 6);
    output = new BigDecimal(firstPart + secondPart);

    return output;
  }

  /**
   * Permet de formater la date pour les requête sql
   * 
   * @param date
   * @return
   */
  public static String formatDateForSQL(Date date) {

    String output = new SimpleDateFormat("yyyy-MM-01").format(date);

    return output;
  }

  /**
   * Permet de formater la date en format MMMM yyyy
   * 
   * @param date
   * @return
   */
  public static String formatDateForReport(Date date) {

    String output = new SimpleDateFormat("MMMM yyyy", Locale.FRANCE).format(date).toUpperCase();

    return output;
  }

  /**
   * Permet de créer une Cell pour le header du tableau des taux de change
   * 
   * @param text
   * @param font
   * @return
   */
  public static PdfPCell createCellForHeader(String text, Font font) {

    PdfPCell cell = new PdfPCell();
    Paragraph ph = new Paragraph(text);
    ph.setFont(font);
    ph.setAlignment(Element.ALIGN_CENTER);
    cell.addElement(ph);

    return cell;
  }

  /**
   * Permet de créer une Cell pour le body du tableau taux de change
   * 
   * @param text
   * @param font
   * @param pushRight
   * @return
   */
  public static PdfPCell createCellForBody(String text, Font font, boolean pushRight) {

    PdfPCell cell = new PdfPCell();
    Paragraph ph = new Paragraph(text);
    ph.setFont(font);
    if (pushRight) {
      ph.setAlignment(Element.ALIGN_RIGHT);
    }
    cell.setBorder(Rectangle.NO_BORDER);
    cell.setPadding(0);
    cell.setPaddingBottom(-3);
    cell.addElement(ph);

    return cell;
  }

  /**
   * Permet de créer un paragraph
   * 
   * @param text
   * @param font
   * @param alignement
   * @return
   */
  public static Paragraph createParagraph(String text, Font font, int alignement) {

    Paragraph p = new Paragraph();
    p.setAlignment(alignement);
    p.setFont(font);
    p.add(text);

    return p;

  }

  /**
   * Permet de formater la date en foramt dd-MM-yyyy au dd-MM-yyyy
   * 
   * @param date
   * @return
   */
  public static String getPeriodeForAgencesPDF(Date date) {
    String output = "";

    Date dateBegin = new Date();
    dateBegin.setDate(16);
    dateBegin.setYear(date.getYear());
    dateBegin.setMonth(date.getMonth() + 1);

    Date dateEnd = new Date();
    dateEnd.setDate(15);
    dateEnd.setYear(date.getYear());
    dateEnd.setMonth(date.getMonth() + 2);

    output = (new SimpleDateFormat("dd-MM-yyyy").format(dateBegin)) + " au "
        + (new SimpleDateFormat("dd-MM-yyyy").format(dateEnd));

    return output;
  }

  /**
   * Permet de formater la date en format Numeric yyyydd
   * 
   * @param date
   * @return
   */
  public static int getNumericDate(Date date) {

    int numericDate = Integer.parseInt("" + new SimpleDateFormat("yyyyMM").format(date));

    return numericDate;
  }

  /**
   * Permet de formater la date por la requete sur la base Fret
   * 
   * @param dateNumeric
   * @return
   */
  public static String getFormatDateForFret(int dateNumeric) {

    Date date = new Date();
    date.setYear(Integer.parseInt(("" + dateNumeric).substring(0, 4)) - 1900);
    date.setMonth(Integer.parseInt(("" + dateNumeric).substring(4, 6)) - 1);
    date.setDate(1);

    return new SimpleDateFormat("yyyy-MM-dd").format(date);

  }

  /**
   * Permet de charger le fichier des propriétés de configuration.
   * 
   * @return Les propriétés.
   */
  public static Properties loadApplicationFile() {

    Properties prop = new Properties();
    Util util = new Util();
    try {
      InputStream resourceAsStream =
          util.getClass().getClassLoader().getResourceAsStream("application.properties");
      if (resourceAsStream != null) {
        prop.load(resourceAsStream);
      }
    } catch (IOException e) {
      util.log.error("Error on loading application file", e);
    }
    return prop;
  }

}
