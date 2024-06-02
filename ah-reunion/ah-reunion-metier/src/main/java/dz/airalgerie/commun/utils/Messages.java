/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import java.io.Serializable;

/**
 *
 * @author Administrateur
 */
public abstract class Messages implements Serializable {

  private static final long serialVersionUID = 1L;

  // Common String for all class
  public static final String GENERIC_SUCCESS_SUMMARY = "Bravo !";
  public static final String GENERIC_ERROR = "Une erreur s'est produite, prière de réessayer.";
  public static final String GENERIC_UPDATE = "La mise à jour a été effectuée.";
  public static final String GENERIC_UPDATE_WARNING = "Attention!";
  // ClotureImmoBean
  // CompteGeneralBean
  public static final String ADD_COMPTE_GENERAL_SUCCESS = "Le compte général a bien été créé.";
  public static final String EDIT_COMPTE_GENERAL_SUCCESS = "Le compte général a bien été modifié.";
  public static final String DELETE_COMPTE_GENERAL_SUCCESS =
      "Le compte général a bien été supprimé.";
  public static final String ADD_EDIT_COMPTE_GENERAL_ERROR =
      "La taille du compte général doit être égale à 6 et doit contenir uniquement des nombres.";
  // JournalBean
  public static final String NO_DATE_SELECTED_ERROR =
      "Veuillez sélectionner un mois comptable avant de procéder à la recherche.";
  public static final String NO_JOURNAL_SELECTED_ERROR =
      "Veuillez sélectionner un journal comptable avant de procéder à la recherche.";
  public static final String ADD_ECRITURE_SUCCESS = "L'écriture a bien été saisie.";
  public static final String EDIT_ECRITURE_SUCCESS = "L'écriture a bien été modifiée.";
  public static final String ADD_ECRITURE_NO_COMPTE_COMPTABLE_ERROR =
      "Le compte comptable sélectionné n'existe pas dans le plan comptable.";
  public static final String ADD_ECRITURE_MONTANT_ZERO_ERROR =
      "Le montant de l'opération ne doit pas être égale à zéro.";
  public static final String DELETE_ECRITURE_SUCCESS = "L'écriture a bien été supprimée.";
  public static final String NOT_FREE_PAGE_ERROR =
      "La page est déjà réservée, veuillez choisir une autre page.";
  public static final String INVALID_PAGE__NUMBER_ERROR =
      "Le numéro de de page doit être superieur à 0.";
  // PlanComptableBean
  public static final String ADD_COMPTE_COMPTABLE_SUCCESS = "Le compte comptable a bien été créé.";
  public static final String EDIT_COMPTE_COMPTABLE_SUCCESS =
      "Le compte comptable a bien été modifié.";
  public static final String EXISTING_COMPTE_COMPTABLE_ERROR = "Le compte comptable déjà exist.";
  public static final String DELETE_COMPTE_COMPTABLE_SUCCESS =
      "Le compte comptable a bien été supprimé.";
  public static final String CLOSED_MOUNTH_ERROR = "Le mois sélectionné est déjà clôturé.";
  // Page journal comptable
  public static final String RESERVE_PAGE_SUCCESS = "La page a bien été réservée.";
  public static final String EDIT_RESERVE_PAGE_SUCCESS =
      "La réservation de la page a bien été modifiée.";
  public static final String DELETE_RESERVE_PAGE_SUCCESS = "La page a bien été libirée.";
  // TauxChangeBean
  public static final String UPLAODED_FILE_SUCCESS = "Le fichier a été importé avec succès.";
  public static final String DATA_INSERT_ERROR = "Erreur d'insertion des données dans la base.";
  public static final String UPLAODED_FILE_ERROR = "Erreur dans le fichier importé.";
  public static final String EXPORTATION_PDF_FILE_ERROR =
      "Erreur dans l'exportation de fichier PDF.";
  // Décision
  public static final String ADD_DECISION_SUCCESS = "La décision a bien été créée.";
  public static final String EDIT_DECISION_SUCCESS = "La décision a bien été modifiée.";
  public static final String DELETE_DECISION_SUCCESS = "La décision a bien été supprimée.";
  public static final String EXISTING_DECISION_REFERENCE_ERROR =
      "La reference de la décision existe déjà, veuillez saisir une autre référence.";
  // Documentation
  public static final String ADD_DOCUMENT_SUCCESS = "Le document a bien été créé.";
  public static final String EDIT_DOCUMENT_SUCCESS = "Le document a bien été modifié.";
  public static final String DELETE_DOCUMENT_SUCCESS = "Le document a bien été supprimé.";
  // Opération clôture && Clôture exercice
  public static final String ADD_OPERATION_SUCCESS = "L'opération a été ajoutée avec succès.";
  public static final String EDIT_OPERATION_SUCCESS = "L'opération a été modifiée avec succès.";
  public static final String DELETE_OPERATION_SUCCESS = "L'opération a bien été supprimée.";
  public static final String CLOTURE_EXERCICE_SUCCESS = "La clôture a été exécutée avec succès.";
  public static final String CLOTURE_EXERCICE_ERROR = "La clôture a généré des erreurs.";
  public static final String CANCEL_CLOTURE_EXERCICE_SUCCESS =
      "L'annulation de la clôture a été exécutée avec succès.";
  public static final String SIZE_COMPTE_COMPTABLE_ERROR = "La taille du compte est mauvaise.";
  public static final String EXISITING_ID_OPERATION_ERROR = "Le numéro de l'opération existe déjà.";
  // Reinitialisation de mot de passe
  public static final String PASSWORD_RESET_SUCCESS = "Votre mot de passe a été réinitialisé.";
  public static final String PASSWORD_RESET_EMAIL_NOT_FOUND_ERROR = "Email introuvable.";
  public static final String PASSWORD_RESET_EMAIL_SUBJECT = "Réinitialisation du mot de passe";
  public static final String CONFIRMATION_CODE_PASSWORD_RESET_EMAIL_SUBJECT =
      "Code de confirmation";
  // Inscription portail applicatif
  public static final String INSCRIPTION_CODE_PASSWORD_EMAIL_SUBJECT = "Code d'inscription";
  public static final String INSCRIPTION_USER_FOUND_ERROR =
      "Vous êtes déjà inscrit, veuillez vérifier votre matricule ou email ";
  public static final String INSCRIPTION_USER_EMAIL_ERROR =
      "Veuillez utiliser une adresse email compagnie  @airalgerie.dz ";
  public static final String INSCRIPTION_USER_EMAIL_NOT_FOUND_ERROR =
      "Votre demande d'inscription est introuvable , veuillez réessayer à nouveau";
  public static final String INSCRIPTION_USER_MATRICULE_NOT_FOUND_ERROR =
      "Le Matricule introduit est introuvable  ,veuillez réessayer à nouveau";
  public static final String INSCRIPTION_USER_SUCCESS = "Votre inscription a bien été effectuée.";
  public static final String INSCRIPTION_USER_MATRICULE_MAIL_FOUND_ERROR =
      "Un problème d'identification est survenu ,veuillez contacter le HelpDesk";
  public static final String INSCRIPTION_USER_CODE_FOUND_ERROR = "Le code d'inscription est erroné";
  public static final String INSCRIPTION_USER_CODE_FOUND_EXPIRED =
      "Le code d'inscription est expiré, veuillez demander un autre code";
  public static final String INSCRIPTION_USER_PASSWORD_ERROR_IDENTIFICATION =
      "Les mots de passe ne sont pas identiques";
  public static final String INSCRIPTION_USER_PASSWORD_ERROR_EXIGENCES =
      "Votre mot de passe ne répond pas aux exigences";
  // SuiviEtktBean
  public static final String ETKT_NOT_FOUND = "Ce billet n'est pas archivé.";
  public static final String ETKT_COMPENSATION_ACCORD = "Ce billet a reçu une compensation.";
  public static final String ETKT_COMPENSATION_REFUS =
      "La compensation pour ce billet a été refusée.";
  public static final String ETKT_COMPENSATION_PENDING =
      "Le traitement de la compensation pour ce billet est en cours{0} {1}...{2}";
  public static final String ETKT_TRT_AMADEUS_PENDING =
      "Ce billet a été transmis à AMADEUS pour désarchivage.";
  public static final String ETKT_TRT_AMADEUS_OK = "Ce billet a été désarchivé sur AMADEUS.";
  public static final String ETKT_COMPENSATION_PENDING_DOCUMENT =
      " , En attente du document de compensation.";
  public static final String ETKT_COMPENSATION_PENDING_UNITE = " par une autre unité";
  public static final String ETKT_COMPENSATION_OPEN =
      "Ce billet n’a pas fait l’objet d’une demande de compensation, veuillez adresser une demande aux services concernés.";
  public static final String ETKT_COMPENSATION_CLOSE =
      "Ce billet est inéligible pour la compensation.";
  public static final String ETKT_COMPENSATION_VALIDATION_SUCCESS =
      "La compensation a été accordée.";
  public static final String ETKT_COMPENSATION_VALIDATION_FAILED =
      "Prière de renseinger les champs nécessaires à l'accord d'une compensation.";
  public static final String ETKT_COMPENSATION_REFUS_SUCCESS = "La compensation a été refusée.";
  public static final String ETKT_COMPENSATION_REFUS_FAILED =
      "Prière de renseinger les champs nécessaires, notamment le motif de refus de la compensation.";
  public static final String ETKT_REFUND_IN_SYGA = "Ce billet a été déjà remboursé sur SYGA.";
  public static final String ETKT_SEARCH_ERROR =
      "Prière de renseinger le PNR ou nom et prénoms du pax ";
  public static final String ETKT_CODE_AGENCE = "Prière de vérifier votre code agence.";
  public static final String ETKT_FULL_REFUND =
      "Prière de vérifier le Montant Hors-Taxes , il s'agit d'un remboursement intégral (Full Refund)";
  public static final String ETKT_TAXES_ERROR = "Prière de vérifier le format des taxes";
  // SuiviEmdBean
  public static final String EMD_NOT_FOUND = "Ce billet n'est pas archivé.";
  public static final String EMD_COMPENSATION_ACCORD = "Ce billet a reçu une compensation.";
  public static final String EMD_COMPENSATION_REFUS =
      "La compensation pour ce billet a été refusée.";
  public static final String EMD_COMPENSATION_PENDING =
      "Le traitement de la compensation pour ce billet est en cours{0} {1}... {2}";
  public static final String EMD_COMPENSATION_PENDING_DOCUMENT =
      " , En attente du document de compensation.";
  public static final String EMD_COMPENSATION_PENDING_UNITE = " par une autre unité";
  public static final String EMD_COMPENSATION_OPEN =
      "Ce billet n’a pas fait l’objet d’une demande de compensation, veuillez adresser une demande aux services concernés.";
  public static final String EMD_COMPENSATION_CLOSE =
      "Ce billet est inéligible pour la compensation.";
  public static final String EMD_COMPENSATION_VALIDATION_SUCCESS =
      "La compensation a été accordée.";
  public static final String EMD_COMPENSATION_VALIDATION_FAILED =
      "Prière de renseinger les champs nécessaires à l'accord d'une compensation.";
  public static final String EMD_COMPENSATION_REFUS_SUCCESS = "La compensation a été refusée.";
  public static final String EMD_COMPENSATION_REFUS_FAILED =
      "Prière de renseinger les champs nécessaires, notamment le motif de refus de la compensation.";
  public static final String EMD_REFUND_IN_SYGA = "Ce billet a été déjà remboursé sur SYGA.";
  public static final String EMD_SEARCH_ERROR =
      "Prière de renseinger le PNR ou nom et prénoms du pax ";
  public static final String EMD_CODE_AGENCE = "Prière de vérifier votre code agence.";
  public static final String EMD_FULL_REFUND =
      "Prière de vérifier le Montant Hors-Taxes , il s'agit d'un remboursement intégral (Full Refund)";
  // ApplicationBean
  public static final String MANIFEST_PATH = "/META-INF/MANIFEST.MF";
  public static final String EDIT_RELIQUATS_CONGE_SUCCESS =
      "Le reliquat de conge a bien été modifié.";
  public static final String ADD_UNITE_CU_SUCCESS = "Les données de l'unité ont bien été créées.";
  public static final String DELETE_UNITE_CU_SUCCESS = "Les données de l'unité ont bien été supprimées.";
  public static final String EDIT_UNITE_CU_SUCCESS = "Les données de l'unité ont bien été modifiées.";
  public static final String ADD_JOURNAL_UNITE_SUCCESS = "Le journal a bien été créé.";
  public static final String DELETE_JOURNAL_UNITE_SUCCESS = "Le journal a bien été supprimé.";
  public static final String EDIT_JOURNAL_UNITE_SUCCESS = "Le journal a bien été modifié.";
  public static final String DELETE_ORGANISME_SUCCESS = "L'organisme a bien été supprimé.";
  public static final String ADD_ORGANISME_SUCCESS = "L'organisme a bien été créé.";
  public static final String EXISTING_ORGANISME_ERROR = "L'organisme déjà exist.";
  public static final String EDIT_ORGANISME_SUCCESS = "L'organisme a bien été modifié.";
  public static final String EXISTING_CLIENT_BY_ID_ORGANISME_ERROR =
      "Prière de supprimer les clients qui appartiennent a cet organisme en premier lieu";
  public static final String EXISTING_FOURNISSEUR_BY_ID_ORGANISME_ERROR =
      "Prière de supprimer les fournisseurs qui appartiennent a cet organisme en premier lieu ";
  // Facturation
  public static final String ADD_FACTURE_SUCCESS = "La facture a bien été créée.";
  public static final String DELETE_FACTURE_SUCCESS = "La facture a bien été supprimée.";
  public static final String TRANSFERT_FACTURE_SUCCESS = "L'item a été transféré avec succès.";
  // INACTIVITE
  public static final String ADD_INACTIVITE_SUCCESS = "L'enregistrement a bien été créée.";
  public static final String EDIT_INACTIVITE_SUCCESS = "L'enregistrement a bien été modifiée.";
  public static final String DELETE_INACTIVITE_SUCCESS = "L'enregistrement a bien été supprimé.";
  public static final String EXISTING_INACTIVITE_ERROR = "L'enregistrement déjà exist.";
  public static final String INACTIVITE_DATE_CERTIFICAT_ERROR =
      "La date du certificat est supérieure à la date actuelle.";
  public static final String INACTIVITE_DATE_RECEPTION_ERROR =
      "La date de réception est supérieure à la date actuelle.";
  public static final String INACTIVITE_DATE_DEBUT_ERROR =
      "La date de début est supérieure à la date actuelle.";
  public static final String INACTIVITE_DATE_ACCIDENT_TRAVAIL_ERROR =
      "La date de l'accident de travail est supérieure à la date actuelle";
  public static final String INACTIVITE_MATERNITE_ERROR =
      "L'ajout d'un congé de maternité est valable exclusivement pour le personnel femenin , Prière de vérifier le sexe de l'employer  ";
  public static final String DELETE_INACTIVITE_ERROR =
      "Supression impossible , l'enregistrement possède des prolongations postérieurs";
  public static final String EXISTING_DATE_BETWEEN_INACTIVITE_ERROR =
      "La date début ou date fin , est inclus entre la date debut et la date fin d'un autre enregistrement de meme categorie.";

}
