package com.algoStudy.algo0314;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTest {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colstart = 0;
        int colEnd = matrix[0].length - 1;

        while(rowStart <= rowEnd && colstart <= colEnd) {
            // right
            for (int i = colstart; i <= colEnd; i++) {
             result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left 3->0
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colstart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // right
            if(colstart <= colEnd)
                if (rowStart <= rowEnd) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        result.add(matrix[i][colstart]);
                }
            }
            colstart++;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] martix = {{1 ,2 ,3},
//                          {4 ,5 ,6},
//                          {7 ,8 ,9}};

//        int[][] martix = {{1,2,3,4},
//                          {5,6,7,8},
//                         {9,10,11,12}};

        int[][] martix = {{1, 2, 3,  4},
                          {5, 6, 7,  8},
                          {9, 10, 11,12},
                          {13, 14, 15,16}};

        System.out.println(new SpiralMatrixTest().spiralOrder(martix));

    }

}
