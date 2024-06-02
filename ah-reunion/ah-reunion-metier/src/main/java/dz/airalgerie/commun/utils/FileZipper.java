/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Administrateur
 */
public class FileZipper implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final String FILE_EXTENSION = ".zip";

  public static InputStream generateZipFile(File destPath, String fileName, File... directoryPath)
      throws FileNotFoundException, IOException {
    fileName = destPath + File.separator + fileName + FILE_EXTENSION;
    try (FileOutputStream fos = new FileOutputStream(fileName);
        ZipOutputStream zipOut = new ZipOutputStream(fos)) {

      for (File dir : directoryPath) {
        zipFile(dir, dir.getName(), zipOut);
      }
    }

    InputStream stream = new FileInputStream(fileName);

    return stream;
  }

  private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut)
      throws IOException {
    if (fileToZip.isHidden()) {
      return;
    }
    if (fileToZip.isDirectory()) {
      ZipEntry zipEntry;
      if (fileName.endsWith("/")) {
        zipEntry = new ZipEntry(fileName);
      } else {
        zipEntry = new ZipEntry(fileName + "/");
      }
      zipOut.putNextEntry(zipEntry);
      zipOut.closeEntry();
      File[] children = fileToZip.listFiles();
      for (File childFile : children) {
        zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
      }
      return;
    }
    try (FileInputStream fis = new FileInputStream(fileToZip)) {
      ZipEntry zipEntry = new ZipEntry(fileName);
      zipOut.putNextEntry(zipEntry);
      byte[] bytes = new byte[1024];
      int length;
      while ((length = fis.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
    }
  }

}
