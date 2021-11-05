package com.rsaStudy;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class DesUtil {
    /**
     *
     */
    public static String[] filePath = { "test.xml" };
    /**
     *
     */
    public static String[] outFilePath = new String[filePath.length];
    private static final String KEY = "springKey01234Test ";

    public DesUtil() {
        super();
        getKey(KEY);
        initCipher();
        //
        crateEncryptFile();
    }

    private Key key;

    /***
     *
     */
    private Cipher cipherDecrypt;
    /**
     *
     */
    private Cipher cipherEncrypt;

    /**
     *
     * */
    private void crateEncryptFile() {
        String outPath = null;
        for (int i = 0; i < filePath.length; i++) {
            try {
                outPath = filePath[i].substring(0,filePath[i].lastIndexOf("."))+".bin";
                encrypt(filePath[i], outPath);
                outFilePath[i] = outPath;
                System.out.println(filePath[i]+"    ，       :"+outFilePath[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("=========================    =======================");

    }

    /**
     *
     *
     * @param file
     *
     * @param destFile
     *
     */
    public void encrypt(String file, String destFile) throws Exception {
        InputStream is = new FileInputStream(file);
        OutputStream out = new FileOutputStream(destFile);

        CipherInputStream cis = new CipherInputStream(is, cipherEncrypt);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = cis.read(buffer)) > 0) {
            out.write(buffer, 0, r);
        }
        cis.close();
        is.close();
        out.close();
    }

    /***
     *
     * @param destFile
     */
    public void decrypt(String destFile) {
        try {
            InputStream is = new FileInputStream(destFile);
            CipherInputStream cis = new CipherInputStream(is, cipherDecrypt);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    cis));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            cis.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCipher() {
        try {
            //    cipher
            cipherEncrypt = Cipher.getInstance("DESede");
            cipherEncrypt.init(Cipher.ENCRYPT_MODE, this.key);
            //    cipher
            cipherDecrypt = Cipher.getInstance("DESede");
            cipherDecrypt.init(Cipher.DECRYPT_MODE, this.key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    /**
     *      key
     *
     * @param string
     */
    public Key getKey(String keyRule) {
        // Key key = null;
        byte[] keyByte = keyRule.getBytes();
        //           ,      0
//        byte[] byteTemp = new byte[8];    // DES
        byte[] byteTemp = new byte[24];     // DESede
        //
        for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
            byteTemp[i] = keyByte[i];
        }
        key = new SecretKeySpec(byteTemp, "DESede");
        return key;
    }

    /**
     *
     *
     * @return
     */
    public Cipher getCipherEdcrypt() {
        return cipherDecrypt;
    }

    /**
     *
     *
     * @return
     */
    public Cipher getCipherEncrypt() {
        return cipherEncrypt;
    }

}