package dz.airalgerie.commun.bean.reunion;

import dz.airalgerie.commun.reunion.Employe;
import dz.airalgerie.commun.reunion.Notification;
import dz.airalgerie.commun.reunion.NotificationFacade;
import dz.airalgerie.commun.reunion.Reunion;
import dz.airalgerie.commun.reunion.ReunionFacade;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import org.apache.poi.util.IOUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;




@Named("reunionBean")
@ViewScoped
public class Product implements Serializable {

    @EJB
    private ReunionFacade reunionFacade;
    @EJB
    private NotificationFacade notificationFacade;

    private List<Reunion> reunions;
    private Reunion reunion;
    private Reunion reunionAModifier;
    private List<Reunion> filteredReunions;
    private List<Employe> employeesInReunion;
    private List<Employe> allEmployees; // Pour stocker tous les employés existants
    private List<Employe> selectedEmployees;
    private List<File> selectedReunionFiles;// Liste des employés dans la réunion
    private List<UploadedFile> filesForModifiedReunion = new ArrayList<>();
    private List<UploadedFile> files = new ArrayList<>();
    private int selectedReunionId;
    String fileName;
    private UploadedFile file;
    @PostConstruct
    
    public void init() {
        chargerReunions();
        reunion = new Reunion();
         chargerTousLesEmployes();
    }
    
    private LocalDateTime dateDebutFilter;
    private LocalDateTime dateFinFilter;

    // Autres propriétés et méthodes de votre bean

    public LocalDateTime getDateDebutFilter() {
        return dateDebutFilter;
    }

    public void setDateDebutFilter(LocalDateTime dateDebutFilter) {
        this.dateDebutFilter = dateDebutFilter;
    }

    public LocalDateTime getDateFinFilter() {
        return dateFinFilter;
    }

    public void setDateFinFilter(LocalDateTime dateFinFilter) {
        this.dateFinFilter = dateFinFilter;
    }
     public void chargerTousLesEmployes() {
        allEmployees = reunionFacade.findAllEmployees();
    }
     
      public List<Employe> getAllEmployees() {
        return allEmployees;
    }

    public List<File> getSelectedReunionFiles() {
        return selectedReunionFiles;
    }
    // Méthode pour gérer l'upload du fichier
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    // Méthode pour charger les employés pour une réunion spécifique
    public void chargerEmployesPourReunion(Reunion reunion) {
        employeesInReunion = reunionFacade.findEmployeesByReunion(reunion);
    }

