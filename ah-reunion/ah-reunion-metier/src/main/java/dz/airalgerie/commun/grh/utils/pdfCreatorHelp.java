/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PatternColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPatternPainter;
import com.itextpdf.text.pdf.PdfWriter;
import dz.airalgerie.grh.model.entities.gp.Gp;
import dz.airalgerie.grh.model.entities.gp.PersonnelLite;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Administrateur
 */
public class pdfCreatorHelp {

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

  public static PdfPCell createCellForHeader(String text, Font font) {

    PdfPCell cell = new PdfPCell();
    Paragraph ph = new Paragraph(text);
    ph.setFont(font);
    ph.setAlignment(Element.ALIGN_CENTER);
    cell.addElement(ph);

    return cell;
  }

  public static Paragraph para(String text, Font font, int alignement) {

    Paragraph p = new Paragraph();
    p.setAlignment(alignement);
    p.setFont(font);
    p.add(text);

    return p;

  }

  public static String getFormatDateForFret(int dateNumeric) {

    Date date = new Date();
    date.setYear(Integer.parseInt(("" + dateNumeric).substring(0, 4)) - 1900);
    date.setMonth(Integer.parseInt(("" + dateNumeric).substring(4, 6)) - 1);
    date.setDate(1);

    return new SimpleDateFormat("yyyy-MM-dd").format(date);

  }

