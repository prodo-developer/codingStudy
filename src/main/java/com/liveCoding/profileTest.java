package com.liveCoding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Member {

    private String name;
    private String hobby;
    private String introduce;

    public Member(String name, String hobby, String introduce) {
        this.name = name;
        this.hobby = hobby;
        this.introduce = introduce;
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public String getIntroduce() {
        return introduce;
    }
}

public class profileTest {

    /**
     * 이름,      취미,          소개
     * 김프로, 축구:농구:야구, 구기종목 좋아요
     * 정프로, 개발:당구:족구, 개발하는데 뛰긴 싫어
     * 앙몬드, 피아노, 죠르디가 좋아요 좋아좋아너무좋아
     * 죠르디, 스포츠댄스:개발, 개발하는 죠르디
     *
     */
    public static void main(String[] args) {

        Member member1 = new Member("김프로", "축구:농구:야구", "구기종목 좋아요");
        Member member2 = new Member("정프로", "개발:당구:족구", "개발하는데 뛰긴 싫어");
        Member member3 = new Member("앙몬드", "피아노:축구", "죠르디가 좋아요 좋아좋아너무좋아");
        Member member4 = new Member("죠르디", "스포츠댄스:개발", "개발하는 죠르디");

        StringTokenizer s1 = new StringTokenizer(member1.getHobby(), ":");
        StringTokenizer s2 = new StringTokenizer(member2.getHobby(), ":");
        StringTokenizer s3 = new StringTokenizer(member3.getHobby(), ":");
        StringTokenizer s4 = new StringTokenizer(member4.getHobby(), ":");

        List<String> list = new ArrayList<>();

        while(s1.hasMoreTokens()) {
            list.add(s1.nextToken());
        }

        while(s2.hasMoreTokens()) {
            list.add(s2.nextToken());
        }

        while(s3.hasMoreTokens()) {
            list.add(s3.nextToken());
        }

        while(s4.hasMoreTokens()) {
            list.add(s4.nextToken());
        }

        System.out.println(list);

        Map<String, Integer> result = new HashMap<>();
        list.stream()
                .filter(member-> member.startsWith("정"))//정씨 성을 갖는 멤버를 필터링
                .flatMap(member -> Arrays.stream(member.split(":")))
                .forEach(hobby -> result.merge(hobby, 1, (oldValue, newValue)->++oldValue));

        //출력
        result.entrySet().forEach(entry-> System.out.println(entry.getKey() + " " + entry.getValue()));

        // 특정 조건 찾기 자바 7버전
        List<String> startsWithN1 = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("축")) {
                startsWithN1.add(name);
            }
        }
        System.out.println(startsWithN1.size());

        // 특정 조건 찾기 자바 8버전
        List<String> startsWithN2 =
                list.stream().filter(name -> name.startsWith("야"))
                        .collect(Collectors.toList());

        System.out.println(startsWithN2);
    }

}
