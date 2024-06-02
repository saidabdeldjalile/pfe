/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sofyane MAKERRI
 */
@ManagedBean
@ViewScoped
public class AutorisationBean implements Serializable {

  private static final long serialVersionUID = 1L;

  static final Logger LOGGER = LoggerFactory.getLogger(AutorisationBean.class);
  private boolean read;
  private boolean update;
  private boolean delete;
  private boolean validate;
  private boolean insert;

  @Inject
  private UserBean userBean;

  @PostConstruct
  private void init() {}

  @Deprecated
  public boolean estAutorise() {
    HttpServletRequest request =
        (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    FacesContext.getCurrentInstance().getCurrentInstance().getExternalContext()
        .getRequestContextPath();
    String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    String url = request.getRequestURL().toString();
    String uri = request.getRequestURI();

    LOGGER.info("uri : " + uri);
    LOGGER.info("url : " + url);
    LOGGER.info("viewId : " + viewId);
    // if (userBean.getRefPermissions() != null) {
    // List<RefPermission> refPermissions = userBean.getRefPermissions().get(viewId);
    // if (refPermissions != null && !refPermissions.isEmpty()) {
    // read = refPermissions.stream().anyMatch(r -> r.getIsRead());
    // update = refPermissions.stream().anyMatch(r -> r.getIsUpdate());
    // delete = refPermissions.stream().anyMatch(r -> r.getIsDelete());
    // validate = refPermissions.stream().anyMatch(r -> r.getIsValidate());
    // insert = refPermissions.stream().anyMatch(r -> r.getIsInsert());
    // }
    // }
    LOGGER.info("read : " + read);
    LOGGER.info("update : " + update);
    LOGGER.info("delete : " + delete);
    LOGGER.info("validate : " + validate);
    LOGGER.info("insert : " + insert);

    return read;
  }

  public UserBean getUserBean() {
    return userBean;
  }

  public void setUserBean(UserBean userBean) {
    this.userBean = userBean;
  }

  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }

  public boolean isUpdate() {
    return update;
  }

  public void setUpdate(boolean update) {
    this.update = update;
  }

  public boolean isDelete() {
    return delete;
  }

  public void setDelete(boolean delete) {
    this.delete = delete;
  }

  public boolean isValidate() {
    return validate;
  }

  public void setValidate(boolean validate) {
    this.validate = validate;
  }

  public boolean isInsert() {
    return insert;
  }

  public void setInsert(boolean insert) {
    this.insert = insert;
  }

}
