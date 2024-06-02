package dz.airalgerie.commun.reunion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class NotificationFacade extends AbstractFacade<Notification> {

    @PersistenceContext(unitName = "produit_pu") // Remplacez "votre_persistence_unit_name" par le nom de votre unité de persistance
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificationFacade() {
        super(Notification.class);
    }
    public void save(Notification notification) {
    // Récupérer le dernier ID en base de données
    Query query = em.createQuery("SELECT MAX(n.id) FROM Notification n");
    Integer lastId = (Integer) query.getSingleResult();
    
    // Incrémenter l'ID
    int newId = lastId != null ? lastId + 1 : 1;
    notification.setId(newId);
    
    // Persister la notification
    em.persist(notification);
}

public List<Notification> fetchNotifications(Employe employe) {
    System.out.println("Fetching notifications for employe: " + employe.getMatricule());
    List<Notification> notifications = em.createQuery(
            "SELECT n FROM Notification n WHERE n.employe = :employe", Notification.class)
            .setParameter("employe", employe)
            .getResultList();
    System.out.println("Notifications fetched: " + (notifications != null ? notifications.size() : 0));
    return notifications;
}
 public void supprimerNotificationsByReunionId(int reunionId) {
        List<Notification> notifications = em.createQuery("SELECT n FROM Notification n WHERE n.reunion.id = :reunionId", Notification.class)
                                              .setParameter("reunionId", reunionId)
                                              .getResultList();
        for (Notification notification : notifications) {
            em.remove(notification);
        }
    }
 public List<Notification> findByEmploye(Employe employe) {
        TypedQuery<Notification> query = em.createQuery("SELECT n FROM Notification n WHERE n.employe = :employe", Notification.class);
        query.setParameter("employe", employe);
        return query.getResultList();
    }
    // Ajoutez ici d'autres méthodes spécifiques pour la manipulation des notifications, si nécessaire
}
