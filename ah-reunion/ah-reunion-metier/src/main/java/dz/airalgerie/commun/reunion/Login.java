/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dz.airalgerie.commun.reunion;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private String role;
     
    @OneToOne
    @JoinColumn(name = "MATRICULE") // Nom de la colonne de clé étrangère dans la table LOGIN
     Employe employe;

    public Login() {
    }

    public Login(String adresse, String password, String role) {
        this.adresse = adresse;
        this.password = password;
        this.role = role;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
  public boolean isAdmin() {
        return "admin".equalsIgnoreCase(role); // Vérifie si le rôle est "admin"
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adresse != null ? adresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        return !((this.adresse == null && other.adresse != null) || (this.adresse != null && !this.adresse.equals(other.adresse)));
    }

    @Override
    public String toString() {
        return "dz.airalgerie.product.Login[ adresse=" + adresse + " ]";
    }
}
