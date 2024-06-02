/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.administration.bean;

import dz.airalgerie.commun.model.entities.commun.CountUsers;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

/**
 *
 * @author Root
 */

@Named(value = "connectedBean")
@ViewScoped
public class ConnectedBean implements Serializable {

  private List<CountUsers> usersCount;

  private List<Object[]> countUsersChart;

  private String period;

  private Object[] peakGlobal;

  private BigDecimal percentage;

  RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();

  String dateUpTime;

  Map<String, String> params =
      FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
  String notify = params.get("login");

  @Inject
  @Push(channel = "notify")
  private PushContext push;

  @PostConstruct
  public void init() {
    dateUpTime = getDurationBreakdown(rb.getUptime());
    period = "week";
    percentage = new BigDecimal(getTotaleUsers()).multiply(
        new BigDecimal(100)).divide(new BigDecimal(Integer.parseInt(peakGlobal[1].toString())), 1,
        RoundingMode.CEILING);
  }

  public List<Object[]> getCountUsersChart() {
    return countUsersChart;
  }

  public void setCountUsersChart(List<Object[]> countUsersChart) {
    this.countUsersChart = countUsersChart;
  }

  public List<CountUsers> getUsersCount() {
    return usersCount;
  }

  public void setUsersCount(List<CountUsers> usersCount) {
    this.usersCount = usersCount;
  }

  public String getNotify() {
    push.send("Sending notif..");
    return notify;
  }

  public void setNotify(String notify) {
    this.notify = notify;
  }

  /**
   * calculer le nombre Total des utilisateurs connectés
   * 
   * @return
   */
  public int getTotaleUsers() {
    int count = 0;
    for (int i = 0; i < usersCount.size(); i++) {
      count = count + usersCount.get(i).getNbUtilisateur();
    }
    return count;
  }

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public Object[] getPeakGlobal() {
    return peakGlobal;
  }

  public void setPeakGlobal(Object[] peakGlobal) {
    this.peakGlobal = peakGlobal;
  }

  public RuntimeMXBean getRb() {
    return rb;
  }

  public void setRb(RuntimeMXBean rb) {
    this.rb = rb;
  }

  public String getDateUpTime() {
    return dateUpTime;
  }

  public void setDateUpTime(String dateUpTime) {
    this.dateUpTime = dateUpTime;
  }

  public BigDecimal getPercentage() {
    return percentage;
  }

  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }

  /**
   * Convert a millisecond duration to a string format
   * 
   * @param millis A duration to convert to a string form
   * @return A string of the form "X Days Y Hours Z Minutes A Seconds".
   */
  public static String getDurationBreakdown(long millis) {

    long days = TimeUnit.MILLISECONDS.toDays(millis);
    millis -= TimeUnit.DAYS.toMillis(days);
    long hours = TimeUnit.MILLISECONDS.toHours(millis);
    millis -= TimeUnit.HOURS.toMillis(hours);
    long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
    millis -= TimeUnit.MINUTES.toMillis(minutes);
    long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

    StringBuilder sb = new StringBuilder(64);
    sb.append(days);
    sb.append(" Jour ");
    sb.append(hours);
    sb.append(" Heurs ");
    sb.append(minutes);
    sb.append(" Minutes ");
    sb.append(seconds);
    sb.append(" Seconds");

    return (sb.toString());
  }
}

