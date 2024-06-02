package dz.airalgerie.commun.reunion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

@Stateless
public class LoginFacade extends AbstractFacade<Login> {

    @PersistenceContext(unitName = "produit_pu")
    private EntityManager em;

    public LoginFacade() {
        super(Login.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void creerLogin(Login login, Integer matriculeEmploye) {
        Employe employe = em.find(Employe.class, matriculeEmploye);
        if (employe != null) {
            login.setEmploye(employe);
            em.persist(login);
        } else {
            // Handle the case where the employee is not found
        }
    }

    public void modifierUser(Login login) {
        Login loginExist = em.find(Login.class, login.getAdresse());
        if (loginExist != null) {
            loginExist.setPassword(login.getPassword());
            loginExist.setRole(login.getRole());
            em.merge(loginExist);
        } else {
            // Handle the case where the Login object does not exist
        }
    }

    public void modifierMatriculeEmploye(Login login, Integer matriculeEmploye) {
        Login loginExist = em.find(Login.class, login.getAdresse());
        if (loginExist != null) {
            Employe employe = em.find(Employe.class, matriculeEmploye);
            if (employe != null) {
                loginExist.setEmploye(employe);
                em.merge(loginExist);
            } else {
                // Handle the case where the employee is not found
            }
        } else {
            // Handle the case where the Login object does not exist
        }
    }
   public Login findbyLogin(String adresse) {
        try {
            TypedQuery<Login> query = em.createQuery("SELECT l FROM Login l WHERE l.adresse = :adresse", Login.class);
            query.setParameter("adresse", adresse);
            return query.getSingleResult();
        } catch (Exception e) {
            return null; // Handle exception as per your application's requirement
        }
    }
 public Login findByEmploye(Employe employe) {
        TypedQuery<Login> query = em.createQuery("SELECT l FROM Login l WHERE l.employe = :employe", Login.class);
        query.setParameter("employe", employe);
        return query.getSingleResult();
    }
}
