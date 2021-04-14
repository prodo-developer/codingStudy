package com.collectionStudy.lecture.app.util;

public class Program {

    // Object : 모든 객체를 묶을 수 있는 범용 자료형식
    public static void main(String[] args) {
        GList<Integer> list = new GList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("size : %d\n", list.get(i));
        }


    }
}
