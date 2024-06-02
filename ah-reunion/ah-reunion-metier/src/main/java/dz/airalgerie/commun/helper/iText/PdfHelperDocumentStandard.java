/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.iText;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 */
public abstract class PdfHelperDocumentStandard extends PdfDocument {

  protected final String LOGO_PATH =
      "resources" + File.separator + "images" + File.separator + "lg.png";

  protected final PdfFont FONT;
  protected final PdfFont FONT_BOLD;

  protected String logoPathDir;

  public PdfHelperDocumentStandard(PdfWriter writer) throws IOException {
    super(writer);
    FONT = PdfFontFactory.createFont(StandardFonts.HELVETICA);
    FONT_BOLD = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
  }

  public void init(Document document, String header, String subHeader, String title,
      String logoPath) throws MalformedURLException {

    this.setDefaultPageSize(PageSize.A4);

    this.getDocumentInfo().setAuthor("Air Algérie - Direction des Systèmes d'Information");
    this.getDocumentInfo().setTitle(title);
    logoPathDir = logoPath + LOGO_PATH;
  }

  public void init2(Document document, String header, String subHeader, String title,
      String logoPath) throws MalformedURLException {

    this.setDefaultPageSize(PageSize.A4);
    this.getDocumentInfo().setAuthor("Air Algérie - Direction des Systèmes d'Information");
    this.getDocumentInfo().setTitle(title);
    logoPathDir = logoPath + LOGO_PATH;
  }


  public abstract void writeTotal();

  public PdfFont getFONT() {
    return FONT;
  }

  public PdfFont getFONT_BOLD() {
    return FONT_BOLD;
  }

  public String getLOGO_PATH() {
    return LOGO_PATH;
  }

  public String getLogoPathDir() {
    return logoPathDir;
  }

  public void setLogoPathDir(String logoPathDir) {
    this.logoPathDir = logoPathDir;
  }

}
