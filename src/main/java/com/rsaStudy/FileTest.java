package com.rsaStudy;

import static com.rsaStudy.DesUtil.outFilePath;

public class FileTest {

    public static void main(String[] args) throws Exception {

//      암호
        DesUtil desFileEncrypt = new DesUtil();
        desFileEncrypt.decrypt(outFilePath[0]);
//      복호
//        String testFile = "polymorphList.bin";
//        desFileEncrypt.encrypt(outFilePath[0], testFile);

//      AES
//      암호화
//        String key = "Tree53464112sss";
//        File xmlFile = new File("polymorphList.xml");
//        File downFile = new File("C:/Programer/imageTest/polymorphLists.xml");
//        new FileCoder(key).encrypt(xmlFile, downFile);

//      복호화
//      File xmlFile = new File("C:/Programer/imageTest/polymorphLists.xml");
//      File downFile = new File("C:/Programer/imageTest/polymorphListses.xml");
//      new FileCoder(key).decrypt(xmlFile, downFile);
    }
}