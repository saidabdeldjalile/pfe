/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean.core.config;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.UtilsLogger;
import dz.airalgerie.grh.model.dto.commun.PersonnelDTO;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.omnifaces.filter.HttpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 *
 * @author kehli
 */
@WebFilter(filterName = "loggerFilter", urlPatterns = "/*")
public class LoggerFilter extends HttpFilter {

  static final Logger log = LoggerFactory.getLogger(LoggerFilter.class);

  /**
   * Permet d'ajouter le nom d'utilisateur connecté à l'MDC pour les logs
   * 
   * @param request
   * @param response
   * @param session
   * @param chain
   * @throws ServletException
   * @throws IOException
   */
  @Override
  public void doFilter(HttpServletRequest request, HttpServletResponse response,
      HttpSession session, FilterChain chain) throws ServletException, IOException {
    try {
      if (!this.excludeUrl(request.getServletPath())) {
        PersonnelDTO user = null;
        if (session != null && session.getAttribute(ErpConstante.SessionKey.LOGGED_USER) != null) {
          user = ((PersonnelDTO) session.getAttribute(ErpConstante.SessionKey.LOGGED_USER));
        }
        UtilsLogger.userDetails(user);
      }
      chain.doFilter(request, response);
    } catch (Exception e) {
      log.error("Error on LoggerFilter", e);
      throw e;
    } finally {
      MDC.clear();
    }
  }

  /**
   * Permet d'exclure les URLs à ne pas mapper
   * 
   * @param path
   * @return
   */
  private boolean excludeUrl(String path) {
    return path.contains("javax.faces.") || path.contains("/ressources");
  }
}
