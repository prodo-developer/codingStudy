package com.collectionStudy.lecture.app.util;

public class ObjectList {

    private Object[] nums;  // 공간
    private int current; // 저장 할 위치

    public ObjectList() {
        nums = new Object[3];
        current = 0;
    }

    public void add(Object num) {
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

    public Object get(int index) {

        if(current <= index)
            throw new IndexOutOfBoundsException();

        return nums[index];
    }
}
