package dz.airalgerie.commun.reunion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Administrateur
 */
@Stateless
public class ReunionFacade extends AbstractFacade<Reunion> {

    @PersistenceContext(unitName = "produit_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReunionFacade() {
        super(Reunion.class);
        
    }
        public void updateReunion(Reunion reunion) {
        em.merge(reunion);
    }

  public List<Employe> findEmployeesByReunion(Reunion reunion) {
        Query query = em.createQuery("SELECT e FROM Employe e JOIN ReunionEmploye re ON e.matricule = re.matriculeEmploye WHERE re.idReunion = :reunionId");
        query.setParameter("reunionId", reunion.getId());
        return query.getResultList();
    // Ajoutez ici les méthodes spécifiques à la gestion des réunions si nécessaire
}
  public List<Employe> findAllEmployees() {
        return em.createNamedQuery("Employe.findAll").getResultList();
    }
    public void addEmployeToReunion(Employe employe, Reunion reunion) {
    reunion.getGestionreunion().add(employe);
    em.merge(reunion); // Mettre à jour la réunion dans la base de données
}
public void clearEmployeesFromReunion(Reunion reunion) {
    reunion.getGestionreunion().clear();
    em.merge(reunion);
}
public void saveReunionFileDetails(int reunionId, String fileName) {
    // Créer une instance de FichierReunion
    FichierReunion fichierReunion = new FichierReunion();
    fichierReunion.setFichierId(reunionId);
    fichierReunion.setFichierNom(fileName);

    // Trouver la réunion correspondante dans la base de données

    
    // Associer le fichierReunion à la réunion
   
    
    // Persister l'entité FichierReunion dans la base de données
    em.persist(fichierReunion);
}

    // Méthode pour définir les employés pour une réunion spécifique
  
public void supprimerFichiersByReunionId(int reunionId) {
    // Supprimer tous les fichiers ayant l'ID de réunion spécifié
    em.createQuery("DELETE FROM FichierReunion f WHERE f.fichierId IN (SELECT r.fichierId FROM FichierReunion r WHERE r.fichierId = :reunionId)")
            .setParameter("reunionId", reunionId)
            .executeUpdate();
}


    // Autres méthodes de la classe...

    public int getNombreFichier(int reunionId) {
        int i;
        Reunion reunion = em.find(Reunion.class, reunionId);
        
        if (reunion != null) {
            i=reunion.getNombreFichier();
            System.out.println("reunion numero"+i);
            return reunion.getNombreFichier();
        } else {
            return 0; // Ou une valeur par défaut selon votre logique d'application
        }
    }

    public void updateReunionFileCount(int reunionId, int newFileCount) {
        Reunion reunion = em.find(Reunion.class, reunionId);
        if (reunion != null) {
            reunion.setNombreFichier(newFileCount);
            em.merge(reunion);
        } else {
            // Gérer le cas où la réunion n'existe pas
            System.out.println("La réunion avec l'ID " + reunionId + " n'existe pas.");
        }
    }
  public List<Reunion> findReunionsByMatricule(Integer matricule) {
        return em.createQuery("SELECT r FROM Reunion r JOIN r.gestionreunion e WHERE e.matricule = :matricule", Reunion.class)
                 .setParameter("matricule", matricule)
                 .getResultList();
    }
}

    // Aautres méthodes de la classe...







