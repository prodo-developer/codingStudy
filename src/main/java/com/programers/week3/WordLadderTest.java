package com.programers.week3;

import java.util.*;

public class WordLadderTest {

    public int solution(String begin, String target, String[] words) {
        // 일반 배열을 ArrayList로 변환한다.
        List<String> wordList = Arrays.asList(words);

        if(wordList==null || !wordList.contains(target)) {
            return 0;
        }

        Queue<String> que = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList); // 중복을 허용하지 않는 저장객체
        que.offer(begin); // hit 넣기
        dict.add(target); // 최종 단어 넣기(cog)
        dict.remove(begin);
        int level = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String str = que.poll(); // hit 빼기
                if(str.equals(target)) return level;
                for(String neighbor : neighBfs(str, wordList)) {
                    que.offer(neighbor);
                }
            }
            level++;
        }

        return level;
    }

    private List<String> neighBfs(String s, List<String> wordList) {
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch='a'; ch <= 'z'; ch++) {
                chars[i]=ch; // ait~zit까지
                String word = new String(chars);
                if(dict.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(new WordLadderTest().solution(begin, target, words));
    }
}
