/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.utils;

import dz.airalgerie.commun.utils.DataSourceReporting;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author AGHA Riadh
 */
public class ReportGeneratorBean implements Serializable {

  /**
   * ************************************************************************* Pour la visualisation
   * PDF ************************************************************************
   */
  public static String printEtat(InputStream url, Map parametre, Connection connection, String req)
      throws IOException, JRException, SQLException {
    try {
      ResultSet rs = DataSourceReporting.executeQuery(req, connection);
      JRDataSource dataSource = new JRResultSetDataSource(rs);
      FacesContext context = FacesContext.getCurrentInstance();
      HttpServletResponse response =
          (HttpServletResponse) context.getExternalContext().getResponse();
      ServletOutputStream servletOutputStream = response.getOutputStream();
      context.responseComplete();
      response.setContentType("application/pdf");
      JasperRunManager.runReportToPdfStream(url, servletOutputStream, parametre, dataSource);
      context.responseComplete();
      connection.close();
      rs.close();
      servletOutputStream.flush();
      servletOutputStream.close();

    } catch (IOException | SQLException | JRException ex) {
      Logger.getLogger(ReportGeneratorBean.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      connection.close();

    }

    return null;
  }

  public static String printEtat(InputStream url, Map parametre, Connection connection)
      throws IOException, JRException, SQLException {
    try {
      FacesContext context = FacesContext.getCurrentInstance();
      HttpServletResponse response =
          (HttpServletResponse) context.getExternalContext().getResponse();
      ServletOutputStream servletOutputStream = response.getOutputStream();
      context.responseComplete();
      response.setContentType("application/pdf");
       JasperRunManager.runReportToPdfStream(url, servletOutputStream, parametre, connection);
      connection.close();
      context.responseComplete();
      servletOutputStream.flush();
      servletOutputStream.close();
    } catch (Exception ex) {
      Logger.getLogger(ReportGeneratorBean.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      connection.close();
    }
    return null;
  }

}