  public static void createPDF(PersonnelLite pers, Gp gp) {

    try {
      Document document = new Document();
      Font font = new Font(Font.FontFamily.HELVETICA, 16.0f, Font.BOLD, BaseColor.BLACK);
      Font font12 = new Font(Font.FontFamily.HELVETICA, 12.0f, Font.BOLD, BaseColor.BLACK);
      Font font10 = new Font(Font.FontFamily.HELVETICA, 10.0f, Font.BOLD, BaseColor.BLACK);
      Font font9 = new Font(Font.FontFamily.HELVETICA, 9.0f, Font.NORMAL, BaseColor.BLACK);
      FacesContext context = FacesContext.getCurrentInstance();
      ServletContext scontext = (ServletContext) context.getExternalContext().getContext();
      String rootpath = scontext.getRealPath("/");
      File tempFile = new File(rootpath + "resources" + File.separator + "PDF" + File.separator
          + gp.getMatricule() + gp.getNumGp() + ".pdf");
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(tempFile));
      document.open();
      // document.add(para(" \n Demande de transport", font, Element.ALIGN_CENTER));
      document.add(para(" \n \n \n \n", font, Element.ALIGN_CENTER));
      Paragraph ss50 = para(" \n \n \n \n Date limite de validité : ", font12, Element.ALIGN_RIGHT);
      ss50.setFont(font9);
      ss50.add("" + gp.getDateLimit().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
      document.add(ss50);
      Paragraph ss51 = para("N° : ", font12, Element.ALIGN_LEFT);
      ss51.setFont(font9);
      ss51.add("" + gp.getNumGp());
      ss51.setFont(font12);
      ss51.add("           Type : ");
      ss51.setFont(font9);
      ss51.add("" + gp.getType());
      document.add(ss51);
      Paragraph ss = para("\n NOM ET PRENOM DU DEMANDEUR : ", font10, Element.ALIGN_LEFT);
      ss.setFont(font9);
      ss.add(pers.getName() + " " + pers.getPrenom());
      document.add(ss);
      Paragraph ss1 = para("\n EMPLOI OU FONCTION : ", font10, Element.ALIGN_LEFT);
      ss1.setFont(font9);
      ss1.add(pers.getPosteT().getLibelle());
      document.add(ss1);
      Paragraph ss2 = para("\n SERVICE ET LIEU D'AFFECTATION : ", font10, Element.ALIGN_LEFT);
      ss2.setFont(font9);
      ss2.add(pers.getDirLibelle());
      document.add(ss2);
      Paragraph ss3 = para("\n DATE D'ENTREE A LA COMPAGNIE : ", font10, Element.ALIGN_LEFT);
      ss3.setFont(font9);
      ss3.add("" + pers.getDateEntree().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
      document.add(ss3);
      Paragraph ss4 = para("\n MATRICULE COMPAGNIE : ", font10, Element.ALIGN_LEFT);
      ss4.setFont(font9);
      ss4.add("" + pers.getMatricule());
      document.add(ss4);
      Paragraph ss5 = para("\n PERSONNES A TRANSPORTER : \n  ", font10, Element.ALIGN_CENTER);
      ss5.setFont(font9);
      document.add(ss5);
      float[] columnWidths = {2, 2, 3, 3};
      PdfPTable table = new PdfPTable(columnWidths);
      table.setWidthPercentage(100);

      // Create header
      table.addCell(createCellForHeader("Noms \n  ", font9));
      table.addCell(createCellForHeader("Prénoms \n", font9));
      table.addCell(createCellForHeader("Date de naissance \n", font9));
      table.addCell(createCellForHeader("Parenté avec le demandeur \n", font9));

      table.completeRow();

      for (int i = 0; i < gp.getListGp().size(); i++) {
        table.addCell(createCellForBody("\n" + gp.getListGp().get(i).getLastname(), font9, false));
        table.addCell(createCellForBody("\n" + gp.getListGp().get(i).getName(), font9, false));
        table.addCell(createCellForBody("\n         "
            + gp.getListGp().get(i).getDateNaissance().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
            font9, false));
        table.addCell(
            createCellForBody("\n              " + gp.getListGp().get(i).getLien(), font9, false));
        table.completeRow();
      }
      document.add(table);
      Paragraph ss11 = para("\n \n PARCOURS DEMANDES :", font10, Element.ALIGN_CENTER);
      document.add(ss11);
      Paragraph ss12 = para("\n ALLER :", font10, Element.ALIGN_LEFT);
      ss12.setFont(font9);
      ss12.add(gp.getAller());
      document.add(ss12);
      Paragraph ss13 = para("\n RETOUR :", font10, Element.ALIGN_LEFT);
      ss13.setFont(font9);
      ss13.add(gp.getRetour());
      document.add(ss13);
      Paragraph ss14 = para("\n Observation :", font10, Element.ALIGN_CENTER);
      document.add(ss14);
      Paragraph ss15 = para("\n ", font9, Element.ALIGN_LEFT);
      document.add(ss15);
      PdfContentByte over = writer.getDirectContent();
      BaseFont bf = BaseFont.createFont();
      over.beginText();
      over.setFontAndSize(bf, 14);
      over.moveText(450, 120);
      over.showText("SIGNATURE");
      over.endText();
      // Image image = Image.getInstance(rootpath + "resources\\images\\logo_md.png");
      Image image = Image.getInstance(
          rootpath + "resources" + File.separator + "images" + File.separator + "GP177.png");
      PdfPatternPainter img_pattern =
          over.createPattern(image.getScaledWidth(), image.getScaledHeight());
      image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
      float x = ((PageSize.A4.getWidth() - image.getScaledWidth()) / 2) + 50;
      float y = (PageSize.A4.getHeight() - image.getScaledHeight()) / 4;
      image.setAbsolutePosition(0, 0);
      // image.setRotationDegrees(45);
      img_pattern.addImage(image);
      BaseColor color = new PatternColor(img_pattern);
      PdfGState state = new PdfGState();
      // state.setFillOpacity(0.3f);
      over.setGState(state);
      over.addImage(image);

      Image codeB = Image.getInstance(rootpath + "resources" + File.separator + "barcode"
          + File.separator + gp.getCode() + ".png");
      codeB.setAbsolutePosition(0, 0);
      over.addImage(codeB);

      document.close();
      System.out.println("Awesome PDF just got created.");
    } catch (FileNotFoundException ex) {
      Logger.getLogger(pdfCreatorHelp.class.getName()).log(Level.SEVERE, null, ex);
    } catch (DocumentException ex) {
      Logger.getLogger(pdfCreatorHelp.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(pdfCreatorHelp.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public static void createPDF1(PersonnelLite pers, Gp gp,int count) {

    try {
      Document document = new Document();
      Font font = new Font(Font.FontFamily.HELVETICA, 16.0f, Font.BOLD, BaseColor.BLACK);
      Font font12 = new Font(Font.FontFamily.HELVETICA, 12.0f, Font.BOLD, BaseColor.BLACK);
      Font font10 = new Font(Font.FontFamily.HELVETICA, 10.0f, Font.BOLD, BaseColor.BLACK);
      Font font9 = new Font(Font.FontFamily.HELVETICA, 9.0f, Font.NORMAL, BaseColor.BLACK);
      FacesContext context = FacesContext.getCurrentInstance();
      ServletContext scontext = (ServletContext) context.getExternalContext().getContext();
      String rootpath = scontext.getRealPath("/");
      File tempFile = new File(rootpath + "resources" + File.separator + "PDF" + File.separator
          + gp.getMatricule() + gp.getNumGp() + ".pdf");
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(tempFile));
      document.open();
      // document.add(para(" \n Demande de transport", font, Element.ALIGN_CENTER));
      document.add(para(" \n \n \n \n", font, Element.ALIGN_CENTER));
      Paragraph ss50 = para(" \n \n \n \n Date limite de validité : ", font12, Element.ALIGN_RIGHT);
      ss50.setFont(font9);
      if (gp.getDateLimit() != null) {
        ss50.add("" + gp.getDateLimit().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
      }
      document.add(ss50);
      Paragraph numGp = para("N° : ", font12, Element.ALIGN_LEFT);
      numGp.setFont(font9);
      int num;
      if (Year.now().getValue() == gp.getExercice()) {
         num = gp.getNumGp() - count;
      } else {
         num = gp.getNumGp();  
      }
      numGp.add("" + num + "/" + pers.getDirLibelle().split("\\s+")[0] + "/"
          + gp.getExercice());
      numGp.setFont(font12);
      numGp.add("           TYPE : ");
      numGp.setFont(font9);
      numGp.add("" + gp.getType());
      numGp.setFont(font12);
      numGp.add("           CLASS : ");
      numGp.setFont(font9);
      if (gp.isDroitFirst()) {
        numGp.add("FIRST/ECONOMY");
      } else {
        numGp.add("ECONOMY");
      }
      document.add(numGp);
      Paragraph ss = para("\n NOM ET PRENOMS DU DEMANDEUR : ", font10, Element.ALIGN_LEFT);
      ss.setFont(font9);
      ss.add(pers.getNom());
      document.add(ss);
      Paragraph ss1 = para("\n EMPLOI OU FONCTION : ", font10, Element.ALIGN_LEFT);
      ss1.setFont(font9);
      ss1.add(pers.getPosteT().getLibelle());
      document.add(ss1);
      Paragraph ss2 = para("\n SERVICE ET LIEU D'AFFECTATION : ", font10, Element.ALIGN_LEFT);
      ss2.setFont(font9);
      ss2.add(pers.getDirLibelle());
      document.add(ss2);
      Paragraph ss3 = para("\n DATE D'ENTREE A LA COMPAGNIE : ", font10, Element.ALIGN_LEFT);
      ss3.setFont(font9);
      ss3.add("" + pers.getDateEntree().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
      document.add(ss3);
      Paragraph ss4 = para("\n MATRICULE COMPAGNIE : ", font10, Element.ALIGN_LEFT);
      ss4.setFont(font9);
      ss4.add("" + pers.getMatricule());
      document.add(ss4);
      Paragraph ss5 = para("\n PERSONNES A TRANSPORTER : \n  ", font10, Element.ALIGN_CENTER);
      ss5.setFont(font9);
      document.add(ss5);
      float[] columnWidths = {4, 0, 3, 3};
      PdfPTable table = new PdfPTable(columnWidths);
      table.setWidthPercentage(100);

      // Create header
      table.addCell(createCellForHeader("Noms \n  ", font9));
      table.addCell(createCellForHeader("Prénoms \n", font9));
      table.addCell(createCellForHeader("Date de naissance \n", font9));
      table.addCell(createCellForHeader("Parenté avec le demandeur \n", font9));

      table.completeRow();

      for (int i = 0; i < gp.getListGp().size(); i++) {
        if (gp.getListGp().get(i).getLastname() != null && !gp.getListGp().get(i).getLastname().isEmpty()) {
          if (gp.getListGp().get(i).getNjfille() != null && !gp.getListGp().get(i).getNjfille().isEmpty()) {
            table.addCell(
                createCellForBody("\n" +gp.getListGp().get(i).getLastname()+ " " + gp.getListGp().get(i).getName() + " Née "+  gp.getListGp().get(i).getNjfille(), font9, false));
          } else {
            table.addCell(
                createCellForBody("\n" +gp.getListGp().get(i).getLastname() + " " +gp.getListGp().get(i).getName(), font9, false));
          }
        } else if (gp.getListGp().get(i).getNjfille() != null && !gp.getListGp().get(i).getNjfille().isEmpty()) {
            table.addCell(
                createCellForBody("\n" +gp.getListGp().get(i).getName() + " Née "+  gp.getListGp().get(i).getNjfille(), font9, false));
        } else {
          table.addCell(createCellForBody("\n N/A ", font9, false));
        }
        table.addCell(createCellForBody("\n", font9, false));
        if (gp.getListGp().get(i).getDateNaissance() != null) {
          table.addCell(createCellForBody("\n         "
              + gp.getListGp().get(i).getDateNaissance().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
              font9, false));
        } else {
          table.addCell(createCellForBody("\n     N/A ", font9, false));
        }
        table.addCell(
            createCellForBody("\n              " + gp.getListGp().get(i).getLien(), font9, false));
        table.completeRow();
      }
      document.add(table);
      Paragraph ss11 = para("\n \n PARCOURS DEMANDES :", font10, Element.ALIGN_CENTER);
      document.add(ss11);
      Paragraph ss12 = para("\n ALLER :", font10, Element.ALIGN_CENTER);
      ss12.setFont(font9);
      ss12.add(gp.getAller());
      document.add(ss12);
      if(gp.getRetour() != null && !gp.getRetour().isEmpty()){
        Paragraph ss13 = para("\n RETOUR :", font10, Element.ALIGN_CENTER);
        ss13.setFont(font9);
        ss13.add(gp.getRetour());
        document.add(ss13);
      }
      Paragraph ss14 = para("\n Observation :", font10, Element.ALIGN_CENTER);
      document.add(ss14);
      Paragraph ss15 = para("\n ", font9, Element.ALIGN_LEFT);
      ss15.add(gp.getObservation());
      document.add(ss15);
      PdfContentByte over = writer.getDirectContent();
      BaseFont bf = BaseFont.createFont();
      over.beginText();
      over.setFontAndSize(bf, 14);
      over.moveText(450, 120);
      // over.showText("SIGNATURE");
      over.endText();
      // Image image = Image.getInstance(rootpath + "resources\\images\\logo_md.png");
      Image image = Image.getInstance(
          rootpath + "resources" + File.separator + "images" + File.separator + "GP177.png");
      PdfPatternPainter img_pattern =
          over.createPattern(image.getScaledWidth(), image.getScaledHeight());
      image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
      float x = ((PageSize.A4.getWidth() - image.getScaledWidth()) / 2) + 50;
      float y = (PageSize.A4.getHeight() - image.getScaledHeight()) / 4;
      image.setAbsolutePosition(0, 0);
      // image.setRotationDegrees(45);
      img_pattern.addImage(image);
      BaseColor color = new PatternColor(img_pattern);
      PdfGState state = new PdfGState();
      // state.setFillOpacity(0.3f);
      over.setGState(state);
      over.addImage(image);

      // Image image22 = Image.getInstance(image2);
      // image22.setAbsolutePosition(420, 30);
      // image22.scaleToFit(150, 150);
      // over.addImage(image22);

      File tmpDir = new File(rootpath + "resources" + File.separator + "barcode" + File.separator
          + gp.getCode() + ".png");
      boolean exists = tmpDir.exists();

      if (exists == false) {
        try {
          createQRCode(gp.getCode(), rootpath + "resources" + File.separator + "barcode"
              + File.separator + gp.getCode() + ".png", 400, 400);
        } catch (WriterException ex) {
          Logger.getLogger(pdfCreatorHelp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
          Logger.getLogger(pdfCreatorHelp.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      try {
        Image codeB = Image.getInstance(rootpath + "resources" + File.separator + "barcode"
            + File.separator + gp.getCode() + ".png");
        codeB.setAbsolutePosition(0, 0);
        codeB.scaleToFit(150, 150);
        over.addImage(codeB);
      } catch (DocumentException | IOException e) {
        e.printStackTrace();
      }
      PdfContentByte overS = writer.getDirectContent();
      BaseFont bfS = BaseFont.createFont();
      overS.beginText();
      overS.setFontAndSize(bfS, 14);
      overS.moveText(37, 140);
      overS.showText(gp.getCode());
      overS.endText();
      document.close();

    } catch (FileNotFoundException ex) {
      Logger.getLogger(pdfCreatorHelp.class.getName()).log(Level.SEVERE, null, ex);
    } catch (DocumentException ex) {
      Logger.getLogger(pdfCreatorHelp.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(pdfCreatorHelp.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public static void createQRCode(String barCodeData, String filePath, int height, int width)
      throws WriterException, IOException {
    BitMatrix matrix =
        new MultiFormatWriter().encode(barCodeData, BarcodeFormat.QR_CODE, width, height);
    try (FileOutputStream out = new FileOutputStream(filePath)) {
      MatrixToImageWriter.writeToStream(matrix, "png", out);
    }
  }

}
