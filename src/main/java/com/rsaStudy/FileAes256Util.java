package com.rsaStudy;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

public class FileAes256Util {
    private static String KEY = "9003e5a13d69a78c0d8210cb28b9d0d38e5445568899f637c24bc08241f98ded";
    private static String IV = "024e54561023da13118d16ac21119b8a";

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public File aes256Encode(File uploadFile, File FileName) {

        byte[] _key = hexStringToByteArray(KEY);
        byte[] _iv = hexStringToByteArray(IV);

        InputStream input = null;
        OutputStream output = null;

        SecretKeySpec keyspc = new SecretKeySpec(_key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(_iv);

        try {

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keyspc, ivSpec);

            input = new BufferedInputStream(new FileInputStream(uploadFile));
            output = new BufferedOutputStream(new FileOutputStream(uploadFile, false));

            byte[] buffer = new byte[1024];
            int read = -1;
            while ((read = input.read(buffer)) != -1) {
                output.write(cipher.update(buffer, 0, read));
            }
            output.write(cipher.doFinal());
        } catch (Exception e) {
            System.exit(0);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ie) {

                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ie) {
                }
            }
        }
        return uploadFile;
    }
}