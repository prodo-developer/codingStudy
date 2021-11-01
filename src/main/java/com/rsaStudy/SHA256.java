package com.rsaStudy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 복호화 불가능 : 입력값은 무한정이고, 나오는건 일정한 해시값이다.
 */
public class SHA256 {
    public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());

        return bytesToHex(md.digest());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}