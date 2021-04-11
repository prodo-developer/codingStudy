package com.algoStudy.algo0125;

public class Adday2D {

    public void solution(int[][] grid) {

        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                System.out.print("["+i+"]["+j+"]" + grid[i][j]+" ");
                // System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] grid = new int[3][4];
        System.out.println("====1번====");

        Adday2D a = new Adday2D();
        a.solution(grid);
        grid[0][1] = 10;
        grid[2][1] = 10;
        System.out.println("====2번====");
        a.solution(grid);

        int[][] grid3 = {{1,2}, {2,3}, {3,5}};
        System.out.println("===========3번==========");
        a.solution(grid3);
    }
}
