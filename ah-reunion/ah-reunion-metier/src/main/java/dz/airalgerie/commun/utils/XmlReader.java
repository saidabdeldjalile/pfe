/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import dz.airalgerie.commun.helper.ftp.FtpConfig;
import dz.airalgerie.grh.model.dto.carriere.Profil;
import dz.airalgerie.grh.model.entities.carriere.Signalitique;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Diaf
 */
public class XmlReader {

  final private static SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");

  public XmlReader() {

  }


  public static void copyXmlProfilFromFtp(Integer Matricule, FtpConfig FtpConfigGRH) {

    try {
      String relativeWebPath = "/resources";
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      String path = absoluteDiskPath + "/profilsXML/";
      absoluteDiskPath += "/profilsXML/" + Matricule + ".xml";

      if (absoluteDiskPath != null && !Files.exists(Paths.get(absoluteDiskPath))) {
        Files.createDirectories(Paths.get(path));
        String destPath = "/profils/" + Matricule + ".xml";

        FTP.copyFromFTP(destPath, path, FtpConfigGRH);

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void wrightStatus(Integer Matricule, String tagName, boolean status) {

    try {
      String relativeWebPath = "/resources/profilsXML/" + Matricule + ".xml";
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      if (Files.exists(Paths.get(absoluteDiskPath))) {

        InputSource is = new InputSource(new FileInputStream(new File(absoluteDiskPath)));
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(is);

        Element element = doc.getDocumentElement();
        Element nom = null;
        try {
          nom = (Element) element.getElementsByTagName(tagName).item(0);
        } catch (Exception e) {
        }

        if (nom == null && (tagName.equals("Antecedent") || tagName.equals("Carriere")
            || tagName.equals("Discipline"))) {
          nom = doc.createElement(tagName);
          element.appendChild(nom);
        }

        nom.setAttribute("status", String.valueOf(status));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(absoluteDiskPath));
        transformer.transform(source, result);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Profil read(Integer mat) {
    try {
      Profil xmlProfile = new Profil();
      xmlProfile.setUpdatedFields(new ArrayList<String>());
      String relativeWebPath = "/resources";
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      absoluteDiskPath += "/profilsXML/" + mat + ".xml";

      if (absoluteDiskPath != null) {
        if (Files.exists(Paths.get(absoluteDiskPath))) {
          InputSource is = new InputSource(new FileInputStream(new File(absoluteDiskPath)));

          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(is);
          NodeList infos = doc.getElementsByTagName("InformationsPersonnelles");
          for (int i = 0; i < infos.getLength(); i++) {
            Element element = (Element) infos.item(i);
            String status = element.getAttribute("status");
            Element nom = (Element) element.getElementsByTagName("Nom").item(0);
            Element prenom = (Element) element.getElementsByTagName("PreNom").item(0);
            Element NomDeJeuneFille =
                (Element) element.getElementsByTagName("NomDeJeuneFille").item(0);
            Element nationalite = (Element) element.getElementsByTagName("Nationalite").item(0);
            Element sexe = (Element) element.getElementsByTagName("Sexe").item(0);
            Element dateNaiss = (Element) element.getElementsByTagName("DateDeNaissance").item(0);
            Element lieuNaiss = (Element) element.getElementsByTagName("LieuDeNaissance").item(0);
            Element PaysDeNaissance =
                (Element) element.getElementsByTagName("PaysDeNaissance").item(0);
            Element SitFam = (Element) element.getElementsByTagName("SituationFamiliale").item(0);
            Element Photo = (Element) element.getElementsByTagName("Photo").item(0);
            Element FicheFamiliale =
                (Element) element.getElementsByTagName("FicheFamiliale").item(0);
            Element ActeDeNaissance =
                (Element) element.getElementsByTagName("ActeDeNaissance").item(0);

            if (status != null && status.equals("true")) {
              xmlProfile.setInfosStatus(true);
            } else {
              xmlProfile.setInfosStatus(false);
            }

            if (PaysDeNaissance != null && PaysDeNaissance.getAttribute("status").equals("true")) {
              xmlProfile.setPaysNaiss(PaysDeNaissance.getAttribute("value"));
              xmlProfile.setPaysNaissCode(PaysDeNaissance.getAttribute("code"));
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("PaysDeNaissance");
              }
            }

            if (nom != null && nom.getAttribute("status").equals("true")) {
              xmlProfile.setNom(nom.getAttribute("value"));
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("Nom");
              }
            }
            if (prenom != null && prenom.getAttribute("status").equals("true")) {
              xmlProfile.setPrenom(prenom.getAttribute("value"));
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("PreNom");
              }
            }
            if (NomDeJeuneFille != null && NomDeJeuneFille.getAttribute("status").equals("true")) {
              xmlProfile.setNomDeJeuneFille(NomDeJeuneFille.getAttribute("value"));
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("NomDeJeuneFille");
              }
            }

            if (nationalite != null && nationalite.getAttribute("status").equals("true")) {
              xmlProfile.setNationalite(nationalite.getAttribute("value"));
              xmlProfile.setCodeNationalite(nationalite.getAttribute("code"));
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("Nationalite");
              }
            }
            if (sexe != null && sexe.getAttribute("status").equals("true")) {
              xmlProfile.setSexe(sexe.getAttribute("value"));
              xmlProfile.setSexeCode(sexe.getAttribute("code"));
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("Sexe");
              }
            }
            if (lieuNaiss != null && lieuNaiss.getAttribute("status").equals("true")) {
              xmlProfile.setLieuNaiss(lieuNaiss.getAttribute("value"));
              xmlProfile.setCodeLieuNaiss(lieuNaiss.getAttribute("code"));
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("LieuDeNaissance");
              }
            }
            if (SitFam != null && SitFam.getAttribute("status").equals("true")) {
              xmlProfile.setSitFam(SitFam.getAttribute("value"));
              xmlProfile.setSitFamCode(SitFam.getAttribute("code"));
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("SituationFamiliale");
              }
            }

            if (dateNaiss != null && dateNaiss.getAttribute("status").equals("true")) {
              try {
                xmlProfile.setDateNaiss(f1.parse(dateNaiss.getAttribute("value")));
              } catch (Exception e) {
              }
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("DateDeNaissance");
              }
            }

            if (Photo != null && Photo.getAttribute("status").equals("true")) {
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("Photo");
              }
            }