    public List<Employe> getEmployeesInReunion() {
        return employeesInReunion;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public Reunion getReunionAModifier() {
        return reunionAModifier;
    }

    public void setReunionAModifier(Reunion reunionAModifier) {
        this.reunionAModifier = reunionAModifier;
    }
     
    public void setSelectedReunionFiles(List<File> selectedReunionFiles) {
        this.selectedReunionFiles = selectedReunionFiles;
    }

    public void setAllEmployees(List<Employe> allEmployees) {
        this.allEmployees = allEmployees;
    }

    public List<Employe> getSelectedEmployees() {
        return selectedEmployees;
    }

    public void setSelectedEmployees(List<Employe> selectedEmployees) {
        this.selectedEmployees = selectedEmployees;
    }

    public void chargerReunions() {
        reunions = reunionFacade.findAll();
        filteredReunions = reunions;
    }

    public List<Reunion> getFilteredReunions() {
        return filteredReunions;
    }

    public void setFilteredReunions(List<Reunion> filteredReunions) {
        this.filteredReunions = filteredReunions;
    }

    public List<Reunion> getReunions() {
        return reunions;
    }

    public void modifierReunion(Reunion reunion) {
        this.reunionAModifier = reunion;
        selectedEmployees = reunionFacade.findEmployeesByReunion(reunion);
    }

    public List<UploadedFile> getFilesForModifiedReunion() {
        return filesForModifiedReunion;
    }

    public void setFilesForModifiedReunion(List<UploadedFile> filesForModifiedReunion) {
        this.filesForModifiedReunion = filesForModifiedReunion;
    }
    
    
       public String getFileName() {
        
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public ReunionFacade getReunionFacade() {
        return reunionFacade;
    }

    public void setReunionFacade(ReunionFacade reunionFacade) {
        this.reunionFacade = reunionFacade;
    }

    public List<UploadedFile> getFiles() {
        return files;
    }

    public void setFiles(List<UploadedFile> files) {
        this.files = files;
    }
    
    

public void handleFileUploadForModifiedReunion(FileUploadEvent event) {
    UploadedFile uploadedFile = event.getFile();
    
    // Ajouter le fichier téléchargé à la liste de fichiers pour la réunion modifiée
    filesForModifiedReunion.add(uploadedFile);

    // Afficher un message de succès
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Fichier ajouté avec succès à la réunion modifiée.");
    FacesContext.getCurrentInstance().addMessage(null, message);
}


   public void modifierReunion() {
    reunionFacade.edit(reunionAModifier);
       reunionFacade.clearEmployeesFromReunion(reunionAModifier); // Supprimer tous les employés existants de la réunion
    
    for (Employe employee : selectedEmployees) {
        reunionFacade.addEmployeToReunion(employee, reunionAModifier);
    }
        // Ajouter la logique pour télécharger et associer des fichiers à la réunion modifiée
    if (filesForModifiedReunion.isEmpty()) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Veuillez télécharger au moins un fichier.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return;
    }

   
        reunionFacade.updateReunion(reunionAModifier);

        // Associer
    // Associer les employés sélectionnés à la réunion
 

    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Réunion modifiée avec succès");
    FacesContext.getCurrentInstance().addMessage(null, message);
    reunionAModifier = null;
   
}

public void ajouterFichiersAReunion(int reunionId, List<UploadedFile> filesForModifiedReunion) {
    System.out.println("fichierajoute" +selectedReunionId);
    try {
        int index = reunionFacade.getNombreFichier(selectedReunionId); // Récupérer le nombre de fichiers actuels de la réunion
        int i = index; // Utiliser index pour générer les noms de fichiers de manière incrémentielle
        List<String> fileNames = new ArrayList<>();
        
        for (UploadedFile uploadedFile : filesForModifiedReunion) {
            try (InputStream input = uploadedFile.getInputStream()) {
                String fileName = "reunion_" + selectedReunionId + "_" + (i + 1) + ".pdf";
                fileNames.add(fileName);
                
                String relativeWebPath = "/resources/uploads";
                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String resourcesAbsoluteDiskPath = servletContext.getRealPath(relativeWebPath);
                String savePath = resourcesAbsoluteDiskPath;
                System.out.println("Chemin de sauvegarde : " + savePath); // Message de débogage
                
                Path folder = Paths.get(savePath);
                if (!Files.exists(folder)) {
                    Files.createDirectories(folder);
                }

                Path savedFile = folder.resolve(fileName);
                System.out.println("Chemin du fichier sauvegardé : " + savedFile); // Message de débogage

                Files.copy(input, savedFile);
                
                reunionFacade.saveReunionFileDetails(selectedReunionId, fileName);
                index++;
                i++;
               
            } catch (IOException e) {
                e.printStackTrace();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Une erreur s'est produite lors du téléchargement et de la sauvegarde du fichier.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
             reunionFacade.updateReunionFileCount(selectedReunionId, index);
        }
        
        // Mettre à jour le nombre de fichiers dans la réunion
     

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Fichiers ajoutés à la réunion avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
    } catch (Exception e) {
        e.printStackTrace();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Une erreur s'est produite lors de l'ajout des fichiers à la réunion.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}



public void supprimerReunion(Reunion reunion) {
    List<String> fileNames = getReunionFileNames(reunion.getId());
    for (String fileName : fileNames) {
        supprimerFichier(fileName);
    }

    // Delete notifications associated with the reunion
    notificationFacade.supprimerNotificationsByReunionId(reunion.getId());
    
    reunionFacade.supprimerFichiersByReunionId(reunion.getId()); // Supprimer les fichiers associés à la réunion
    reunionFacade.remove(reunion); // Supprimer la réunion
    reunions.remove(reunion);
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Réunion et notifications associées supprimées avec succès");
    FacesContext.getCurrentInstance().addMessage(null, message);
}



  

public void handleFileUpload(FileUploadEvent event) {
    UploadedFile uploadedFile = event.getFile();
    files.add(uploadedFile);
}

// Modifier la méthode ajouterReunion pour utiliser la nouvelle signature de saveReunionFileDetails
public void ajouterReunion() {
    // Vérifier si au moins un fichier a été téléchargé
    
    if (files.isEmpty()) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Veuillez télécharger au moins un fichier.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return;
    }

    try {
        // Validation des dates de la réunion
        LocalDateTime currentDate = LocalDateTime.now();

        if (reunion.getDateDeb().isBefore(currentDate)) {
            FacesContext.getCurrentInstance().addMessage("addDialogForm:newDateDebInput", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "La date de début de la réunion doit être ultérieure à la date actuelle."));
            FacesContext.getCurrentInstance().validationFailed(); // Marquer la validation comme échouée
            return;
        }

     

        // Créer la réunion
        reunionFacade.create(reunion);
        int index = 0;
        int i=1;
        // Enregistrer l'ID de la réunion et le nom de chaque fichier dans une liste
        int reunionId = reunion.getId();
        List<String> fileNames = new ArrayList<>();
        for (UploadedFile uploadedFile : files) {
            try (InputStream input = uploadedFile.getInputStream()) {
                // Définir le nom de fichier en utilisant l'ID de la réunion et un identifiant unique
                String fileName = "reunion_" + reunionId + "_" + i + ".pdf";
                fileNames.add(fileName);
                
                 // Ajouter le nom de fichier à la liste

                // Chemin de sauvegarde du fichier dans le projet
                String relativeWebPath = "/resources/uploads";
                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String resourcesAbsoluteDiskPath = servletContext.getRealPath(relativeWebPath);
                String savePath = resourcesAbsoluteDiskPath;
                Path folder = Paths.get(savePath);

                // Vérifier si le dossier de sauvegarde existe, sinon le créer
                if (!Files.exists(folder)) {
                    Files.createDirectories(folder);
                }

                // Chemin complet du fichier de sauvegarde
                Path savedFile = folder.resolve(fileName);

                // Copier le contenu du fichier téléchargé dans le fichier de sauvegarde
                Files.copy(input, savedFile);
                
                // Sauvegarder l'ID de la réunion et l'index du fichier dans la base de données
                reunionFacade.saveReunionFileDetails(reunionId, fileName);
                index++;
                i++;
            } catch (IOException e) {
                e.printStackTrace();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Une erreur s'est produite lors du téléchargement et de la sauvegarde du fichier.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
             reunion.setNombreFichier(index);
             reunionFacade.updateReunion(reunion);

        }
        String notificationMessage = "Une nouvelle réunion a été ajoutée: " + reunion.getId(); // Personnalisez le message selon vos besoins
        LocalDateTime dateDebutReunion = reunion.getDateDeb(); // Date de début de la réunion
      Integer id=1;  // Associer les employés sélectionnés à la réunion
       for (Employe employee : selectedEmployees) {
    reunionFacade.addEmployeToReunion(employee, reunion);
    Notification notification = new Notification(id,reunion, employee, notificationMessage, dateDebutReunion);
    notificationFacade.save(notification);
    i++;
}

        // Ajouter la réunion à la liste des réunions
        reunions.add(reunion);

        // Afficher un message de succès
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Réunion ajoutée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);

        // Réinitialiser l'objet reunion
        reunion = new Reunion();
    } catch (Exception e) {
        e.printStackTrace();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Une erreur s'est produite lors de l'ajout de la réunion.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}



public List<File> getReunionFiles(int reunionId) {
    
    selectedReunionId = reunionId;
    
    List<File> files = new ArrayList<>();
    String relativeWebPath = "/resources/uploads";
    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    String resourcesAbsoluteDiskPath = servletContext.getRealPath(relativeWebPath);

    // Parcourir tous les fichiers dans le répertoire de sauvegarde
    File directory = new File(resourcesAbsoluteDiskPath);
    File[] fileList = directory.listFiles();
    if (fileList != null) {
        for (File file : fileList) {
            if (file.isFile()) {
                String fileName = file.getName();
                // Vérifier si le fichier correspond au format "reunion_ID_index.pdf"
                if (fileName.startsWith("reunion_" + reunionId + "_")) {
                    files.add(file);
                }
            }
        }
    }
    return files;
}


    public int getSelectedReunionId() {
        return selectedReunionId;
    }

    public void setSelectedReunionId(int selectedReunionId) {
        this.selectedReunionId = selectedReunionId;
    }



  
 

    // Getter and Setter for selectedReunionId

    public void loadFilesForReunion(int reunionId) {
        selectedReunionFiles = getReunionFiles(reunionId);
    }




public List<String> getReunionFileNames(int reunionId) {
    List<String> fileNames = new ArrayList<>();
    String relativeWebPath = "/resources/uploads";
    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    String resourcesAbsoluteDiskPath = servletContext.getRealPath(relativeWebPath);

    // Parcourir tous les fichiers dans le répertoire de sauvegarde
    File directory = new File(resourcesAbsoluteDiskPath);
    File[] files = directory.listFiles();
    if (files != null) {
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                // Vérifier si le fichier correspond au format "reunion_ID_index.pdf"
                if (fileName.startsWith("reunion_" + reunionId + "_")) {
                    fileNames.add(fileName);
                }
            }
        }
    }
    return fileNames;
}

public void afficherPDF(String fileName) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();

