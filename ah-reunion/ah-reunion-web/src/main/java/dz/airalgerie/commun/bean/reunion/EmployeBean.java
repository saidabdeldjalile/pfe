package dz.airalgerie.commun.bean.reunion;

import dz.airalgerie.commun.reunion.Employe;
import dz.airalgerie.commun.reunion.EmployeFacade;
import dz.airalgerie.commun.reunion.Login;
import dz.airalgerie.commun.reunion.LoginFacade;
import dz.airalgerie.commun.reunion.Notification;
import dz.airalgerie.commun.reunion.NotificationFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named("employeBean")
@ViewScoped
public class EmployeBean implements Serializable {

    @EJB
    private EmployeFacade employeFacade;

    @EJB
    private LoginFacade loginFacade; // Declare and inject LoginFacade

    @EJB
    private NotificationFacade notificationFacade; // Declare and inject NotificationFacade

    private List<Employe> employes;
    private Employe employe;
    private Employe employeAModifier;

    @PostConstruct
    public void init() {
        chargerEmployes();
        employe = new Employe();
    }

    public EmployeFacade getEmployeFacade() {
        return employeFacade;
    }

    public void setEmployeFacade(EmployeFacade employeFacade) {
        this.employeFacade = employeFacade;
    }

    public void chargerEmployes() {
        employes = employeFacade.findAll();
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void modifierEmploye(Employe employe) {
        this.employeAModifier = employe;
    }

    public void modifierEmploye() {
        employeFacade.edit(employeAModifier);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Employé modifié avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
        employeAModifier = null;
    }

    public void supprimerEmploye(Employe employe) {
        // Find the associated Login
        Login login = loginFacade.findByEmploye(employe);

        if (login != null && login.isAdmin()) {
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Une erreur s'est produite lors du téléchargement et de la sauvegarde du fichier.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            
            return; // Exit the method without deleting
        }

        if (login != null) {
            loginFacade.remove(login);
        }

        // Find and delete the associated Notifications
        List<Notification> notifications = notificationFacade.findByEmploye(employe);
        for (Notification notification : notifications) {
            notificationFacade.remove(notification);
        }

        // Delete the employe
        employeFacade.remove(employe);
        employes.remove(employe);

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Employé supprimé avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void ajouterEmploye() {
        employeFacade.create(employe);
        employes.add(employe);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Employé ajouté avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
        employe = new Employe(); // Réinitialiser l'objet employé après l'ajout
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Employe getEmployeAModifier() {
        return employeAModifier;
    }

    public void setEmployeAModifier(Employe employeAModifier) {
        this.employeAModifier = employeAModifier;
    }
}
