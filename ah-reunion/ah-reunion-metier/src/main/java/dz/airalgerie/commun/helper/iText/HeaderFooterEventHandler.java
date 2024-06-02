/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.iText;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public class HeaderFooterEventHandler implements IEventHandler {

  private final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

  private Image img;
  private Document doc;
  private String header;
  private String subHeader;
  private String title;

  private PdfHelperDocument pdf;

  protected PdfFormXObject placeholder;
  protected float side = 25;
  protected float x = 775;
  protected float y = 20;
  protected float space = 4.5f;
  protected float spaceY = 12;
  protected float descent = 3;
  protected float pagePosition ;

  private LocalDateTime dateEdition;

  public HeaderFooterEventHandler(PdfHelperDocument pdf, Document doc, Image img, String header,
      String title) {
    init(pdf, doc, img, header, null, title, true);
  }

  public HeaderFooterEventHandler(PdfHelperDocument pdf, Document doc, Image img, String header,
      String subHeader, String title, boolean isLandscape) {
    init(pdf, doc, img, header, subHeader, title, isLandscape);
  }

  public void init(PdfHelperDocument pdf, Document doc, Image img, String header, String subHeader,
      String title, boolean isLandscape) {
    this.pdf = pdf;
    this.doc = doc;
    this.img = img;
    this.header = header;
    this.title = title;
    this.subHeader = subHeader;
    placeholder = new PdfFormXObject(new Rectangle(0, 0, side, side));
    dateEdition = LocalDateTime.now();
    
    if(!isLandscape){
       x = 530;
    }
  }

  @Override
  public void handleEvent(Event event) {
    PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
    PdfDocument pdfDoc = docEvent.getDocument();
    PdfPage page = docEvent.getPage();
    PdfCanvas aboveCanvas =
        new PdfCanvas(page.newContentStreamAfter(), page.getResources(), pdfDoc);
    int pageNumber = pdfDoc.getPageNumber(page);
    Rectangle area = page.getPageSize();
    PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdfDoc);

    float coordX = area.getX() + doc.getLeftMargin();
    float coordReverseX = area.getWidth() - doc.getLeftMargin() - 100;
    float coordY = area.getTop() - 36;
    float centerX =
        ((area.getLeft() + doc.getLeftMargin()) + (area.getRight() - doc.getRightMargin())) / 2;

    Canvas canvas = new Canvas(pdfCanvas, area);

    canvas
        .showTextAligned(new Paragraph(new Text(header)).setFont(pdfDoc.getDefaultFont())
            .setFontSize(10f).setTextAlignment(TextAlignment.LEFT), coordX, coordY,
            TextAlignment.LEFT)
        .showTextAligned(new Paragraph(new Text(subHeader)).setFont(pdfDoc.getDefaultFont())
            .setFontSize(8f).setTextAlignment(TextAlignment.LEFT), coordX, coordY - spaceY,
            TextAlignment.LEFT)
        // .add(img)
        .showTextAligned(
            new Paragraph(new Text("Édité le : ")).add(dateEdition.format(DATE_TIME_FORMATTER))
                .setFont(pdfDoc.getDefaultFont()).setFontSize(8f)
                .setTextAlignment(TextAlignment.LEFT),
            coordReverseX, coordY - (spaceY * 1.5f), TextAlignment.LEFT)
        .showTextAligned(
            new Paragraph(new Text(this.title)).setFont(pdfDoc.getDefaultFont())
                .setUnderline(1f, -1.7f).setFontSize(12f).setTextAlignment(TextAlignment.CENTER),
            centerX, coordY - spaceY, TextAlignment.CENTER);
    if (!title.equals("Grand Livre 1245") && !title.equals("Grand Livre 3678")) {
      canvas.add(img);
    }
    Paragraph p = new Paragraph().add("Direction des Systèmes d'Information").setFont(pdf.getFONT())
        .setFontSize(9f);
    canvas.showTextAligned(p, coordX, y, TextAlignment.LEFT);
    p = new Paragraph().add("Page ").add(String.valueOf(pageNumber)).add(" / ")
        .setFont(pdf.getFONT()).setFontSize(9f);

    canvas.showTextAligned(p, x, y, TextAlignment.RIGHT);
    pdfCanvas.addXObject(placeholder, x + space, y - descent);

    pdfCanvas.release();
  }

  public void writeTotal() {
    Canvas canvas = new Canvas(placeholder, this.pdf);

    canvas.showTextAligned(new Paragraph().add(String.valueOf(this.pdf.getNumberOfPages()))
        .setFont(this.pdf.getFONT()).setFontSize(9f), 0, descent, TextAlignment.LEFT);
  }

  public String getSubHeader() {
    return subHeader;
  }

  public void setSubHeader(String subHeader) {
    this.subHeader = subHeader;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public PdfHelperDocument getPdf() {
    return pdf;
  }

  public void setPdf(PdfHelperDocument pdf) {
    this.pdf = pdf;
  }

  public Image getImg() {
    return img;
  }

  public void setImg(Image img) {
    this.img = img;
  }

  public Document getDoc() {
    return doc;
  }

  public void setDoc(Document doc) {
    this.doc = doc;
  }

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public LocalDateTime getDateEdition() {
    return dateEdition;
  }

  public void setDateEdition(LocalDateTime dateEdition) {
    this.dateEdition = dateEdition;
  }
}
