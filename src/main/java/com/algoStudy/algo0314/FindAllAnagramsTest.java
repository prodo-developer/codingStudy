package com.algoStudy.algo0314;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsTest {

    // Anagrams 문제나 팔린드드롭

   public List<Integer> findAnagram(String txt, String pat) {

        // 대상 txt 를 비교한다. 이중 for문
        // Txt, pat을 같은지 비교한다.

        List<Integer> result = new ArrayList<>();
        if(txt==null || txt.length()==0 || pat==null || pat.length()==0 || txt.length()<pat.length())
            return result;

       // 패턴에 대한 ABCD 아스키값 Array에 담는다 (65,66,67,68)
       int[] patArr = new int[256]; // [0,0,0,0,1,1,1,1,0,0,..]
       for (int i = 0; i < pat.length(); i++) {
           patArr[pat.charAt(i)]++;
       }

       for(int i=0; i<txt.length()-pat.length()+1; i++) {
           int[] txtArr = new int[256];
           for (int j = 0; j < pat.length(); j++) {
               txtArr[txt.charAt(i+j)]++;   // 0+, 1+
           }

           if(check(patArr, txtArr)) {
               result.add(i);
           }
       }
       return result;
    }

    private boolean check(int[] patArr, int[] txtArr) {
        for (int i = 0; i < patArr.length; i++) {
            if (patArr[i] != txtArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        // 0, 5, 6

        // s: "cbaebabacd" p: "abc" // 0,6
        // s: "abab" p: "ab" // 0,1,2

        System.out.println(new FindAllAnagramsTest().findAnagram(txt, pat));
    }
}
