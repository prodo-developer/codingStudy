package com.programers.randomTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewsClerstaringTest {

    public int solution(String str1, String str2) {
        int answer = 0;
        // 1.소문자에서 대문자로 만들기
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 2씩 조갬
        List<String> aa1 = new ArrayList<String>();
        List<String> aa2 = new ArrayList<String>();

        for(int i=0; i< str1.length()-1; i++) {
            if(str2.substring(i, i+2).trim().length() == 2) {
                aa1.add(str1.substring(i, i+2));
                aa2.add(str2.substring(i, i+2));
            }
        }

        // 교집합 구하기
        Set<String> retainList = new HashSet<>();
        for(String str : aa1) {
            if(aa2.contains(str)) {
                retainList.add(str);
            }
        }

        System.out.println(retainList);

        // 합집합 구하기
        // 이미 중복된 값은 교집합에서 삭제 됐기때문에 남은것끼리 더한다.
        Set<String> unionList = new HashSet<>();

        for(String str : aa1) {
            unionList.add(str);
        }

        for(String str : aa2) {
            unionList.add(str);
        }

        System.out.println(unionList);

        // 자카드 유사도 구하기
        double jacard = (double) retainList.size() / (double) unionList.size();

        if(retainList.size() == 0 && unionList.size() ==0) {
            jacard = 1;
        }

        answer = (int) (jacard * 65536);

        return answer;
    }

    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 = "shake hands";

        System.out.println(new NewsClerstaringTest().solution(str1,str2));

//                FRANCE	french	16384
//        handshake	shake hands	65536
//        aa1+aa2	AAAA12	43690
//        E=M*C^2	e=m*c^2	65536
    }
}
