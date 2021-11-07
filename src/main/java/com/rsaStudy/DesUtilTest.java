package com.rsaStudy;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DesUtilTest {

    public static void main(String[] args) {

        if(args.length != 1){

            System.out.println("need parameters");

            System.exit(1);

        }



        String text = args[0];

        System.out.println("Generate a DESede (TripleDES) Key...");



        try{

            // 24 bytes DESedeKey

            String keySentence = "Triple@Des!Test_Key1)#42";



            // 8 bytes ivkey CBC 모드에서만 사용된다. (ECB 모드에서는 불필요)

            String ivKeySentence = "@amoebaj";



            DESedeKeySpec desKeySpec = new DESedeKeySpec(keySentence.getBytes());

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");

            Key key = keyFactory.generateSecret(desKeySpec);



            System.out.println("Done generating the key");



            // 모드 선택

            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

            IvParameterSpec iv = new IvParameterSpec(ivKeySentence.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, key, iv);



            byte[] plainText = text.getBytes("UTF-8");



            // 보통문서의 바이트 출력

            System.out.println("\nPlaintext: ");

            for(int i=0;i<plainText.length;i++){

                System.out.print(plainText[i] + " ");

            }



            // 실제 암호화 수행

            byte[] cipherText = cipher.doFinal(plainText);

            byte[] outputBytes1 = cipher.doFinal(cipherText);

            sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();

            String encryptedString = encoder.encode(outputBytes1);



            // 암호문서 출력

            System.out.println("\nCipherText");

            for(int i=0;i<cipherText.length;i++){

                System.out.print(cipherText[i] + " ");

            }

            System.out.println("\n\nEncrypted Test: " + encryptedString);

            cipher.init(Cipher.DECRYPT_MODE, key, iv);

            // 복호화 수행

            byte[] decryptedText = cipher.doFinal(cipherText);

            String output = new String(decryptedText, "UTF8");

            System.out.println("Decrypted Test: " + output);



        }catch(IllegalArgumentException e){

            e.printStackTrace();

        } catch (InvalidKeyException e) {

            e.printStackTrace();

        } catch (InvalidAlgorithmParameterException e) {

            e.printStackTrace();

        } catch (IllegalBlockSizeException e) {

            e.printStackTrace();

        } catch (BadPaddingException e) {

            e.printStackTrace();

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        } catch (InvalidKeySpecException e) {

            e.printStackTrace();

        } catch (NoSuchPaddingException e) {

            e.printStackTrace();

        }



    }

}