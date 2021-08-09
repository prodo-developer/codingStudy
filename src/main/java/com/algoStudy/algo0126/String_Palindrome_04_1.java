package com.algoStudy.algo0126;

public class String_Palindrome_04_1 {

    // 팰린드롬
    public static void main(String[] args) {
        String a = "bananas";

        System.out.println(new String_Palindrome_04_1().solve(a));
    }

    public boolean solve(String a) {
        int len = a.length();
        boolean flag = true;

        for (int i = 0; i < len/2; i++) {
            if(a.charAt(i) != a.charAt(len-i-1)) {
                flag = false; // 한번이라도 같지 않으면
            }
        }

        return flag;
    }

}