            if (FicheFamiliale != null && FicheFamiliale.getAttribute("status").equals("true")) {
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("FicheFamiliale");
              }
            }

            if (FicheFamiliale != null && FicheFamiliale.getAttribute("phase2").equals("true")) {
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("FicheFamilialeP2");
              }
            }

            if (ActeDeNaissance != null && ActeDeNaissance.getAttribute("status").equals("true")) {
              if (xmlProfile.isInfosStatus()) {
                xmlProfile.getUpdatedFields().add("ActeDeNaissance");
              }
            }

          }

          NodeList contact = doc.getElementsByTagName("Contact");
          for (int i = 0; i < contact.getLength(); i++) {

            Element element = (Element) contact.item(i);
            String status = element.getAttribute("status");
            Element tel = (Element) element.getElementsByTagName("Telephone").item(0);
            Element mob = (Element) element.getElementsByTagName("Mobile").item(0);
            Element fax = (Element) element.getElementsByTagName("Fax").item(0);
            Element quatechifres = (Element) element.getElementsByTagName("QuatreChifre").item(0);
            Element ligneIp = (Element) element.getElementsByTagName("LigneIP").item(0);
            Element email = (Element) element.getElementsByTagName("Email").item(0);
            Element adresse = (Element) element.getElementsByTagName("Adresse").item(0);
            Element codePostal = (Element) element.getElementsByTagName("CodePostal").item(0);
            Element CertificatDeResidence =
                (Element) element.getElementsByTagName("CertificatDeResidence").item(0);

            if (status != null && status.equals("true")) {
              xmlProfile.setContactStatus(true);
            } else {
              xmlProfile.setContactStatus(false);
            }

            if (tel != null && tel.getAttribute("status").equals("true")) {
              xmlProfile.setTel(tel.getAttribute("value"));
              // if (xmlProfile.isContactStatus()) {
              // xmlProfile.getUpdatedFields().add("Telephone");
              // }
            }

            if (mob != null && mob.getAttribute("status").equals("true")) {
              xmlProfile.setMobile(mob.getAttribute("value"));
              // if (xmlProfile.isContactStatus()) {
              // xmlProfile.getUpdatedFields().add("Mobile");
              // }
            }

            if (email != null && email.getAttribute("status").equals("true")) {
              xmlProfile.setEmail(email.getAttribute("value"));
              // if (xmlProfile.isContactStatus()) {
              // xmlProfile.getUpdatedFields().add("Email");
              // }
            }
            if (fax != null && fax.getAttribute("status").equals("true")) {
              xmlProfile.setFax(fax.getAttribute("value"));
              // if (xmlProfile.isContactStatus()) {
              // xmlProfile.getUpdatedFields().add("Fax");
              // }
            }
            if (quatechifres != null && quatechifres.getAttribute("status").equals("true")) {
              xmlProfile.setQuatechifres(quatechifres.getAttribute("value"));
              // if (xmlProfile.isContactStatus()) {
              // xmlProfile.getUpdatedFields().add("QuatreChifre");
              // }
            }
            if (ligneIp != null && ligneIp.getAttribute("status").equals("true")) {
              xmlProfile.setLigneIp(ligneIp.getAttribute("value"));
              // if (xmlProfile.isContactStatus()) {
              // xmlProfile.getUpdatedFields().add("LigneIP");
              // }
            }
            if (adresse != null && adresse.getAttribute("status").equals("true")) {
              xmlProfile.setAdresse(adresse.getAttribute("value"));
              if (xmlProfile.isContactStatus()) {
                xmlProfile.getUpdatedFields().add("Adresse");
              }
            }

            if (codePostal != null && codePostal.getAttribute("status").equals("true")) {
              xmlProfile.setCodePostal(codePostal.getAttribute("value"));
              if (xmlProfile.isContactStatus()) {
                xmlProfile.getUpdatedFields().add("CodePostal");
              }
            }

            if (CertificatDeResidence != null
                && CertificatDeResidence.getAttribute("status").equals("true")) {
              if (xmlProfile.isContactStatus()) {
                xmlProfile.getUpdatedFields().add("CertificatDeResidence");
              }
            }

          }
          xmlProfile.setMatricule(mat);
        }
      }
      return xmlProfile;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

  public static List<String> readBlocksEnAttenteList(Integer mat) {
    try {
      List<String> Blocks = new ArrayList<>();
      String relativeWebPath = "/resources/profilsXML/" + mat + ".xml";
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      if (absoluteDiskPath != null) {
        if (Files.exists(Paths.get(absoluteDiskPath))) {
          InputSource is = new InputSource(new FileInputStream(new File(absoluteDiskPath)));

          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(is);
          NodeList infos = null;

          infos = doc.getElementsByTagName("InformationsPersonnelles");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Informations personnelles");
            }
          }
          infos = doc.getElementsByTagName("Contact");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Contact");
            }
          }
          infos = doc.getElementsByTagName("Etudes");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")
                && !Blocks.contains("Etudes et formations")) {
              Blocks.add("Etudes et formations");
            }
          }
          infos = doc.getElementsByTagName("Formations");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")
                && !Blocks.contains("Etudes et formations")) {
              Blocks.add("Etudes et formations");
            }
          }
          infos = doc.getElementsByTagName("ServiceMilitaire");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Service militaire");
            }
          }
          infos = doc.getElementsByTagName("ActivitesSyndicales");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Activités syndicales");
            }
          }
          infos = doc.getElementsByTagName("Conjoint");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Conjoint");
            }
          }
          infos = doc.getElementsByTagName("Parents");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Parents");
            }
          }
          infos = doc.getElementsByTagName("Enfants");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Enfants");
            }
          }
          infos = doc.getElementsByTagName("Carriere");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Carrière");
            }
          }
          infos = doc.getElementsByTagName("Discipline");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Discipline");
            }
          }
          infos = doc.getElementsByTagName("Antecedent");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")) {
              Blocks.add("Antécédents professionnels");
            }
          }
          infos = doc.getElementsByTagName("diplomesFormations");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")
                && !Blocks.contains("Etudes et formations")) {
              Blocks.add("Etudes et formations");
            }
          }
          infos = doc.getElementsByTagName("diplomesEtudes");
          if (infos != null && infos.getLength() > 0) {
            if (((Element) infos.item(0)).getAttribute("status").equals("true")
                && !Blocks.contains("Etudes et formations")) {
              Blocks.add("Etudes et formations");
            }
          }

          return Blocks;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }


  public static void createNewDoc(Integer matricule, FtpConfig FtpConfigGRH) {

    try {
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String relativeWebPath = "/resources";
      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      String path = absoluteDiskPath + "/profilsXML/";
      absoluteDiskPath = path + matricule + ".xml";

      if (absoluteDiskPath != null) {
        if (!Files.exists(Paths.get(absoluteDiskPath))) {
          org.dom4j.Document document = DocumentHelper.createDocument();
          org.dom4j.Element root = document.addElement("Profile").addAttribute("valide", "false");
          // org.dom4j.Element subElement = root.addElement("InformationsPersonnelles")
          // .addAttribute("status", "false");

          root.addElement("InformationsPersonnelles").addAttribute("status", "false")
              .addElement("Nom").addAttribute("status", "false").addAttribute("value", "")
              .getParent().addElement("PreNom").addAttribute("status", "false")
              .addAttribute("value", "").getParent().addElement("NomDeJeuneFille")
              .addAttribute("status", "false").addAttribute("value", "").getParent()
              .addElement("DateDeNaissance").addAttribute("status", "false")
              .addAttribute("value", "").getParent().addElement("LieuDeNaissance")
              .addAttribute("status", "false").addAttribute("value", "").addAttribute("code", "")
              .getParent().addElement("PaysDeNaissance").addAttribute("status", "false")
              .addAttribute("value", "").addAttribute("code", "").getParent()
              .addElement("Nationalite").addAttribute("status", "false").addAttribute("value", "")
              .addAttribute("code", "").getParent().addElement("Sexe")
              .addAttribute("status", "false").addAttribute("value", "").addAttribute("code", "")
              .getParent().addElement("SituationFamiliale").addAttribute("status", "false")
              .addAttribute("value", "").addAttribute("code", "").getParent().addElement("Photo")
              .addAttribute("status", "false").getParent().addElement("FicheFamiliale")
              .addAttribute("status", "false").addAttribute("phase2", "false").getParent()
              .addElement("ActeDeNaissance").addAttribute("status", "false");

          root.addElement("Contact").addAttribute("status", "false").addElement("Telephone")
              .addAttribute("status", "false").addAttribute("value", "").getParent()
              .addElement("Mobile").addAttribute("status", "false").addAttribute("value", "")
              .getParent().addElement("Fax").addAttribute("status", "false")
              .addAttribute("value", "").getParent().addElement("QuatreChifre")
              .addAttribute("status", "false").addAttribute("value", "").getParent()
              .addElement("LigneIP").addAttribute("status", "false").addAttribute("value", "")
              .getParent().addElement("Email").addAttribute("status", "false")
              .addAttribute("value", "").getParent().addElement("Adresse")
              .addAttribute("status", "false").addAttribute("value", "").getParent()
              .addElement("CodePostal").addAttribute("status", "false").addAttribute("value", "")
              .getParent().addElement("CertificatDeResidence").addAttribute("status", "false");

          root.addElement("Etudes").addAttribute("status", "false").addAttribute("Niveau", "")
              .addAttribute("Date", "");

          root.addElement("Formations").addAttribute("status", "false");
          root.addElement("ServiceMilitaire").addAttribute("status", "false");
          root.addElement("ActivitesSyndicales").addAttribute("status", "false");
          root.addElement("Conjoint").addAttribute("status", "false");
          root.addElement("Parents").addAttribute("status", "false");
          root.addElement("Enfants").addAttribute("status", "false");
          root.addElement("PersonnesACharge").addAttribute("status", "false");
          root.addElement("Carriere").addAttribute("status", "false");
          root.addElement("Antecedent").addAttribute("status", "false");
          FileOutputStream fos = new FileOutputStream(absoluteDiskPath);

          OutputFormat format = OutputFormat.createPrettyPrint();
          XMLWriter writer = new XMLWriter(fos, format);
          writer.write(document);
          writer.flush();
          fos.close();
          writer.close();
          try {
            String destPath = "/profils/";
            FTP.copyToFTP(absoluteDiskPath, destPath, matricule + ".xml", FtpConfigGRH);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String getTagAttribute(Integer matricule, String tagName, String AttributeName) {
    try {
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String relativeWebPath = "/resources";
      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      absoluteDiskPath += "/profilsXML/" + matricule + ".xml";
      if (Files.exists(Paths.get(absoluteDiskPath))) {
        InputSource is = new InputSource(new FileInputStream(new File(absoluteDiskPath)));
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(is);

        NodeList elementList = doc.getElementsByTagName(tagName);
        if (elementList != null) {
          Element element = (Element) elementList.item(0);
          if (element != null) {
            return element.getAttribute(AttributeName);
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void editTagAttribute(Integer matricule, String tagName, String AttributeName,

      String AttributeValue, FtpConfig FtpConfigGRH) {

    try {
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String relativeWebPath = "/resources";
      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      absoluteDiskPath += "/profilsXML/" + matricule + ".xml";
      if (!Files.exists(Paths.get(absoluteDiskPath))) {
        createNewDoc(matricule, FtpConfigGRH);
      }
      InputSource is = new InputSource(new FileInputStream(new File(absoluteDiskPath)));
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(is);

      NodeList elementList = doc.getElementsByTagName(tagName);
      if (elementList != null && elementList.getLength() > 0) {
        Element element = (Element) elementList.item(0);

        element.setAttribute(AttributeName, AttributeValue);
      } else {
        Element element = doc.createElement(tagName);
        element.setAttribute(AttributeName, AttributeValue);
        doc.getDocumentElement().appendChild(element);
      }

      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

      // initialize StreamResult with File object to save to file
      StreamResult result = new StreamResult(new File(absoluteDiskPath));
      DOMSource source = new DOMSource(doc);
      transformer.transform(source, result);
      try {
        String destPath = "/profils/";
        FTP.copyToFTP(absoluteDiskPath, destPath, matricule + ".xml", FtpConfigGRH);
      } catch (Exception e) {
        e.printStackTrace();
      }

    } catch (Exception e) {
      System.out.println(tagName);
      System.out.println(AttributeName);
      System.out.println(AttributeValue);
      e.printStackTrace();
    }
  }


  public static void createNewDoc(Profil profile, Signalitique s, String CodeSitFam,
      FtpConfig FtpConfigGRH) {

    try {
      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String relativeWebPath = "/resources";
      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      absoluteDiskPath += "/profilsXML/" + profile.getMatricule() + ".xml";

      org.dom4j.Document document = DocumentHelper.createDocument();
      org.dom4j.Element root = document.addElement("Profile");
      // org.dom4j.Element subElement = root.addElement("InformationsPersonnelles")
      // .addAttribute("status", "false");

      String tel = "";
      String Mobile = "";
      String Fax = "";
      String QuatreChifre = "";
      String LigneIP = "";
      String Email = "";
      String Adresse = "";
      String CodePostal = "";
      String Nationalite = "";
      String LieuDeNaissance = "";
      String PaysDeNaissance = "";
      if (s.getLIEU_NAIS() != null) {
        LieuDeNaissance = s.getLIEU_NAIS().getLibelle();
      }
      if (s.getPays() != null) {
        PaysDeNaissance = s.getPays().getLibelle();
      }

      if (s.getNationalite() != null) {
        Nationalite = s.getNationalite().getLibelle();
      }
      if (s.getContact() != null) {
        tel = s.getContact().getLIGNE_DIRECTE();
        Mobile = s.getContact().getMOBILE();
        Fax = s.getContact().getFAX();
        QuatreChifre = s.getContact().getQUATRE_CHIFFRE();
        LigneIP = s.getContact().getLIGNE_IP();
        Email = s.getContact().getMAIL() != null ? s.getContact().getMAIL() : "";
        Adresse = s.getContact().getADRESSE();
        CodePostal = s.getCodePostal();

      }

      /**
       * *******************
       */
      Boolean nom = false;
      Boolean prenom = false;
      Boolean NomDeJeuneFille = false;
      Boolean nationalite = false;
      Boolean sexe = false;
      Boolean dateNaiss = false;
      Boolean lieuNaiss = false;
      Boolean paysNaiss = false;
      Boolean SitFam = false;
      Boolean adresseS = false;
      Boolean codePostalS = false;
      Boolean FicheFamiliale = false;
      Boolean FicheFamilialeP2 = false;
      Boolean CertificatDeResidence = false;
      Boolean ActeDeNaissance = false;
      Boolean Photo = false;
      //

      if (Files.exists(Paths.get(absoluteDiskPath))) {
        try {
          InputSource is = new InputSource(new FileInputStream(new File(absoluteDiskPath)));
          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = dbf.newDocumentBuilder();
          Document doc = db.parse(is);
          NodeList infos = doc.getElementsByTagName("InformationsPersonnelles");
          NodeList contact = doc.getElementsByTagName("Contact");
          NodeList formationNode = doc.getElementsByTagName("Formations");

          if (contact != null) {
            Element element = (Element) contact.item(0);
            adresseS = Boolean.valueOf(
                ((Element) element.getElementsByTagName("Adresse").item(0)).getAttribute("status"));
            codePostalS =
                Boolean.valueOf(((Element) element.getElementsByTagName("CodePostal").item(0))
                    .getAttribute("status"));
            CertificatDeResidence = Boolean
                .valueOf(((Element) element.getElementsByTagName("CertificatDeResidence").item(0))
                    .getAttribute("status"));
          }

          if (infos != null) {
            Element element = (Element) infos.item(0);
            nom = Boolean.valueOf(
                ((Element) element.getElementsByTagName("Nom").item(0)).getAttribute("status"));
            prenom = Boolean.valueOf(
                ((Element) element.getElementsByTagName("PreNom").item(0)).getAttribute("status"));
            NomDeJeuneFille =
                Boolean.valueOf(((Element) element.getElementsByTagName("NomDeJeuneFille").item(0))
                    .getAttribute("status"));
            nationalite =
                Boolean.valueOf(((Element) element.getElementsByTagName("Nationalite").item(0))
                    .getAttribute("status"));
            sexe = Boolean.valueOf(
                ((Element) element.getElementsByTagName("Sexe").item(0)).getAttribute("status"));
            dateNaiss =
                Boolean.valueOf(((Element) element.getElementsByTagName("DateDeNaissance").item(0))
                    .getAttribute("status"));
            lieuNaiss =
                Boolean.valueOf(((Element) element.getElementsByTagName("LieuDeNaissance").item(0))
                    .getAttribute("status"));
            paysNaiss =
                Boolean.valueOf(((Element) element.getElementsByTagName("LieuDeNaissance").item(0))
                    .getAttribute("status"));
            SitFam = Boolean
                .valueOf(((Element) element.getElementsByTagName("SituationFamiliale").item(0))
                    .getAttribute("status"));
            FicheFamiliale =
                Boolean.valueOf(((Element) element.getElementsByTagName("FicheFamiliale").item(0))
                    .getAttribute("status"));
            FicheFamilialeP2 =
                Boolean.valueOf(((Element) element.getElementsByTagName("FicheFamiliale").item(0))
                    .getAttribute("phase2"));
            ActeDeNaissance =
                Boolean.valueOf(((Element) element.getElementsByTagName("ActeDeNaissance").item(0))
                    .getAttribute("status"));
            Photo = Boolean.valueOf(
                ((Element) element.getElementsByTagName("Photo").item(0)).getAttribute("status"));
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

        Files.delete(Paths.get(absoluteDiskPath));
      }

      /**
       * *******************
       */
      if (s.getNjfille() == null) {
        s.setNjfille("");
      }
      root.addElement("InformationsPersonnelles")
          .addAttribute("status",
              !nom && s.getNom().equals(profile.getNom()) && !prenom
                  && s.getPrenoms().equals(profile.getPrenom()) && !NomDeJeuneFille
                  && s.getNjfille().equals(profile.getNomDeJeuneFille()) && !dateNaiss
                  && s.getDateNais().equals(profile.getDateNaiss()) && !lieuNaiss
                  && LieuDeNaissance.equals(profile.getLieuNaiss()) && !paysNaiss
                  && PaysDeNaissance.equals(profile.getPaysNaiss()) && !nationalite
                  && Nationalite.equals(profile.getNationalite()) && !sexe
                  && s.getSexe().equals((Character) profile.getSexeCode().charAt(0)) && !SitFam
                  && CodeSitFam.equals(profile.getSitFamCode()) && !FicheFamiliale
                  && !FicheFamilialeP2 && !ActeDeNaissance && !Photo ? "false" : "true")
          .addElement("Nom")
          .addAttribute("status", !nom && s.getNom().equals(profile.getNom()) ? "false" : "true")
          .addAttribute("value", profile.getNom()).getParent().addElement("PreNom")
          .addAttribute("status",
              !prenom && s.getPrenoms().equals(profile.getPrenom()) ? "false" : "true")
          .addAttribute("value", profile.getPrenom()).getParent().addElement("NomDeJeuneFille")
          .addAttribute("status",
              !NomDeJeuneFille && s.getNjfille().equals(profile.getNomDeJeuneFille()) ? "false"
                  : "true")
          .addAttribute("value", profile.getNomDeJeuneFille()).getParent()
          .addElement("DateDeNaissance")
          .addAttribute("status",
              !dateNaiss && s.getDateNais().equals(profile.getDateNaiss()) ? "false" : "true")
          .addAttribute("value", f1.format(profile.getDateNaiss())).getParent()
          .addElement("LieuDeNaissance")
          .addAttribute("status",
              !lieuNaiss && LieuDeNaissance.equals(profile.getLieuNaiss()) ? "false" : "true")
          .addAttribute("value", profile.getLieuNaiss())
          .addAttribute("code", profile.getCodeLieuNaiss()).getParent()
          .addElement("PaysDeNaissance")
          .addAttribute("status",
              !paysNaiss && PaysDeNaissance.equals(profile.getPaysNaiss()) ? "false" : "true")
          .addAttribute("value", profile.getPaysNaiss())
          .addAttribute("code", profile.getPaysNaissCode()).getParent().addElement("Nationalite")
          .addAttribute("status",
              !nationalite && Nationalite.equals(profile.getNationalite()) ? "false" : "true")
          .addAttribute("value", profile.getNationalite())
          .addAttribute("code", profile.getCodeNationalite()).getParent().addElement("Sexe")
          .addAttribute("status",
              !sexe && s.getSexe().equals((Character) profile.getSexeCode().charAt(0)) ? "false"
                  : "true")
          .addAttribute("value", profile.getSexe()).addAttribute("code", profile.getSexeCode())
          .getParent().addElement("SituationFamiliale")
          .addAttribute("status",
              !SitFam && CodeSitFam.equals(profile.getSitFamCode()) ? "false" : "true")
          .addAttribute("value", profile.getSitFam()).addAttribute("code", profile.getSitFamCode())
          .getParent().addElement("Photo").addAttribute("status", !Photo ? "false" : "true")
          .getParent().addElement("FicheFamiliale")
          .addAttribute("status", !FicheFamiliale ? "false" : "true")
          .addAttribute("phase2", !FicheFamilialeP2 ? "false" : "true").getParent()
          .addElement("ActeDeNaissance")
          .addAttribute("status", !ActeDeNaissance ? "false" : "true");

      root.addElement("Contact")
          .addAttribute("status",
              !adresseS && profile.getAdresse() != null && Adresse.equals(profile.getAdresse())
                  && !codePostalS && profile.getCodePostal() != null
                  && CodePostal.equals(profile.getCodePostal()) && !CertificatDeResidence ? "false"
                      : "true")
          .addElement("Telephone")
          .addAttribute("status", tel.equals(profile.getTel()) ? "false" : "true")
          .addAttribute("value", profile.getTel()).getParent().addElement("Mobile")
          .addAttribute("status", Mobile.equals(profile.getMobile()) ? "false" : "true")
          .addAttribute("value", profile.getMobile()).getParent().addElement("Fax")
          .addAttribute("status", Fax.equals(profile.getFax()) ? "false" : "true")
          .addAttribute("value", profile.getFax()).getParent().addElement("QuatreChifre")
          .addAttribute("status", QuatreChifre.equals(profile.getQuatechifres()) ? "false" : "true")
          .addAttribute("value", profile.getQuatechifres()).getParent().addElement("LigneIP")
          .addAttribute("status", LigneIP.equals(profile.getLigneIp()) ? "false" : "true")
          .addAttribute("value", profile.getLigneIp()).getParent().addElement("Email")
          .addAttribute("status", Email.equals(profile.getEmail()) ? "false" : "true")
          .addAttribute("value", profile.getEmail()).getParent().addElement("Adresse")
          .addAttribute("status",
              !adresseS && profile.getAdresse() != null && Adresse.equals(profile.getAdresse())
                  ? "false"
                  : "true")
          .addAttribute("value", profile.getAdresse()).getParent().addElement("CodePostal")
          .addAttribute("status",
              !codePostalS && profile.getCodePostal() != null
                  && CodePostal.equals(profile.getCodePostal()) ? "false" : "true")
          .addAttribute("value", profile.getCodePostal()).getParent()
          .addElement("CertificatDeResidence")
          .addAttribute("status", !CertificatDeResidence ? "false" : "true");

      root.addElement("Etudes").addAttribute("status", "false").addAttribute("Niveau", "")
          .addAttribute("Date", "");

      root.addElement("Formations").addAttribute("status",
          profile.getFormationStatus() ? "true" : "false");
      root.addElement("ServiceMilitaire").addAttribute("status", "false");
      root.addElement("ActivitesSyndicales").addAttribute("status", "false");
      root.addElement("Conjoint").addAttribute("status", "false");
      root.addElement("Parents").addAttribute("status", "false");
      root.addElement("Enfants").addAttribute("status", "false");
      root.addElement("PersonnesACharge").addAttribute("status", "false");

      FileOutputStream fos = new FileOutputStream(absoluteDiskPath);

      OutputFormat format = OutputFormat.createPrettyPrint();
      XMLWriter writer = new XMLWriter(fos, format);
      writer.write(document);
      writer.flush();
      fos.close();
      writer.close();
      try {
        String destPath = "/profils/";
        FTP.copyToFTP(absoluteDiskPath, destPath, profile.getMatricule() + ".xml", FtpConfigGRH);
      } catch (Exception e) {
        e.printStackTrace();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static void updateFile(Integer matricule, Object object, String opType, String tagName,
      FtpConfig FtpConfigGRH) {

    try {

      ServletContext servletContext =
          (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
      String relativeWebPath = "/resources";

      String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
      absoluteDiskPath += "/profilsXML/" + matricule + ".xml";
      if (Files.exists(Paths.get(absoluteDiskPath))) {

        InputSource is = new InputSource(new FileInputStream(new File(absoluteDiskPath)));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(is);

        // NodeList employees = doc.getElementsByTagName("profile");
        // Element emp = null;
        // for (int i = 0; i < employees.getLength(); i++) {
        // emp = (Element) employees.item(i);
        // Node name = emp.getElementsByTagName("Contact").item(0).getFirstChild();
        // name.setNodeValue(name.getNodeValue().toUpperCase());
        // }
        if (opType.equalsIgnoreCase("update")) {
          updateOps(doc, object);
        } else if (opType.equalsIgnoreCase("flush")) {
          flushElement(doc, tagName);
        }

        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(absoluteDiskPath);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(source, result);

        try {
          String destPath = "/profils/";
          FTP.copyToFTP(absoluteDiskPath, destPath, matricule + ".xml", FtpConfigGRH);
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(XmlReader.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void updateOps(Document doc, Object object) {
    Map<String, String> hm = new HashMap<>();

    if (object instanceof dz.airalgerie.grh.model.entities.carriere.Signalitique) {
      updateAttributeValue(doc, "InformationsPersonnelles", "status", "true");
      addElement(doc, "InformationsPersonnelles", "nom",
          ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object).getNom(), null);
      addElement(doc, "InformationsPersonnelles", "prenom",
          ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object).getPrenoms(), null);
      addElement(doc, "InformationsPersonnelles", "njfille",
          ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object).getNjfille(), null);
      addElement(doc, "InformationsPersonnelles", "sexe",
          ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object).getSexe().toString(),
          null);
      addElement(doc, "InformationsPersonnelles", "dateNaiss",
          f1.format(
              ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object).getDateNais()),
          null);
      hm = new HashMap<>();
      hm.put("code", ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object)
          .getNationalite().getCodeNat());
      addElement(doc, "InformationsPersonnelles", "nationalite",
          ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object).getNationalite()
              .getLibelle(),
          hm);
      hm = new HashMap<>();
      hm.put("code", ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object)
          .getCodeGeographique().getCodeGeo().toString());
      addElement(doc, "InformationsPersonnelles", "lieuNaiss",
          ((dz.airalgerie.grh.model.entities.carriere.Signalitique) object).getCodeGeographique()
              .getLibelle(),
          hm);
    }
    if (object instanceof dz.airalgerie.grh.model.entities.carriere.Contact) {
      updateAttributeValue(doc, "Contact", "status", "true");
      addElement(doc, "Contact", "tel",
          ((dz.airalgerie.grh.model.entities.carriere.Contact) object).getLIGNE_DIRECTE(), null);
      addElement(doc, "Contact", "fax",
          ((dz.airalgerie.grh.model.entities.carriere.Contact) object).getFAX(), null);
      addElement(doc, "Contact", "quatechifres",
          ((dz.airalgerie.grh.model.entities.carriere.Contact) object).getQUATRE_CHIFFRE(), null);
      addElement(doc, "Contact", "ligneIp",
          ((dz.airalgerie.grh.model.entities.carriere.Contact) object).getLIGNE_IP(), null);
      addElement(doc, "Contact", "adresse",
          ((dz.airalgerie.grh.model.entities.carriere.Contact) object).getADRESSE(), null);
    }
  }

  private static void addElement(Document doc, String tagName, String elementName,
      String elementValue, Map<String, String> attributes) {
    NodeList tags = doc.getElementsByTagName(tagName);
    Element elem = null;

    deleteElement(tags, elementName);

    for (int i = 0; i < tags.getLength(); i++) {
      elem = (Element) tags.item(i);
      Element newElement = doc.createElement(elementName);
      newElement.appendChild(doc.createTextNode(elementValue));
      if (attributes != null) {
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
          newElement.setAttribute(entry.getKey(), entry.getValue());
        }
      }
      elem.appendChild(newElement);
    }
  }

  private static void deleteElement(Document doc, String tagName, String elementName) {
    NodeList tags = doc.getElementsByTagName(tagName);
    Element elem = null;

    for (int i = 0; i < tags.getLength(); i++) {
      elem = (Element) tags.item(i);
      for (int j = 0; j < elem.getElementsByTagName(elementName).getLength(); j++) {
        Node node = elem.getElementsByTagName(elementName).item(j);
        elem.removeChild(node);
        j--;
      }
    }
  }

  private static void flushElement(Document doc, String tagName) {
    NodeList tags = doc.getElementsByTagName(tagName);
    Element elem = null;

    for (int i = 0; i < tags.getLength(); i++) {
      elem = (Element) tags.item(i);
      for (int j = 0; j < elem.getChildNodes().getLength(); j++) {
        Node node = elem.getChildNodes().item(j);
        elem.removeChild(node);
        j--;
      }
      elem.setAttribute("status", "false");
    }
  }

  private static void deleteElement(NodeList tags, String elementName) {
    Element elem = null;

    for (int i = 0; i < tags.getLength(); i++) {
      elem = (Element) tags.item(i);

      for (int j = 0; j < elem.getElementsByTagName(elementName).getLength(); j++) {
        Node node = elem.getElementsByTagName(elementName).item(j);
        elem.removeChild(node);
        j--;
      }
    }

  }

  private static void updateAttributeValue(Document doc, String tagName, String attributeName,
      String attributeValue) {
    NodeList tags = doc.getElementsByTagName(tagName);
    Element elem = null;

    for (int i = 0; i < tags.getLength(); i++) {
      elem = (Element) tags.item(i);
      elem.setAttribute(attributeName, attributeValue);
    }
  }

}
