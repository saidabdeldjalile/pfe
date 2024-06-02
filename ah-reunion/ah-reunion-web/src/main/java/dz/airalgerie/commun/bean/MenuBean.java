/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean;

import dz.airalgerie.commun.model.utils.ModuleDTO;
import dz.airalgerie.commun.ref.entities.RefModule;
import dz.airalgerie.commun.ref.entities.RefPermission;
import dz.airalgerie.commun.ref.facade.RefFonctionFacade;
import dz.airalgerie.commun.ref.facade.RefModuleFacade;
import dz.airalgerie.commun.ref.facade.RefPermissionFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sofyane MAKERRI
 */
@Named
@SessionScoped
public class MenuBean implements Serializable {

  private static final long serialVersionUID = 1L;

  static final Logger LOGGER = LoggerFactory.getLogger(MenuBean.class);

  @EJB
  RefModuleFacade refModuleFacade;
  @EJB
  RefFonctionFacade refFonctionFacade;
  @EJB
  RefPermissionFacade refPermissionFacade;

  private List<RefModule> refModules;
  private List<ModuleDTO> menu;
  private List<RefPermission> refPermissions;

  @Inject
  private ApplicationBean applicationBean;
  @Inject
  private UserBean userBean;

  @PostConstruct
  public void init() {
    loadModules();
  }

  private void loadModules() {
    if (applicationBean.getAppCode() == null) {
      menu = new ArrayList<>();
    } else {
      menu = refModuleFacade.findMenuByDomaine(applicationBean.getAppCode(),
          userBean.getRefUser().getMatricule());
    }
  }

  public List<RefModule> getRefModules() {
    return refModules;
  }

  public void setRefModules(List<RefModule> refModules) {
    this.refModules = refModules;
  }

  public List<ModuleDTO> getMenu() {
    return menu;
  }

  public void setMenu(List<ModuleDTO> menu) {
    this.menu = menu;
  }

  public ApplicationBean getApplicationBean() {
    return applicationBean;
  }

  public void setApplicationBean(ApplicationBean applicationBean) {
    this.applicationBean = applicationBean;
  }

  public UserBean getUserBean() {
    return userBean;
  }

  public void setUserBean(UserBean userBean) {
    this.userBean = userBean;
  }

}
