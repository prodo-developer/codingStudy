package com.leetCode;

import java.io.IOException;
import java.util.Arrays;

/**
 * 릿코드(Trapping Rain Water), 백준(빗물 14719) 에서 출제
 */
public class TrappingRainWater {

    public static int solve(int[] height) {
        int result = 0;
        if(height == null || height.length <= 2)
            return result;

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        // 왼쪽 맥스값
        int leftMax = height[0];

        for (int i = 1; i < height.length; i++) {
            if(leftMax < height[i]) {
                leftMax = height[i];
                left[i] = height[i];
            } else {
                left[i] = leftMax;
            }
        }

        System.out.println(Arrays.toString(left));

        // 오른쪽 맥스값
        int rightMax = height[height.length-1];
        right[height.length-1] = height[height.length-1];

        for (int i = height.length-2; i >= 0; i--) {
            if(rightMax > height[i]) {
                right[i] = rightMax;
            } else {
                right[i] = height[i];
                rightMax = height[i];
            }
        }

        System.out.println(Arrays.toString(right));

        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};

        //        백준
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int H = Integer.parseInt(st.nextToken());
//        int W = Integer.parseInt(st.nextToken());
//        int[] height = new int[W];    // 사이즈 결정
//        int result = 0;
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < W; i++) {
//            int N = Integer.parseInt(st.nextToken());
//            height[i] = N;
//        }

        System.out.println(new TrappingRainWater().solve(nums));
    }
}
