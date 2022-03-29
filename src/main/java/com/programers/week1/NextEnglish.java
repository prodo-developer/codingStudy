package com.programers.week1;

import java.util.HashSet;

public class NextEnglish {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        char wordStart;
        char wordEnd = words[0].charAt(words[0].length()-1); // 처음 단어의 마지막 문자를 저장

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(words[0]); // 첫단어를 해쉬셋에 저장

        for(int i=1; i<words.length; i++) {
            // 중복인지 확인
            boolean workChk = hashSet.contains(words[i]);
            wordStart = words[i].charAt(0);

            // 끝말이 이어지는지 확인
            if(wordEnd != wordStart || workChk) { // 중복 or 끝말이아님
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }

            // 단어추가
            hashSet.add(words[i]);
            wordEnd = words[i].charAt(words[i].length()-1);
        }

        System.out.println(hashSet);

        return answer;
    }

    public static void main(String[] args) {

        int n = 3;
        String[] words = {
                "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
        };

        System.out.println(new NextEnglish().solution(n,words));

    }
}
