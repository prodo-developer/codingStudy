package com.hackerrack.hashMaps;

import java.util.HashMap;

public class RansomNote {

    static String checkMagazine(String[] magazine, String[] note) {
        String s = "";

        boolean t = true;

        HashMap<String, Integer> mageMap = new HashMap<>();

        for (String ma : magazine) {
            mageMap.put(ma, mageMap.getOrDefault(ma, 0) + 1);
        }

        HashMap<String, Integer> noteMap = new HashMap<>();

        for (String no : note) {
            noteMap.put(no, noteMap.getOrDefault(no, 0) + 1);
        }

        System.out.println(mageMap);
        System.out.println(noteMap);
        
        // 값을 비교해서 노트수보다 작으면 false, No 처리
        for (String notes : noteMap.keySet()) {
            if(mageMap.get(notes) == null || mageMap.get(notes) == 0 || mageMap.get(notes) < noteMap.get(notes)) {
                System.out.println("No");
                t = false;
                break;
            }
        }

        if(t) {
            System.out.println("Yes");
        }

        return s;
    }

    public static void main(String[] args) {

        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note     = {"give", "one", "grand", "today"};

        String[] magazine1 = {"two", "times", "three", "is", "not", "four"};
        String[] note1     = {"two", "times", "two", "is", "four"};

        String[] magazine2 = {"h", "ghq", "g", "xxy", "wdnr", "anjst", "xxy", "wdnr", "h", "h", "anjst", "wdnr"};
        String[] note2     = {"h", "ghq"};

        System.out.println(new RansomNote().checkMagazine(magazine, note));
        System.out.println(new RansomNote().checkMagazine(magazine1, note1));
        System.out.println(new RansomNote().checkMagazine(magazine2, note2));
    }
}
