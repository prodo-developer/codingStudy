package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class WhereHouseTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[1001];
        int start=1000;
        int end=0;

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());

            arr[l]=h;
            start=Math.min(l,start);
            end=Math.max(l,end);
        }

        Stack<Integer> trace = new Stack<>();

        int pivot = arr[start];

        for(int i=start+1; i<=end; i++) {
            if(arr[i] < pivot) {
                trace.push(i);
            } else {
                while(!trace.isEmpty()) {
                    int leftMax = trace.pop();
                    arr[leftMax] = pivot;
                }
                pivot = arr[i];
            }
        }

        trace.clear();
        pivot = arr[end];

        for(int i=end-1; i>=0; i--) {
            if(arr[i] < pivot) {
                trace.push(i);
            } else {
                while(!trace.isEmpty()) {
                    int rightMax = trace.pop();
                    arr[rightMax] = pivot;
                }
                pivot = arr[i];
            }
        }

        int answer = 0;
        for (int i = start; i <= end; i++) {
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
