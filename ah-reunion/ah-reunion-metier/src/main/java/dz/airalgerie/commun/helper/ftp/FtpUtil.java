/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.ftp;

import static org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class FtpUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(FtpUtil.class);

  private static final int BUFFER_SIZE = 32768000;

  private static final int FILE_TYPE = BINARY_FILE_TYPE;

  /**
   * Permet d'initialiser une connexion FTP.
   *
   * @param ftpConfig
   * 
   * @return
   * 
   * @throws SocketException
   * @throws IOException
   */
  private static FTPClient initializeFtpClient(FtpConfig ftpConfig)
      throws SocketException, IOException {
    if (ftpConfig != null && ftpConfig.getHost() != null && !ftpConfig.getHost().isEmpty()
        && ftpConfig.getUsername() != null && !ftpConfig.getUsername().isEmpty()
        && ftpConfig.getPassword() != null && !ftpConfig.getPassword().isEmpty()) {

      FTPClient ftpClient = connect(ftpConfig.getHost(), ftpConfig.getPort());
      return login(ftpConfig, ftpClient);
    } else {
      throw new IOException("FTP parameters not found.");
    }
  }

  /**
   * Permet de créer une connexion FTP.
   *
   * @param ftpServer
   * @param port
   * 
   * @return
   * 
   * @throws SocketException
   * @throws IOException
   */
  private static FTPClient connect(String ftpServer, int port) throws SocketException, IOException {
    FTPClient ftpClient = new FTPClient();
    if (port > 0) {
      ftpClient.connect(ftpServer, port);
    } else {
      ftpClient.connect(ftpServer);
    }

    return ftpClient;
  }

  /**
   * Permet d'authentifier une connexion FTP avec un user/password.
   *
   * @param ftpServer
   * @param ftpUsername
   * @param ftpPassword
   * @param ftpClient
   * 
   * @return
   * 
   * @throws IOException
   */
  private static FTPClient login(FtpConfig ftpConfig, FTPClient ftpClient) throws IOException {
    ftpClient.login(ftpConfig.getUsername(), ftpConfig.getPassword());
    checkFtpConnection(ftpClient, ftpConfig);
    LOGGER.info(String.format("Connected to FTP Server: %s.", ftpConfig.getHost()));
    return ftpClient;
  }

  /**
   * Vérifie le code de retour de la connexion FTP. Si la connexion est refusée, une IOException est
   * émise.
   *
   * @param ftpServer
   * @param ftpUsername
   * @param ftpPassword
   * @param ftpClient
   * 
   * @throws IOException
   */
  private static void checkFtpConnection(FTPClient ftpClient, FtpConfig ftpConfig)
      throws IOException {
    if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
      closeFtpClient(ftpClient);
      throw new IOException(
          String.format("FTP server (%s) refused connection for user:%s password:%s",
              ftpConfig.getHost(), ftpConfig.getUsername(), ftpConfig.getPassword()));
    }
  }

  /**
   * Permet de fermer une connexion FTP.
   *
   * @param ftpClient
   * 
   * @throws IOException
   */
  private static void closeFtpClient(FTPClient ftpClient) throws IOException {
    LOGGER.info("Closing FTP connection.");
    if (ftpClient != null) {
      if (ftpClient.isConnected()) {
        ftpClient.logout();
        ftpClient.disconnect();
      }
    }
  }

  /**
   * Permet d'émettre une demande de téléchargement d'un fichier depuis le serveur FTP.
   *
   * @param ftpConfig
   * @param remotePath
   * @param fileName
   * @param workDirectory
   * 
   * @return
   * 
   * @throws IOException
   */
  public static File downloadFile(FtpConfig ftpConfig, String remotePath, String fileName,
      File workDirectory) throws IOException {
    FTPClient ftpClient = null;
    File downloadedFile = null;
    try {
      ftpClient = FtpUtil.initializeFtpClient(ftpConfig);
      FtpUtil.navigateToFtpDirectory(ftpClient, ftpConfig.findRootPathRemoteFolder(remotePath));
      
      System.out.println("workDirectory " + workDirectory);
      System.out.println("fileName " + fileName);

      downloadedFile = FtpUtil.downloadFile(ftpClient, fileName, workDirectory);

    } finally {
      FtpUtil.closeFtpClient(ftpClient);
    }
    return downloadedFile;
  }

  /**
   * Permet de télécharger un fichier depuis le serveur FTP vers un dossier local.
   *
   * @param ftpClient
   * @param ftpFileName
   * @param localStorageDirectory
   * 
   * @return
   * 
   * @throws FileNotFoundException
   * @throws IOException
   */
  private static File downloadFile(FTPClient ftpClient, String ftpFileName,
      File localStorageDirectory) throws FileNotFoundException, IOException {
    OutputStream localOutputStream = null;
    File outputFile = new File(localStorageDirectory + File.separator + ftpFileName);
    LOGGER.info("Downloading file via FTP: " + ftpFileName + " to " + outputFile);
    try {
      localOutputStream = new FileOutputStream(outputFile);
      downloadFile(ftpClient, ftpFileName, FILE_TYPE, localOutputStream);
      return outputFile;
    } finally {
      if (localOutputStream != null) {
        localOutputStream.close();
      }
    }
  }

  /**
   * Permet de télécharger un fichier depuis le serveur FTP vers un OutputStream
   *
   * @param ftpClient
   * @param ftpFileName
   * @param ftpFileType
   * @param localOutputStream
   * 
   * @throws IOException
   */
  private static void downloadFile(FTPClient ftpClient, String ftpFileName, int ftpFileType,
      OutputStream localOutputStream) throws IOException {
    checkFtpClientConnection(ftpClient);
    LOGGER.info(String.format("Downloading file: %s", ftpFileName));
    ftpClient.setFileType(ftpFileType);
    ftpClient.enterLocalPassiveMode();
    ftpClient.setBufferSize(BUFFER_SIZE);

    Collection<String> remoteFiles = Arrays.asList(ftpClient.listNames());
    if (!remoteFiles.contains(ftpFileName)) {
      throw new IOException(
          String.format("File %s is not available on ftp server %s. Ftp download failed...",
              ftpFileName, ftpClient.getRemoteAddress()));
    }

    if (!ftpClient.retrieveFile(ftpFileName, localOutputStream)) {
      throw new IOException(String.format("Download failed for file: %s", ftpFileName));
    }
  }

  /**
   * Permet de lancer le upload de fichier vers le serveur FTP
   * 
   * @param ftpConfig
   * @param remotePath
   * @param fileName
   * @param workDirectory
   * 
   * @return
   * 
   * @throws IOException
   */
  public static boolean uploadFile(FtpConfig ftpConfig, String remotePath, String fileName,
      File workDirectory) throws IOException {
    FTPClient ftpClient = null;
    boolean result = false;
    try {
      ftpClient = FtpUtil.initializeFtpClient(ftpConfig);
      FtpUtil.ftpCreateDirectoryTree(ftpClient, ftpConfig.findRootPathRemoteFolder(remotePath));
      FtpUtil.navigateToFtpDirectory(ftpClient, ftpConfig.findRootPathRemoteFolder(remotePath));
      result = FtpUtil.uploadFile(ftpClient, fileName, workDirectory);
    } finally {
      FtpUtil.closeFtpClient(ftpClient);
    }
    return result;
  }

  /**
   * Permet de lancer le upload de fichier vers le serveur FTP
   * 
   * @param ftpClient
   * @param ftpFileName
   * @param localStorageDirectory
   * 
   * @return
   * 
   * @throws FileNotFoundException
   * @throws IOException
   */
  private static boolean uploadFile(FTPClient ftpClient, String ftpFileName,
      File localStorageDirectory) throws FileNotFoundException, IOException {
    FileInputStream localInputStream = null;
    File inputFile = new File(localStorageDirectory + File.separator + ftpFileName);
    LOGGER.info("Uploading file via FTP: " + ftpFileName + " to " + inputFile);
    try {
      localInputStream = new FileInputStream(inputFile);
      return uploadFile(ftpClient, ftpFileName, FILE_TYPE, localInputStream);
    } finally {
      if (localInputStream != null) {
        localInputStream.close();
      }
    }
  }

  /**
   * Permet de lancer le upoad de fichier vers le serveur FTP
   * 
   * @param ftpClient
   * @param ftpFileName
   * @param ftpFileType
   * @param localInputStream
   * 
   * @return
   * 
   * @throws IOException
   */
  private static boolean uploadFile(FTPClient ftpClient, String ftpFileName, int ftpFileType,
      FileInputStream localInputStream) throws IOException {
    checkFtpClientConnection(ftpClient);
    ftpClient.setFileType(ftpFileType);
    ftpClient.enterLocalPassiveMode();
    ftpClient.setBufferSize(BUFFER_SIZE);

    LOGGER.info(String.format("Uploading file: %s", ftpFileName));
    if (!ftpClient.storeFile(ftpFileName, localInputStream)) {
      throw new IOException(String.format("upload failed for file: %s", ftpFileName));
    }

    return true;

  }

  /**
   * Permet de changer la racine de la connexion au niveau du FTP.
   *
   * @param ftpClient
   * @param directoryOnFtpServer
   * 
   * @throws IOException
   */
  private static void navigateToFtpDirectory(FTPClient ftpClient, String directoryOnFtpServer)
      throws IOException {
    LOGGER.info(String.format("Changing to new directory on server: %s", directoryOnFtpServer));
    ftpClient.changeWorkingDirectory(directoryOnFtpServer);
  }

  /**
   * Vérifie si la connexion FTP est connectée au serveur.
   *
   * @param ftpClient
   * @param ftpFileName
   * 
   * @throws IOException
   */
  private static void checkFtpClientConnection(FTPClient ftpClient) throws IOException {
    if (!ftpClient.isConnected()) {
      throw new IOException(String.format("FTP connection expected open, but is closed."));
    }
  }

  /**
   * Permet de créer l'arborescence de répertoire
   *
   * @param client
   * @param dirTree
   * 
   * @throws IOException
   */
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
}
