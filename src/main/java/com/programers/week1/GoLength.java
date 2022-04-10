package com.programers.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoLength {

    public int solution(String dirs) {
       String[] dirsArray = dirs.split(""); // 이동한 거리갯수

       List<Path> pathList = new ArrayList<>();
       Point cur = new Point(0,0);

       for(int i=0; i<dirsArray.length; i++) {
           char tempChar = dirs.charAt(i); // i번째의 문자 자르기

           Point moved = null;

           // 1. 방향에 따라
           // 2. 범위안에 포함이 되면 증감처리
           if(tempChar =='U'){
               if(cur.y<5)
                   moved = new Point(cur.x + 0, cur.y + 1);
           }else if(tempChar == 'L'){
               if(cur.x>-5)
                   moved = new Point(cur.x -1, cur.y + 0);
           }else if(tempChar == 'D'){
               if(cur.y>-5)
                   moved = new Point(cur.x + 0, cur.y - 1);
           }else if(tempChar == 'R'){
               if(cur.x<5)
                   moved = new Point(cur.x + 1, cur.y + 0);
           }

           if(moved != null) {
               Path moving = new Path(cur, moved);
               if(!pathList.contains(moving)) {
                   pathList.add(moving);
               }

               cur = moved;
           }

       }

       return pathList.size();
    }

    public static void main(String[] args) {

//        String dir = "ULURRDLLU";
        String dir = "LULLLLLLU";

        System.out.println(new GoLength().solution(dir));
    }
}

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Path {
    Point start, end;
    public Path(Point s, Point e) {
        start = s; end = e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return (Objects.equals(start, path.start) && Objects.equals(end, path.end)) ||
                (Objects.equals(start, path.end) && Objects.equals(end, path.start));
    }

    @Override
    public int hashCode() {
        // return Objects.hash(start, end);
        return start.hashCode() + end.hashCode();
    }
}