/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean;

/**
 *
 * @author Root
 */
import dz.airalgerie.commun.facade.CountUsersFacade;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.UtilsLogger;
import java.io.IOException;
import java.time.LocalDate;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.LoggerFactory;

@WebListener
public class SessionTimeoutListener implements HttpSessionListener {

  @EJB
  private CountUsersFacade countUsersFacade;
  @Inject
  private ApplicationBean applicationBean;

  private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SessionTimeoutListener.class);

  @Override
  public void sessionCreated(HttpSessionEvent event) {
    // NOOP.
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    RefUser user = (RefUser) event.getSession().getAttribute("User");
    if (user != null && applicationBean.getLogins() != null
        && applicationBean.getLogins().contains(user.getLogin())) {
      UtilsLogger.doLog(LOGGER, ErpConstante.LoggerAction.AUTH, "LOGOUT", "DECONNEXION");
      applicationBean.getLogins().remove(user.getLogin());
      countUsersFacade.decreaseUsersCount(applicationBean.getAppCode(),
          java.sql.Date.valueOf(LocalDate.now()));
      applicationBean.sendNotif();
    }
  }
}
