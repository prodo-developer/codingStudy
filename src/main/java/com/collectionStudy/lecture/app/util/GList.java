package com.collectionStudy.lecture.app.util;

/**
 * 1. 공통 제네릭 적용
 *
 * 공간을 점진적으로 늘리는 위치와 방법
 * 1. amount개 확장한 새로운 배열 temp를 생성한다.
 * 2. list에 있는 데이터를 temp 배열로 옮긴다.
 * 3. temp가 참조하는 객체를 list가 참조하게 한다.
 * 4. 현재 capacityr의 값을 amount 증가시킨다.
 */
public class GList<T> {

    private Object[] nums;  // 공간
    private int current;    // 저장 할 위치 -1
    private int capacity;   // 용량
    private int amount;     // 추가 증가량

    public GList() {
        current = 0;
        capacity = 3;
        amount   = 5;
        nums = new Object[capacity];
    }

    public void add(T num) {
        // 공간이 부족한지 -> 공간 늘리기
        if(capacity <= current) {
            Object[] temp = new Object[capacity+amount];
            for (int i = 0; i < current; i++) {
                temp[i] = nums[i];
            }
            nums = temp;
            capacity += amount;
        }

        // 공간이 모자르지 않을 때
        nums[current] = num;
        current++;
    }

    public void clear() {
//        for (int i = 0; i <current; i++)
//            nums[i] = 0;
//        또는 nums = new int[3]; // 초기화
       current = 0;
    }

    public int size() {
        return current;
    }

    public T get(int index) {

        if(current <= index)
            throw new IndexOutOfBoundsException();

        return (T) nums[index];
    }
}
