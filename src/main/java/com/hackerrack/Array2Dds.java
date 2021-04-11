package com.hackerrack;

public class Array2Dds {

    static int hourglassSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int colums = grid[0].length;

//      int max_hourglass_sum = Integer.MIN_VALUE;    // 정수 최소값.
        int max_hourglass_sum = -63;                  // 7 * -9 = -63 제약조건 -9 ~ 9 까지 있었기때문에

        for (int i = 0; i < rows-2; i++) {
            for (int j = 0; j < colums-2; j++) {
                // 모래시계 합 구하기
                int current_hurglass_sum = grid[i][j] + grid[i][j+1] + grid[i][j+2]
                                        + grid[i+1][j+1] + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];

                max_hourglass_sum = Math.max(max_hourglass_sum, current_hurglass_sum);
            }
        }

        return max_hourglass_sum;
    }


    public static void main(String[] args) {
//        int[][] arr = new int[6][6];
        int[][] arr = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
        };

        System.out.println(new Array2Dds().hourglassSum(arr));
    }
}
