
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Role")
  private String role;

  @Column(name = "detail")
  private String detail;

  // bi-directional many-to-many association to User
  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)

  private Set<User> users;

  public Role() {}

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Set<User> getUsers() {
    return this.users;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((role == null) ? 0 : role.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Role other = (Role) obj;
    if (role == null) {
      if (other.role != null)
        return false;
    } else if (!role.equals(other.role))
      return false;
    return true;
  }

}
