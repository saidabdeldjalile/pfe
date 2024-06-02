/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.utils;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Administrateur
 */
public class AesHelper {

  final static String secretKeyBadge = "67434B1923437EEE427009963721DEFC";
  private static SecretKeySpec secretKey;
  private static byte[] key;
  private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

  public static void setKey(String myKey) {
    MessageDigest sha = null;
    // key = myKey.getBytes("UTF-8");
    try {
      key = Hex.decodeHex(myKey.toCharArray());
    } catch (DecoderException ex) {
      Logger.getLogger(AesHelper.class.getName()).log(Level.SEVERE, null, ex);
    }
    // sha = MessageDigest.getInstance("SHA-1");
    // key = sha.digest(key);
    // key = Arrays.copyOf(key,32);
    secretKey = new SecretKeySpec(key, "AES");
  }

  public static byte[] encrypt(String strToEncrypt, String secret) {
    char[] ch = strToEncrypt.toCharArray();

    try {
      key = null;
      secretKey = null;
      setKey(secret);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      return (cipher.doFinal(Hex.decodeHex(ch)));
    } catch (Exception e) {
      System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
  }

  public static byte[] decrypt(String strToDecrypt) {
    char[] ch = strToDecrypt.toCharArray();

    // System.out.println("Test: " + ch);
    try {
      key = null;
      secretKey = null;
      setKey(secretKeyBadge);

      Cipher cipher2 = Cipher.getInstance("AES/ECB/NoPadding");

      cipher2.init(Cipher.DECRYPT_MODE, secretKey);

      return ((cipher2.doFinal(Hex.decodeHex(ch)))); // Output as String eg: testingone

    } catch (Exception e) {

      System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
  }

  public static String convertHexToString(String hex) {

    StringBuilder sb = new StringBuilder();
    StringBuilder temp = new StringBuilder();

    // 49204c6f7665204a617661 split into two characters 49, 20, 4c...
    for (int i = 0; i < hex.length() - 1; i += 2) {

      // grab the hex in pairs
      String output = hex.substring(i, (i + 2));
      // convert hex to decimal
      int decimal = Integer.parseInt(output, 16);
      // convert the decimal to character
      sb.append((char) decimal);

      temp.append(decimal);
    }
    // System.out.println("Decimal : " + temp.toString());

    return sb.toString();
  }

  public static String convertStringToHex(String str) {

    char[] chars = str.toCharArray();

    StringBuffer hex = new StringBuffer();
    for (int i = 0; i < chars.length; i++) {
      hex.append(Integer.toHexString((int) chars[i]));
    }

    return hex.toString();
  }

  public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
      int v = bytes[j] & 0xFF;
      hexChars[j * 2] = HEX_ARRAY[v >>> 4];
      hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
    }
    return new String(hexChars);
  }
}
