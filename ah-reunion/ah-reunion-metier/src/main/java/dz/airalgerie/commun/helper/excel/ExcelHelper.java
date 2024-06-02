/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.excel;

import java.awt.Color;
import java.math.BigDecimal;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;

/**
 *
 */
public class ExcelHelper extends SXSSFWorkbook {

  SXSSFWorkbook workbook;

  CellStyle headerStyle;
  CellStyle contentStyle;

  public ExcelHelper() {
    workbook = new SXSSFWorkbook(100);

    // initHeaderStyle();
    // initContentStyle();
  }

  /**
   * Permet d'avoir le style pour les cellules par défaut.
   *
   * @param workbook
   * @param bold
   * @param color
   * 
   * @return
   */
  public static CellStyle initStyle(SXSSFWorkbook workbook, boolean bold, Color color) {
    CellStyle style = workbook.createCellStyle();

    return style;
  }

  /**
   * Permet d'avoir le style pour les cellules du header.
   *
   * @param workbook
   * 
   * @return
   */
  public static CellStyle initHeaderStyle(SXSSFWorkbook workbook) {
    XSSFFont font = (XSSFFont) workbook.createFont();
    font.setColor(HSSFColorPredefined.BLACK.getIndex());
    font.setBold(true);

    CellStyle style = initStyle(workbook, true, Color.BLACK);

    style.setFont(font);
    style.setBorderBottom(BorderStyle.THIN);

    return style;
  }

  /**
   * Permet d'avoir le style pour les cellules du footer.
   *
   * @param workbook
   * 
   * @return
   */
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

  /**
   * Permet d'avoir le style pour les cellules du corps du tableau.
   *
   * @param workbook
   * 
   * @return
   */
  public static CellStyle initContentStyle(SXSSFWorkbook workbook) {
    XSSFFont font = (XSSFFont) workbook.createFont();
    font.setColor(HSSFColorPredefined.BLACK.getIndex());

    CellStyle style = initStyle(workbook, false, Color.BLACK);

    style.setFont(font);

    return style;
  }

  /**
   * Permet d'avoir une cellule avec un format spécifique.
   *
   * @param row             Ligne de la cellule.
   * @param style           Style à donner à la cellule.
   * @param position        Colonne à laquelle la cellule sera attribuée.
   * @param value           Valeur de la cellule.
   * @param cellType        Type de valeur de la cellule.
   * @param textColor       Couleur du texte.
   * @param isBold          Permet de déterminer si le texte est en gras.
   * @param background      Couleur de fond de la cellule.
   * @param hasBorderBottom Permet de déterminer si la cellule est souligée en bas.
   * 
   * @return Une nouvelle cellule.
   */
  public static Cell createStringCell(Row row, CellStyle style, int position, Object value,
      CellType cellType, Color textColor, boolean isBold, short background,
      boolean hasBorderBottom) {

    Cell cell = row.createCell(position);

    cell.setCellType(cellType);
    if (cellType == CellType.NUMERIC) {
      Double doubleValue;
      if (value instanceof BigDecimal) {
        doubleValue = ((BigDecimal) value).doubleValue();
      } else {
        try {
          doubleValue =
              Double.parseDouble(value.toString().replaceAll("[^0-9.,]", "").replace(",", "."));
        } catch (NumberFormatException e) {
          throw e;
        }
      }
      cell.setCellValue(doubleValue);
    } else {
      cell.setCellValue(value.toString());
    }

    cell.setCellStyle(style);

    return cell;
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
