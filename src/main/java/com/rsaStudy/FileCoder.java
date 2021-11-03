package com.rsaStudy;

import java.io.*;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class FileCoder {

    private static final String algorithm = "AES";
    private static final String transformation = algorithm+"/ECB/PKCS5Padding";

    private String iv;
    private Key keySpec;

    public FileCoder(String key) throws UnsupportedEncodingException {

        iv = key.substring(0, 16);
        byte[] keyBytes = new byte[16];
        byte[] b = iv.getBytes("UTF-8");
        int len = b.length;
        if(len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

        this.keySpec = keySpec;
    }

    /**
     * 원본 파일을 암호화해서 대상 파일을 만든다.
     * @param source 원본 파일
     * @param dest 대상 파일
     * @throws Exception
     */
    public void encrypt(File source, File dest) throws Exception{
        crypt(Cipher.ENCRYPT_MODE, source, dest);
    }

    /**
     * 원본 파일을 복호화해서 대상 파일을 만든다.
     * @param source 원본 파일
     * @param dest 대상 파일
     * @throws Exception
     */
    public void decrypt(File source, File dest) throws Exception {
        crypt(Cipher.DECRYPT_MODE, source, dest);
    }

    /**
     * 원본 파일을 읽어와 암호화하여 대상 파일을 만든다.
     * @param source 원본 파일
     * @param dest 대상 파일
     * @throws Exception
     */
    public void encrypt(InputStream is, OutputStream os) throws Exception{
        crypt(Cipher.ENCRYPT_MODE, is, os);
    }

    /**
     * 원본 파일을 읽어와 복호화하여 대상 파일을 만든다.
     * @param source 원본 파일
     * @param dest 대상 파일
     * @throws Exception
     */
    public void decrypt(InputStream is, OutputStream os) throws Exception{
        crypt(Cipher.DECRYPT_MODE, is, os);
    }

    private void crypt(int mode, InputStream is, OutputStream os) throws Exception{
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(mode, keySpec);

        InputStream input = is;
        OutputStream output = os;

        byte[] buffer = new byte[1024];
        int read = -1;
        while((read = input.read(buffer)) != -1){
            output.write(cipher.update(buffer, 0, read));
        }
        output.write(cipher.doFinal());
    }

    private void crypt(int mode, File source, File dest) throws Exception{
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(mode, keySpec);
        InputStream input = null;
        OutputStream output = null;

        try{
            input = new BufferedInputStream(new FileInputStream(source));
            output = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buffer = new byte[1024];
            int read = -1;
            while((read = input.read(buffer)) != -1){
                output.write(cipher.update(buffer, 0, read));
            }
            output.write(cipher.doFinal());
        }finally{
            if(output != null){
                try{output.close();}catch(IOException e){}
            }
            if(input != null){
                try{input.close();}catch(IOException e){}
            }
        }
    }
}