/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.model.dto.auth;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Root
 */
public class RefUserPermissionDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private String user;
  private String permission;
  private Set<String> directionAutorisee;

  public RefUserPermissionDTO() {
  }

  public RefUserPermissionDTO(String user, String permission, Set<String> directionAutorisee) {
    this.user = user;
    this.permission = permission;
    this.directionAutorisee = directionAutorisee;
  }

  public RefUserPermissionDTO(String user, String permission) {
    this.user = user;
    this.permission = permission;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public Set<String> getDirectionAutorisee() {
    return directionAutorisee;
  }

  public void setDirectionAutorisee(Set<String> directionAutorisee) {
    this.directionAutorisee = directionAutorisee;
  }


}
