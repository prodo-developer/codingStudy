package com.programers.week1;

import java.util.ArrayList;
import java.util.List;

public class MathtestOopReal {

    static class Student {
        private final int[] answers;
        private final int id;
        private int realAnswerCnt;   // 정확한 정답 개수
        private int realAnswerIndex; // 인덱스

        public Student(int[] answers, int id) {
            this.answers = answers;
            this.id = id;
            this.realAnswerCnt = 0;
            this.realAnswerIndex = 0;
        }

        public void checkAnswer(int answer) {
            if (answers[getRealAnswerIndex()] == answer) {
                correctAnswer();
            }
        }

        private int getRealAnswerIndex() {
            if (realAnswerIndex == answers.length) {
                realAnswerIndex = 0;
            }

            return realAnswerIndex++;
        }

        private void correctAnswer() {
            realAnswerCnt++;
        }

        public int getCorrectAnswerCnt() {
            return realAnswerCnt;
        }

        public int getId() {
            return id;
        }

    }

    // 정답 패턴의 개수가 일정치 않기 때문에 각각 수포자들의 답안 패턴 길이로 정답을 나머지연산하면서 정답 개수를 구함.
    public int[] solution(int[] answers) {
        Student student1 = new Student(new int[]{1,2,3,4,5}, 1);
        Student student2 = new Student(new int[]{2,1,2,3,2,4,2,5}, 2);
        Student student3 = new Student(new int[]{3,3,1,1,2,2,4,4,5,5}, 3);

        // oop에 저장할 값을 배열에 담습니다.
        Student[] students = {student1, student2, student3};
        List<Integer> list = new ArrayList<>();
        int maxCorrectCnt = 0;

        for (Student student : students) {
            for (int answer : answers) {
                student.checkAnswer(answer);
                maxCorrectCnt = Math.max(student.getCorrectAnswerCnt(), maxCorrectCnt);
            }
        }

        for (Student student : students) {
            if (student.getCorrectAnswerCnt() == maxCorrectCnt) {
                list.add(student.getId());
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        // 스트림 방법
        // return list.stream().mapToInt(i -> i).toArray();

        return arr;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,4,2};
//        int[] a = {1,2,3,4,5};

        System.out.println(new MathtestOopReal().solution(a));
    }
}
