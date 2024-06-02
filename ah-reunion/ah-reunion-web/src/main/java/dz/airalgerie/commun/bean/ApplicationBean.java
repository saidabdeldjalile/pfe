/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean;

import dz.airalgerie.commun.facade.CountUsersFacade;
import dz.airalgerie.commun.helper.ftp.FtpConfig;
import dz.airalgerie.commun.ref.entities.RefPermission;
import dz.airalgerie.commun.ref.facade.RefDomaineFacade;
import dz.airalgerie.commun.ref.facade.RefPermissionFacade;
import dz.airalgerie.commun.utils.Alerts;
import dz.airalgerie.commun.utils.CheckConfigurationParameters;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.Util;
import dz.airalgerie.grh.model.dto.commun.ExternelConfigurationParameters;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.util.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrateur
 */
@Named(value = "applicationBean")
@ApplicationScoped
@DatabaseIdentityStoreDefinition(dataSourceLookup = ErpConstante.UnitName.REF_JNDI_NAME,
    callerQuery = "SELECT [PASSWORD] FROM [AUTH].USERS WHERE [LOGIN] = ?",
    groupsQuery = "DECLARE @LOGIN VARCHAR(70) = ?; \n" + "SELECT DISTINCT P.NAME\n"
        + "FROM AUTH.USERS U\n" + "	INNER JOIN AUTH.USERS_GROUPE UG ON U.MATRICULE = UG.MATRICULE\n"
        + "	INNER JOIN AUTH.GROUPE_PERMISSION GP ON GP.ID_GROUPE = UG.ID_GROUPE\n"
        + "	INNER JOIN AUTH.PERMISSION P ON P.ID = GP.ID_PERMISSION\n"
        + "	INNER JOIN AUTH.FONCTION F ON F.ID = P.ID_FONCTION and f.STATUT = 1\n"
        + "	INNER JOIN AUTH.MODULE M ON M.ID = F.ID_MODULE and m.STATUT = 1\n"
        + "	INNER JOIN AUTH.DOMAINE D ON D.ID = M.ID_DOMAINE AND d.STATUT = 1\n"
        + "WHERE [LOGIN] = @LOGIN \n" + "UNION\n" + "SELECT \n" + "	CASE \n"
        + "		WHEN D.CODE = 'GRH' THEN 'appGrhAccess'\n"
        + "		WHEN D.CODE = 'GFC' THEN 'appGfcAccess'\n"
        + "		WHEN D.CODE = 'REF' THEN 'appRefAccess'\n"
        + "		WHEN D.CODE = 'PORTAIL' THEN 'appPrtAccess'\n"
        + "		WHEN D.CODE = 'OPS' THEN 'appOpsAccess'\n" + "		ELSE ''\n" + "	END NAME\n"
        + "FROM AUTH.USERS U\n" + "	INNER JOIN AUTH.USERS_GROUPE UG ON U.MATRICULE = UG.MATRICULE\n"
        + "	INNER JOIN AUTH.GROUPE_PERMISSION GP ON GP.ID_GROUPE = UG.ID_GROUPE\n"
        + "	INNER JOIN AUTH.PERMISSION P ON P.ID = GP.ID_PERMISSION\n"
        + "	INNER JOIN AUTH.FONCTION F ON F.ID = P.ID_FONCTION AND F.STATUT = 1\n"
        + "	INNER JOIN AUTH.MODULE M ON M.ID = F.ID_MODULE AND M.STATUT = 1\n"
        + "	INNER JOIN AUTH.DOMAINE D ON D.ID = M.ID_DOMAINE AND D.STATUT = 1\n"
        + "WHERE [LOGIN] = @LOGIN \n" + "GROUP BY D.CODE\n",
    priorityExpression = "#{100}",
    hashAlgorithmParameters = {"Pbkdf2PasswordHash.Iterations=3072", "${applicationBean.dyna}"})
@CustomFormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(
    loginPage = "/login.xhtml", errorPage = "", useForwardToLogin = true))
public class ApplicationBean implements Serializable {

  private static final long serialVersionUID = 1L;

  static final Logger LOGGER = LoggerFactory.getLogger(ApplicationBean.class);

  private static final String MANIFEST_PATH = "/META-INF/MANIFEST.MF";

  private static final String APPLICATION_PATH = "/META-INF/application.properties";

  private String version;

  private String appCode;

  private FtpConfig ftpConfig;
  private FtpConfig ftpConfigGRH;
  private ExternelConfigurationParameters externelConfigurationParameters;
  private ExternelConfigurationParameters externelConfigurationParametersGRH;

  private String sharedFolderPath;

  @EJB
  RefPermissionFacade refPermissionFacade;
  @Inject
  CheckConfigurationParameters checkConfigurationParameters;

  private List<RefPermission> refPermissions;

  private String refUrl;

  private String urlContext;

  @EJB
  RefDomaineFacade refDomainFacade;

  private static List<String> logins = new ArrayList<String>();

  private static int peakCount = 0;

  @EJB
  private CountUsersFacade countUsersFacade;

  @Inject
  private HttpServletRequest request;

  @PostConstruct
  private void init() {
    try {
      configureMessageResolver();
      loadVersion();
      loadAppCode();
      countUsersFacade.resetCount(appCode, java.sql.Date.valueOf(LocalDate.now()));
      loadRefHost();

      // loadPermission();
    } catch (NamingException ex) {
      java.util.logging.Logger.getLogger(ApplicationBean.class.getName()).log(Level.SEVERE, null,
          ex);
    }
  }

  /**
   * Permet de configurer le resolver des messages depuis FacesMessage.
   */
  private void configureMessageResolver() {
    Messages.setResolver(Alerts::formatMessage);
  }

  private void loadPermission() {
    refPermissions = refPermissionFacade.findAllPermitted();
  }

  private void loadVersion() {
    Properties prop = loadManifestFile();

    if (!prop.isEmpty()) {
      version = prop.getProperty("version");
    }

  }

