/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.iText;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.io.File;
import java.io.IOException;

/**
 * Classe utilitaire pour les objets d'iText v7.
 */
public class PdfUtils {

  /**
   * Permet la creation d'une cellule simple d'un tableau.
   *
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * 
   * @return
   */
  public static Cell createSimpleCell(String content, int colspan, TextAlignment alignment) {
    Cell cell = new Cell(1, colspan).add(new Paragraph(content)).setTextAlignment(alignment)
        .setVerticalAlignment(VerticalAlignment.MIDDLE);
    return cell;
  }

  /**
   * Permet la creation d'une cellule simple d'un tableau.
   *
   * @param content   Contenu de la cellule.
   * @param rowspan   Nombre de ligne réservées pour la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * 
   * @return
   */
  public static Cell createSimpleCell(String content, int rowspan, int colspan,
      TextAlignment alignment) {
    Cell cell = new Cell(rowspan, colspan).add(new Paragraph(content)).setTextAlignment(alignment)
        .setVerticalAlignment(VerticalAlignment.MIDDLE);
    return cell;
  }

  /**
   * Permet la creation d'une cellule d'un tableau.
   *
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * @param wrappable Si la cellule est wrappable.
   * 
   * @return
   */
  private static Cell createBorderlessCell(String content, int colspan, TextAlignment alignment,
      boolean wrappable) {
    Cell cell =
        createSimpleCell(content, colspan, alignment).setBorder(Border.NO_BORDER).setFontSize(7.5f);
    if (wrappable) {
      cell.setHeight(12f);
    }
    return cell;
  }

  /**
   * Permet la création d'une cellule pour l'en-tête d'un tableau.
   *
   * @param pdf       Document en cours d'utilisation.
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * 
   * @return
   */
  public static Cell createHeaderCell(PdfHelperDocumentStandard pdf, String content, int colspan,
      TextAlignment alignment) {
    return createBorderlessCell(content, colspan, alignment, false).setFontSize(9F)
        .setFont(pdf.getFONT_BOLD()).setBorderBottom(new SolidBorder(ColorConstants.BLACK, 1));
  }

  /**
   * Permet la création d'une cellule pour l'en-tête d'un tableau.
   *
   * @param pdf       Document en cours d'utilisation.
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * @param wrappable Si la cellule est wrappable.
   * 
   * @return
   */
  public static Cell createHeaderCell(PdfHelperDocumentStandard pdf, String content, int colspan,
      TextAlignment alignment, boolean wrappable) {
    return createBorderlessCell(content, colspan, alignment, wrappable).setFontSize(9F)
        .setFont(pdf.getFONT_BOLD()).setBorderBottom(new SolidBorder(ColorConstants.BLACK, 1));
  }

  /**
   * Permet la création d'une cellule pour le footer d'un tableau.
   *
   * @param pdf       Document en cours d'utilisation.
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * 
   * @return
   */
  public static Cell createFooterCell(PdfHelperDocumentStandard pdf, String content, int colspan,
      TextAlignment alignment) {
    return createBorderlessCell(content, colspan, alignment, false).setFontSize(10F)
        .setBorderTop(new SolidBorder(ColorConstants.BLACK, 1))
        .setBorderBottom(new SolidBorder(ColorConstants.BLACK, 1)).setMinHeight(20)
        .setFont(pdf.getFONT_BOLD());
  }

  /**
   * Permet la création d'une cellule pour le corps d'un tableau.
   *
   * @param pdf       Document en cours d'utilisation.
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * 
   * @return
   */
  public static Cell createContentCell(PdfHelperDocumentStandard pdf, String content, int colspan,
      TextAlignment alignment) {
    return createBorderlessCell(content, colspan, alignment, false).setFont(pdf.getFONT())
        .setBorderBottom(new SolidBorder(ColorConstants.LIGHT_GRAY, 0.6f));
  }

  /**
   * Permet la création d'une cellule pour le corps d'un tableau.
   *
   * @param pdf       Document en cours d'utilisation.
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * @param wrappable Si la cellule est wrappable.
   * 
   * @return
   */
  public static Cell createContentCell(PdfHelperDocumentStandard pdf, String content, int colspan,
      TextAlignment alignment, boolean wrappable) {
    return createBorderlessCell(content, colspan, alignment, wrappable).setFont(pdf.getFONT())
        .setBorderBottom(new SolidBorder(ColorConstants.LIGHT_GRAY, 0.6f));
  }

  /**
   * Permet la création d'une cellule sans bordure.
   *
   * @param pdf       Document en cours d'utilisation.
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * 
   * @return
   */
  public static Cell createInlineCell(PdfHelperDocumentStandard pdf, String content, int colspan,
      TextAlignment alignment) {
    return createBorderlessCell(content, colspan, alignment, false).setFont(pdf.getFONT())
        .setBorderBottom(Border.NO_BORDER);
  }

  /**
   * Permet la création d'une cellule simple.
   *
   * @param pdf       Document en cours d'utilisation.
   * @param content   Contenu de la cellule.
   * @param colspan   Nombre de colonne réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * 
   * @return
   */
  public static Cell createSimpleCell(PdfHelperDocumentStandard pdf, String content, int colspan,
      TextAlignment alignment) {
    return createSimpleCell(content, colspan, alignment).setFont(pdf.getFONT());
  }

  /**
   * Permet la création d'une cellule simple.
   *
   * @param pdf       Document en cours d'utilisation.
   * @param content   Contenu de la cellule.
   * @param rowspan   Nombre de lignes réservées pour la cellule.
   * @param colspan   Nombre de colonnes réservées pour la cellule.
   * @param alignment Alignement du contenu.
   * 
   * @return
   */
  public static Cell createSimpleCell(PdfHelperDocumentStandard pdf, String content, int rowspan,
      int colspan, TextAlignment alignment) {
    return createSimpleCell(content, rowspan, colspan, alignment).setFont(pdf.getFONT());
  }

  /**
   * Permet de mettre l'image sur le PDF
   *
   * @param fileName
   * @param resourcesDirectoryPath
   * 
   * @return
   * 
   * @throws IOException
   */
  public static String addLogoToPdf(String fileName, String resourcesDirectoryPath)
      throws IOException {

    String outputFile = fileName.replaceAll(".pdf", "_GL.pdf");
    String inputFile = fileName;

    Image img = new Image(ImageDataFactory.create(resourcesDirectoryPath + "resources"
        + File.separator + "images" + File.separator + "lg.png"))
        .scaleToFit(PageSize.A4.getWidth() / 5, PageSize.A4.getHeight() / 5);
    img.setFixedPosition(PageSize.A4.getHeight() - img.getImageScaledWidth() - 25,
        PageSize.A4.getWidth() - img.getImageScaledHeight() - 15);

    PdfDocument pdfDoc = new PdfDocument(new PdfReader(inputFile), new PdfWriter(outputFile));
    Document document = new Document(pdfDoc);
    for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {

      PdfPage page = pdfDoc.getPage(i);
      Rectangle area = page.getPageSize();
      PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdfDoc);
      Canvas canvas = new Canvas(pdfCanvas, area);
      canvas.add(img);
      canvas.close();
    }
    document.close();

    return outputFile;
  }

}
