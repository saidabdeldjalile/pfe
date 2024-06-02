/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import dz.airalgerie.commun.helper.ftp.FtpConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 *
 * @author Diaf
 */
public class FTP {

  private static String facturesPath;
  private static String bonDeCommandePath;
  private static String accordPath;
  private static String pvsPath;
  private static String pvssignesPath;
  private static String brPath;
  private static String AutrePath;
  private static String TransfertDoc1Path;
  private static String TransfertDoc2Path;
  private static String TransfertDoc3Path;
  private static String TransfertDoc4Path;

  private static String ReformeDoc1Path;
  private static String ReformeDoc2Path;
  private static String ReformeDoc3Path;
  private static String ReformeDoc4Path;


  public static void copyFolderFromFTP(String sourceFilePath, String destinationPath,
      FtpConfig FtpConfigGRH) {

    try {
      FTPClient ftpClient = new FTPClient();
      ftpClient.connect(FtpConfigGRH.getHost());
      ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

      if (ftpClient.isConnected()) {
        ftpClient.changeWorkingDirectory("/DOCS_IMMO/GRH/" + sourceFilePath);
        FTPFile[] ftpFiles = ftpClient.listFiles();

        if (ftpFiles != null && ftpFiles.length > 0) {
          // loop thru files
          for (FTPFile file : ftpFiles) {
            if (!file.isFile()) {
              continue;
            }
            OutputStream output;
            output = new FileOutputStream(destinationPath + "/" + file.getName());
            // get the file from the remote system
            ftpClient.retrieveFile(file.getName(), output);
            // close output stream
            output.close();
          }
        }
      }
      ftpClient.logout();
      ftpClient.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static void copyFromFTP(String sourceFilePath, String destinationPath,
      FtpConfig FtpConfigGRH) {
    try {
      FTPClient ftpClient = new FTPClient();
      ftpClient.connect(FtpConfigGRH.getHost());
      ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

      if (ftpClient.isConnected()) {
        InputStream inputStream = ftpClient.retrieveFileStream("/DOCS_IMMO/GRH/" + sourceFilePath);
        if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
          try (FileOutputStream fos = new FileOutputStream(destinationPath)) {
            IOUtils.copy(inputStream, fos);
            fos.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (!(inputStream == null)) {
          inputStream.close();
        }
      }
      ftpClient.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static void copyPhotoFromFTP(Integer matricule, String destinationPath,
      FtpConfig FtpConfigGRH) {
    try {

      if (destinationPath != null) {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(FtpConfigGRH.getHost());
        ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
        InputStream inputStream = null;
        if (ftpClient.isConnected()) {
          if (matricule < 10000) {
            destinationPath = destinationPath + "/P0" + matricule + ".jpg";
          } else {
            destinationPath = destinationPath + "/P" + matricule + ".jpg";
          }

          try {
            Files.delete(Paths.get(destinationPath));
          } catch (Exception e) {
          }

          if (matricule < 10000) {
            inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/GRH/PhotosAH/P0" + matricule + ".jpg");
          } else {
            inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/GRH/PhotosAH/P" + matricule + ".jpg");
          }

          if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
            try (FileOutputStream fos = new FileOutputStream(destinationPath)) {
              IOUtils.copy(inputStream, fos);
              fos.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
          if (!(inputStream == null)) {
            inputStream.close();
          }
        }
        ftpClient.disconnect();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static void copyToFTP(String sourcePath, String destinationPath, String fileName,
      FtpConfig FtpConfigGRH) {

    FTPClient ftpClient = null;
    try {
      ftpClient = new FTPClient();
      ftpClient.connect(FtpConfigGRH.getHost());
      ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
      if (ftpClient.isConnected()) {
        File file = new File(sourcePath);
        if (file.exists()) {
          ftpCreateDirectoryTree(ftpClient, "/DOCS_IMMO/GRH/" + destinationPath);
          InputStream inputStream = new FileInputStream(file);
          ftpClient.storeFile("/DOCS_IMMO/GRH/" + destinationPath + "/" + fileName, inputStream);
          inputStream.close();
        }
      }
    } catch (IOException ex) {
      Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        if (ftpClient != null) {
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  private static void ftpCreateDirectoryTree(FTPClient client, String dirTree) throws IOException {
    boolean dirExists = true;
    String[] directories = dirTree.split("/");
    for (String dir : directories) {
      if (!dir.isEmpty()) {
        if (dirExists) {
          dirExists = client.changeWorkingDirectory(dir);
        }
        if (!dirExists) {
          if (!client.makeDirectory(dir)) {
            throw new IOException("Unable to create remote directory '" + dir + "'.  error='"
                + client.getReplyString() + "'");
          }
          if (!client.changeWorkingDirectory(dir)) {
            throw new IOException("Unable to change into newly created remote directory '" + dir
                + "'.  error='" + client.getReplyString() + "'");
          }
        }
      }
    }
  }


  public static void deleteFile(String file, FtpConfig FtpConfigGRH) {

    FTPClient ftpClient = null;
    try {
      ftpClient = new FTPClient();
      ftpClient.connect(FtpConfigGRH.getHost());
      ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
      if (ftpClient.isConnected()) {
        ftpClient.deleteFile("/DOCS_IMMO/GRH/" + file);
      }
    } catch (IOException ex) {
      Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        if (ftpClient != null) {
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }


  public static boolean fileExists(String path, FtpConfig FtpConfigGRH) {

    FTPClient ftpClient = null;
    try {
      ftpClient = new FTPClient();
      ftpClient.connect(FtpConfigGRH.getHost());
      ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
      if (ftpClient.isConnected()) {
        InputStream inputStream = ftpClient.retrieveFileStream("/DOCS_IMMO/GRH/" + path);
        if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
          return true;
        }
        if (!(inputStream == null)) {
          inputStream.close();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      try {
        if (ftpClient != null) {
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return false;
  }


  public static void refreshReformesFiles(String dossierId, String path, FtpConfig FtpConfigGRH) {
    ReformeDoc1Path = path + "reformeDoc1" + File.separator;
    ReformeDoc2Path = path + "reformeDoc2" + File.separator;
    ReformeDoc3Path = path + "reformeDoc3" + File.separator;
    ReformeDoc4Path = path + "reformeDoc4" + File.separator;
    try {
      Files.delete(Paths.get(ReformeDoc1Path + dossierId + ".pdf"));
      Files.delete(Paths.get(ReformeDoc2Path + dossierId + ".pdf"));
      Files.delete(Paths.get(ReformeDoc3Path + dossierId + ".pdf"));
      Files.delete(Paths.get(ReformeDoc4Path + dossierId + ".pdf"));
    } catch (Exception e) {
    }
    boolean haveReformDoc1 = Files.exists(Paths.get(ReformeDoc1Path + dossierId + ".pdf"));
    boolean haveReformDoc2 = Files.exists(Paths.get(ReformeDoc2Path + dossierId + ".pdf"));
    boolean haveReformDoc3 = Files.exists(Paths.get(ReformeDoc3Path + dossierId + ".pdf"));
    boolean haveReformDoc4 = Files.exists(Paths.get(ReformeDoc4Path + dossierId + ".pdf"));

    if (!haveReformDoc1 || !haveReformDoc2 || !haveReformDoc3 || !haveReformDoc4) {
      try {
        FTPClient ftpClient = new FTPClient();
        if (!haveReformDoc1) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/reformeDoc1/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(ReformeDoc1Path + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }
        if (!haveReformDoc2) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/reformeDoc2/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(ReformeDoc2Path + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }

        if (!haveReformDoc3) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/reformeDoc3/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(ReformeDoc3Path + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }

        if (!haveReformDoc4) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/reformeDoc4/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(ReformeDoc4Path + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }


  public static void refreshTransfertFiles(String dossierId, String path, FtpConfig FtpConfigGRH) {

    TransfertDoc1Path = path + "tarnsfertDoc1" + File.separator;
    TransfertDoc2Path = path + "tarnsfertDoc2" + File.separator;
    TransfertDoc3Path = path + "tarnsfertDoc3" + File.separator;
    TransfertDoc4Path = path + "tarnsfertDoc4" + File.separator;
    try {
      Files.delete(Paths.get(TransfertDoc1Path + dossierId + ".pdf"));
      Files.delete(Paths.get(TransfertDoc2Path + dossierId + ".pdf"));
      Files.delete(Paths.get(TransfertDoc3Path + dossierId + ".pdf"));
      Files.delete(Paths.get(TransfertDoc4Path + dossierId + ".pdf"));
    } catch (Exception e) {
    }
    boolean haveTransfertDoc1 = Files.exists(Paths.get(TransfertDoc1Path + dossierId + ".pdf"));
    boolean haveTransfertDoc2 = Files.exists(Paths.get(TransfertDoc2Path + dossierId + ".pdf"));
    boolean haveTransfertDoc3 = Files.exists(Paths.get(TransfertDoc3Path + dossierId + ".pdf"));
    boolean haveTransfertDoc4 = Files.exists(Paths.get(TransfertDoc4Path + dossierId + ".pdf"));

    if (!haveTransfertDoc1 || !haveTransfertDoc2 || !haveTransfertDoc3 || !haveTransfertDoc4) {
      try {
        FTPClient ftpClient = new FTPClient();
        if (!haveTransfertDoc1) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/tarnsfertDoc1/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(TransfertDoc1Path + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }
        if (!haveTransfertDoc2) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/tarnsfertDoc2/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(TransfertDoc2Path + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }

        if (!haveTransfertDoc3) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/tarnsfertDoc3/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(TransfertDoc3Path + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }

        if (!haveTransfertDoc4) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/tarnsfertDoc4/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(TransfertDoc4Path + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }


  public static void refreshAcquisitionFiles(String dossierId, String path,
      FtpConfig FtpConfigGRH) {
    facturesPath = path + "factures" + File.separator;
    bonDeCommandePath = path + "BonDeCommandes" + File.separator;
    accordPath = path + "accords" + File.separator;
    pvsPath = path + "pvs" + File.separator;
    pvssignesPath = path + "pvs_signes" + File.separator;
    brPath = path + "br" + File.separator;
    AutrePath = path + "autreDocAcquisition" + File.separator;

    try {
      Files.delete(Paths.get(bonDeCommandePath + dossierId + ".pdf"));
      Files.delete(Paths.get(accordPath + dossierId + ".pdf"));
      Files.delete(Paths.get(pvssignesPath + dossierId + ".pdf"));
      Files.delete(Paths.get(pvsPath + dossierId + ".pdf"));
      Files.delete(Paths.get(brPath + dossierId + ".pdf"));
      Files.delete(Paths.get(AutrePath + dossierId + ".pdf"));
      Files.delete(Paths.get(facturesPath + dossierId + ".pdf"));
    } catch (Exception e) {
    }

    boolean haveBonDeCommande = Files.exists(Paths.get(bonDeCommandePath + dossierId + ".pdf"));
    boolean haveAccord = Files.exists(Paths.get(accordPath + dossierId + ".pdf"));
    boolean havePvsSignes = Files.exists(Paths.get(pvssignesPath + dossierId + ".pdf"));
    boolean havePvsGenere = Files.exists(Paths.get(pvsPath + dossierId + ".pdf"));
    boolean haveBr = Files.exists(Paths.get(brPath + dossierId + ".pdf"));
    boolean haveAutre = Files.exists(Paths.get(AutrePath + dossierId + ".pdf"));
    boolean haveFacture = Files.exists(Paths.get(facturesPath + dossierId + ".pdf"));

    if (!haveFacture || !haveBonDeCommande || !haveAccord || !havePvsSignes || !haveBr || !haveAutre
        || !havePvsGenere) {
      try {
        FTPClient ftpClient = new FTPClient();
        if (!haveFacture) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream = ftpClient
                .retrieveFileStream("/DOCS_IMMO/acquisition_facture/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos = new FileOutputStream(facturesPath + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }
        if (!haveBonDeCommande) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream = ftpClient
                .retrieveFileStream("/DOCS_IMMO/acquisition_bon_de_commande/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos =
                  new FileOutputStream(bonDeCommandePath + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }
        if (!haveAccord) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream = ftpClient
                .retrieveFileStream("/DOCS_IMMO/acquisition_acord_budjet/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos = new FileOutputStream(accordPath + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }

        if (!havePvsSignes) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream = ftpClient
                .retrieveFileStream("/DOCS_IMMO/acquisition_pvs_signes/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (
                  FileOutputStream fos = new FileOutputStream(pvssignesPath + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }

        if (!haveBr) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/acquisition_br/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos = new FileOutputStream(brPath + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }

        if (!haveAutre) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream =
                ftpClient.retrieveFileStream("/DOCS_IMMO/acquisition_autres/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos = new FileOutputStream(AutrePath + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }

        if (!havePvsGenere) {
          ftpClient.connect(FtpConfigGRH.getHost());
          ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
          ftpClient.enterLocalPassiveMode();
          ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

          if (ftpClient.isConnected()) {
            InputStream inputStream = ftpClient
                .retrieveFileStream("/DOCS_IMMO/acquisition_pvs_genere/" + dossierId + ".pdf");
            if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
              try (FileOutputStream fos = new FileOutputStream(pvsPath + dossierId + ".pdf")) {
                IOUtils.copy(inputStream, fos);
                fos.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (!(inputStream == null)) {
              inputStream.close();
            }
          }
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  /**
   * Permet de verifier si le fichier existe.
   *
   * @param matricule
   * @param FtpConfigGRH
   * 
   * @return
   */
  public static boolean photoExists(String matricule, FtpConfig FtpConfigGRH) {

    FTPClient ftpClient = null;
    try {
      ftpClient = new FTPClient();
      ftpClient.connect(FtpConfigGRH.getHost());
      ftpClient.login(FtpConfigGRH.getUsername(), FtpConfigGRH.getPassword());
      ftpClient.enterLocalPassiveMode();
      ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
      if (ftpClient.isConnected()) {
        InputStream inputStream;
        if (Integer.parseInt(matricule) < 10000) {
          inputStream =
              ftpClient.retrieveFileStream("/DOCS_IMMO/GRH/PhotosAH/P0" + matricule + ".jpg");
        } else {
          inputStream =
              ftpClient.retrieveFileStream("/DOCS_IMMO/GRH/PhotosAH/P" + matricule + ".jpg");
        }
        if (!(inputStream == null || ftpClient.getReplyCode() == 550)) {
          return true;
        }
        if (!(inputStream == null)) {
          inputStream.close();
        }
      }
    } catch (Exception e) {
      return false;
    } finally {
      try {
        if (ftpClient != null) {
          ftpClient.disconnect();
        }
      } catch (IOException ex) {
        Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return false;
  }

}
