package com.leetCode;

import java.util.ArrayList;

public class MinStack {

    ArrayList < Integer > stack = new ArrayList();

    public MinStack() {

    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        int min = stack.get(0);
        for (int i = 1; i < stack.size(); i++) {
            if (min > stack.get(i)) {
                min = stack.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
