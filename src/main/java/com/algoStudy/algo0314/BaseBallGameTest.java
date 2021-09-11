package com.algoStudy.algo0314;

import java.util.Stack;

/**
 * 야구게임
 */
public class BaseBallGameTest {

    public int calPoints(String[] ops) {
        // 1
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        // 2
        for (String op : ops) {
            switch (op) {
                case "C" :
                    stack.pop(); //뒤에꺼 빼서 제거
                    break;
                case "D" :
                    stack.push(stack.peek()*2); // 앞에꺼를 빼서 2배만들기
                    break;
                case "+" :
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x+y);
                    break;
                default :
                    stack.push(Integer.valueOf(op));
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};

        System.out.println(new BaseBallGameTest().calPoints(ops));
    }
}
