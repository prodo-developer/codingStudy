package com.rsaStudy;

import java.io.File;

public class FileTest {

    public static void main(String[] args) throws Exception {

        String key = "0123456789abcdefghij0123456789ab";
//        File xmlFile = new File("polymorphList.xml");
//        File downFile = new File("C:/Programer/imageTest/polymorphLists.xml");
//        new FileCoder(key).encrypt(xmlFile, downFile);

        File xmlFile = new File("C:/Programer/imageTest/polymorphLists.xml");
        File downFile = new File("C:/Programer/imageTest/polymorphListses.xml");
        new FileCoder(key).decrypt(xmlFile, downFile);
    }
}