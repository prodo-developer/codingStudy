package com.collectionStudy.lecture.app.util;

public class IntList {

    private int[] nums;  // 공간
    private int current; // 저장 할 위치

    public IntList() {
        nums = new int[3];
        current = 0;
    }

    public void add(int num) {
        nums[current] = num;
        // 또는 nums[current++] = num;
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

    public int get(int index) {

        if(current <= index)
            throw new IndexOutOfBoundsException();

        return nums[index];
    }
}
