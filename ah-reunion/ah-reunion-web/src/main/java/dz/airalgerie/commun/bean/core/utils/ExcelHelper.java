/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean.core.utils;

import java.awt.Color;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;

/**
 *
 * @author kehli
 */
public class ExcelHelper extends SXSSFWorkbook {

  SXSSFWorkbook workbook;

  CellStyle headerStyle;
  CellStyle contentStyle;

  public ExcelHelper() {
    workbook = new SXSSFWorkbook(100);
  }

  public static CellStyle initStyle(SXSSFWorkbook workbook, boolean bold, Color color) {
    CellStyle style = workbook.createCellStyle();

    return style;
  }

  public static CellStyle initHeaderStyle(SXSSFWorkbook workbook) {
    XSSFFont font = (XSSFFont) workbook.createFont();
    font.setColor(HSSFColorPredefined.BLACK.getIndex());
    font.setBold(true);

    CellStyle style = initStyle(workbook, true, Color.BLACK);

    style.setFont(font);
    style.setBorderBottom(BorderStyle.THIN);

    return style;
  }

  public static CellStyle initFooterStyle(SXSSFWorkbook workbook) {
    XSSFFont font = (XSSFFont) workbook.createFont();
    font.setColor(HSSFColorPredefined.BLACK.getIndex());
    font.setBold(true);

    CellStyle style = initStyle(workbook, true, Color.BLACK);

    style.setFont(font);
    style.setBorderTop(BorderStyle.THIN);
    style.setBorderBottom(BorderStyle.THIN);

    return style;
  }

  public static CellStyle initContentStyle(SXSSFWorkbook workbook) {
    XSSFFont font = (XSSFFont) workbook.createFont();
    font.setColor(HSSFColorPredefined.BLACK.getIndex());

    CellStyle style = initStyle(workbook, false, Color.BLACK);

    style.setFont(font);

    return style;
  }

  public SXSSFWorkbook getWorkbook() {
    return workbook;
  }

  public void setWorkbook(SXSSFWorkbook workbook) {
    this.workbook = workbook;
  }

  public CellStyle getHeaderStyle() {
    return headerStyle;
  }

  public void setHeaderStyle(CellStyle headerStyle) {
    this.headerStyle = headerStyle;
  }

  public CellStyle getContentStyle() {
    return contentStyle;
  }

  public void setContentStyle(CellStyle contentStyle) {
    this.contentStyle = contentStyle;
  }

}
