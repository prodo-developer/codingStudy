package com.programers.week1;

import java.util.ArrayList;
import java.util.List;

public class MathtestOop {

    // 정답 패턴의 개수가 일정치 않기 때문에 각각 수포자들의 답안 패턴 길이로 정답을 나머지연산하면서 정답 개수를 구함.
    public int[] solution(int[] answers) {
        int[] tmp = { 0, 0, 0 };
        int[] a = {};

        int[] person1 = {1, 2, 3, 4, 5};
        tmp[0] = countAnswer(person1, answers);
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        tmp[1] = countAnswer(person2, answers);
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        tmp[2] = countAnswer(person3, answers);

        for (int i : tmp) {
            System.out.println(i);
        }

        int[] answer = sortPerson(tmp, a);

        return answer;
    }

    // 정렬
    private int[] sortPerson(int[] tmp, int[] a) {
        int maxScore = Math.max(tmp[0], Math.max(tmp[1], tmp[2]));

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] == maxScore) {
                list.add(i+1);
            }
        }

        a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }

        return a;
    }

    /**
     *
     * @param person
     * @param answers answers 배열이 person 배열보다 작을 때도 생각해야한다.
     * @return
     */
    private int countAnswer(int[] person, int[] answers) {
        int i = 0;
        int personCnt = 0;
        int answerCnt = 0;

        while(i < answers.length) {
            if(personCnt > person.length) // person 배열은 각 사람의 정답지 배열이다. 반복되는 구간이 끝나면 다시 처음부분으로 바꿔준다.
                personCnt++;

            if(person[i % person.length] == answers[i]) // 사람들의 정답과 실제 정답지 비교
                answerCnt++;

            personCnt++;
            i++;
        }

        return  answerCnt;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,4,2};
//        int[] a = {1,2,3,4,5};

        System.out.println(new MathtestOop().solution(a));
    }
}
