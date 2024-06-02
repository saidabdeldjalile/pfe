package dz.airalgerie.commun.bean.reunion;

import dz.airalgerie.commun.reunion.Employe;
import dz.airalgerie.commun.reunion.Login;
import dz.airalgerie.commun.reunion.LoginFacade;
import dz.airalgerie.commun.reunion.Notification;
import dz.airalgerie.commun.reunion.NotificationFacade;
import dz.airalgerie.commun.reunion.Reunion;
import dz.airalgerie.commun.reunion.ReunionFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String adresse;
    private String password;
    private String role;
    private Employe employe;
    private List<Notification> notifications;

    @EJB
    private NotificationFacade notificationFacade;

    @EJB
    private LoginFacade loginFacade;

    @EJB
    private ReunionFacade reunionFacade;

    @Inject
    private HttpServletRequest request;
    private List<Reunion> reunions; // Changed to List from ArrayList

    @PostConstruct
    public void init() {
        String user = request.getUserPrincipal().getName();
        Login login = loginFacade.findbyLogin(user);
        if (login != null) {
            employe = login.getEmploye();
            loadReunions(); // Load reunions after setting the employee
        }
    }

    public void loadNotifications() {
        if (employe != null) {
            this.notifications = notificationFacade.fetchNotifications(employe);
        }
    }

    public void loadReunions() {
        if (employe != null) {
            this.reunions = reunionFacade.findReunionsByMatricule(employe.getMatricule());
        }
    }

    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(role);
    }

    public void logout() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath());
    }

    // Getters and Setters
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

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Reunion> getReunions() {
        return reunions;
    }

    public void setReunions(List<Reunion> reunions) {
        this.reunions = reunions;
    }
}