    try {
        // Obtenir le chemin de sauvegarde où les fichiers PDF sont stockés
        String relativeWebPath = "/resources/uploads";
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String resourcesAbsoluteDiskPath = servletContext.getRealPath(relativeWebPath);

        // Construire le chemin d'accès complet au fichier PDF
        String filePath = resourcesAbsoluteDiskPath + File.separator + fileName;

        // Charger le fichier PDF
        InputStream inputStream = new FileInputStream(filePath);

        // Lire le contenu du fichier PDF en un tableau de bytes
        byte[] pdfBytes = IOUtils.toByteArray(inputStream);

        // Convertir les bytes du PDF en base64
        String base64PDF = Base64.getEncoder().encodeToString(pdfBytes);

        // Exécuter un script JavaScript pour afficher le PDF dans le navigateur
        PrimeFaces.current().executeScript("var byteArray = Uint8Array.from(atob('" + base64PDF + "'), c => c.charCodeAt(0));" +
                "var blob = new Blob([byteArray], { type: 'application/pdf' });" +
                "var objectURL = URL.createObjectURL(blob);" +
                "win"
                + "dow.open(objectURL);");
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


public void supprimerFichier(String fileName) {
    try {
        // Chemin du fichier à supprimer
        String relativeWebPath = "/resources/uploads";
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String resourcesAbsoluteDiskPath = servletContext.getRealPath(relativeWebPath);
        String filePath = resourcesAbsoluteDiskPath + File.separator + fileName;
        
        // Suppression du fichier
        Files.deleteIfExists(Paths.get(filePath));
        
        // Mettre à jour le nombre de fichiers de la réunion
      int reunionId = Integer.parseInt(fileName.split("_")[1]);
        Reunion reunion = reunionFacade.find(reunionId);
        if (reunion != null) {
            reunion.setNombreFichier(reunion.getNombreFichier() - 1);
            reunionFacade.updateReunion(reunion);
            
        }
        
        // Afficher un message de succès ou de confirmation
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Le fichier a été supprimé avec succès.");
        FacesContext.getCurrentInstance().addMessage(null, message);
          loadFilesForReunion(reunionId) ;

        
    } catch (IOException ex) {
        // Gérer les erreurs de suppression de fichier
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Une erreur s'est produite lors de la suppression du fichier.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        ex.printStackTrace();
    }
}

// Méthode utilitaire pour extraire l'ID de réunion à partir du nom de fichier

public void filtrerParDate() {
    filteredReunions = reunions.stream()
            .filter(reunion -> {
                LocalDateTime dateDebutFilter = getDateDebutFilter();
                LocalDateTime dateFinFilter = getDateFinFilter();
                LocalDateTime reunionDate = reunion.getDateDeb(); // Convertir Date en LocalDateTime
                return (dateDebutFilter == null || reunionDate.isAfter(dateDebutFilter) || reunionDate.isEqual(dateDebutFilter))
                        && (dateFinFilter == null || reunionDate.isBefore(dateFinFilter) || reunionDate.isEqual(dateFinFilter));
            })
            .collect(Collectors.toList());
}





 // Attribut pour stocker le fichier uploadé

    


}

     


   
