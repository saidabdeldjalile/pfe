/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.iText;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 */
public class PdfHelperDocument extends PdfHelperDocumentStandard {

  private HeaderFooterEventHandler wrapperEvent;

  public PdfHelperDocument(PdfWriter writer) throws IOException {
    super(writer);
  }

  @Override
  public void init(Document document, String header, String subHeader, String title,
      String logoPath) throws MalformedURLException {

    this.setDefaultPageSize(PageSize.A4.rotate());

    Image img = new Image(ImageDataFactory.create(logoPath + LOGO_PATH))
        .scaleToFit(PageSize.A4.getWidth() / 5, PageSize.A4.getHeight() / 5);
    img.setFixedPosition(PageSize.A4.getHeight() - img.getImageScaledWidth() - 25,
        PageSize.A4.getWidth() - img.getImageScaledHeight() - 15);
    this.writer.setCompressionLevel(9);

    this.wrapperEvent = new HeaderFooterEventHandler(this, document, img, header, subHeader, title, true);
    this.addEventHandler(PdfDocumentEvent.END_PAGE, wrapperEvent);

    this.getDocumentInfo().setAuthor("Air Algérie - Direction des Systèmes d'Information");
    this.getDocumentInfo().setTitle(title);
  }


  @Override
  public void init2(Document document, String header, String subHeader, String title,
      String logoPath) throws MalformedURLException {

    this.setDefaultPageSize(PageSize.A4);

    Image img = new Image(ImageDataFactory.create(logoPath + LOGO_PATH))
        .scaleToFit(PageSize.A4.getWidth() / 5, PageSize.A4.getHeight() / 5);
    img.setFixedPosition(PageSize.A4.getWidth() - img.getImageScaledWidth() - 25,
        PageSize.A4.getHeight() - img.getImageScaledHeight() - 15);
    this.writer.setCompressionLevel(9);

    this.wrapperEvent =
        new HeaderFooterEventHandler(this, document, img, header, subHeader, title, false);
    this.addEventHandler(PdfDocumentEvent.END_PAGE, wrapperEvent);

    this.getDocumentInfo().setAuthor("Air Algérie - Direction des Systèmes d'Information");
    this.getDocumentInfo().setTitle(title);
  }

  @Override
  public void writeTotal() {
    this.getWrapperEvent().writeTotal();
  }

  public HeaderFooterEventHandler getWrapperEvent() {
    return wrapperEvent;
  }

  public void setWrapperEvent(HeaderFooterEventHandler wrapperEvent) {
    this.wrapperEvent = wrapperEvent;
  }

}