  private Properties loadManifestFile() {
    ServletContext servletContext =
        (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    Properties prop = new Properties();
    try {
      InputStream resourceAsStream = servletContext.getResourceAsStream(MANIFEST_PATH);
      if (resourceAsStream != null) {
        prop.load(resourceAsStream);
      }
    } catch (IOException e) {
      LOGGER.error("Error on loading manifest file", e);
    }
    return prop;
  }

  private void loadAppCode() throws NamingException {
    Properties prop = Util.loadApplicationFile();
    if (!prop.isEmpty()) {
      appCode = "PORTAIL";
      externelConfigurationParameters = new ExternelConfigurationParameters(
          checkConfigurationParameters.getConfigurationParameters(prop.getProperty("app.ftp.user")),
          checkConfigurationParameters
              .getConfigurationParameters(prop.getProperty("app.ftp.password")),
          checkConfigurationParameters.getConfigurationParameters(prop.getProperty("app.ftp.host")),
          checkConfigurationParameters
              .getConfigurationParameters(prop.getProperty("app.ftp.rootPath")));
      ftpConfig = new FtpConfig(externelConfigurationParameters.getHostFtp(),
          externelConfigurationParameters.getUsernameFtp(),
          externelConfigurationParameters.getPasswordFtp(),
          externelConfigurationParameters.getRootPathFtp());
      externelConfigurationParametersGRH = new ExternelConfigurationParameters(
          checkConfigurationParameters
              .getConfigurationParameters(prop.getProperty("app.ftp.userGRH")),
          checkConfigurationParameters
              .getConfigurationParameters(prop.getProperty("app.ftp.passwordGRH")),
          checkConfigurationParameters
              .getConfigurationParameters(prop.getProperty("app.ftp.hostGRH")));
      ftpConfigGRH = new FtpConfig(externelConfigurationParametersGRH.getHostFtp(),
          externelConfigurationParametersGRH.getUsernameFtp(),
          externelConfigurationParametersGRH.getPasswordFtp());

      try {
        sharedFolderPath = checkConfigurationParameters
            .getConfigurationParameters(prop.getProperty("app.path.sharedFolder"));
        File targetFile = new File(sharedFolderPath);
        if (!targetFile.exists()) {
          targetFile.mkdirs();
        }
      } catch (NamingException ex) {
        java.util.logging.Logger.getLogger(ApplicationBean.class.getName()).log(Level.SEVERE, null,
            ex);
      }

    }
  }

  public String[] getDyna() {
    return new String[] {"Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
        "Pbkdf2PasswordHash.SaltSizeBytes=64"};
  }

  /**
   * Creates a new instance of ApplicationBean
   */
  public ApplicationBean() {
    // Bean consturtor.
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getAppCode() {
    return appCode;
  }

  public void setAppCode(String appCode) {
    this.appCode = appCode;
  }

  public boolean isGrhDomain() {
    return appCode.equalsIgnoreCase("grh");
  }

  public RefPermissionFacade getRefPermissionFacade() {
    return refPermissionFacade;
  }

  public void setRefPermissionFacade(RefPermissionFacade refPermissionFacade) {
    this.refPermissionFacade = refPermissionFacade;
  }

  public List<RefPermission> getRefPermissions() {
    return refPermissions;
  }

  public void setRefPermissions(List<RefPermission> refPermissions) {
    this.refPermissions = refPermissions;
  }

  public FtpConfig getFtpConfig() {
    return ftpConfig;
  }

  public void setFtpConfig(FtpConfig ftpConfig) {
    this.ftpConfig = ftpConfig;
  }

  public FtpConfig getFtpConfigGRH() {
    return ftpConfigGRH;
  }

  public void setFtpConfigGRH(FtpConfig ftpConfigGRH) {
    this.ftpConfigGRH = ftpConfigGRH;
  }

  public ExternelConfigurationParameters getExternelConfigurationParameters() {
    return externelConfigurationParameters;
  }

  public void setExternelConfigurationParameters(
      ExternelConfigurationParameters externelConfigurationParameters) {
    this.externelConfigurationParameters = externelConfigurationParameters;
  }

  public ExternelConfigurationParameters getExternelConfigurationParametersGRH() {
    return externelConfigurationParametersGRH;
  }

  public void setExternelConfigurationParametersGRH(
      ExternelConfigurationParameters externelConfigurationParametersGRH) {
    this.externelConfigurationParametersGRH = externelConfigurationParametersGRH;
  }

  public List<String> getLogins() {
    return logins;
  }

  public void setLogins(List<String> logins) {
    this.logins = logins;
  }

  public int getPeakCount() {
    return peakCount;
  }

  public void setPeakCount(int peakCount) {
    this.peakCount = peakCount;
  }

  public String getSharedFolderPath() {
    return sharedFolderPath;
  }

  public void setSharedFolderPath(String sharedFolderPath) {
    this.sharedFolderPath = sharedFolderPath;
  }

  /**
   * envoyer des notifications de connexion
   * 
   */
  public void sendNotif() {
    try {
      URL url = new URL(urlContext + "/" + refUrl + "/pages/stats/send.xhtml?login=1");
      url.openConnection().getInputStream();
    } catch (Exception e) {
      LOGGER.error("ERROR on send notif ", e);
    }
  }

  public void loadRefHost() {
    try {
      Properties prop = Util.loadApplicationFile();
      urlContext = checkConfigurationParameters
          .getConfigurationParameters(prop.getProperty("app.url.refHost"));
      refUrl = refDomainFacade.findUrlByDomaine("REF").split("/")[1];
    } catch (NamingException ex) {
      java.util.logging.Logger.getLogger(ApplicationBean.class.getName()).log(Level.SEVERE, null,
          ex);
    }
  }

}
