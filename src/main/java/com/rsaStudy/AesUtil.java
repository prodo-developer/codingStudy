package com.rsaStudy;

public class AesUtil {

    public static void main(String[] args) throws Exception {

        AES256 aes256 = new AES256();
        String text = "!! Hello World !!";
        String cipherText = aes256.encrypt(text);
        System.out.println(text);
        System.out.println(cipherText);
        System.out.println(aes256.decrypt(cipherText));

    }
}