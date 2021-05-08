package com.algoStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * findMaxHope ( 물건 리스트, 남은 캐리어 용량, 현재 아이템 ){
 * <p>
 * # 기저부분
 * 1. 현재 아이템이 마지막 아이템이면 나간다.
 * 2. 남은 용량이 0보다 같거나 작음 나간다.
 * <p>
 * # 현재 아이템에 포인트 1만 더 해줌으로서, 지금 아이템을 선택 안 했을 때 절박도를 구한다.
 * 현재 아이템을 선택 안 할때 절박도 = findMaxHope ( 물건 리스트, 캐리어 용량, 현재 아이템 + 1)
 * <p>
 * # 현재 아이템을 선택했을 때 절박도 ( 현재 아이템의 무게가, 남은 캐리어 용량보다 작아야된다 )
 * 현재 아이템을 선택 할때 절박도  = findMaxHope ( 물건 리스트, 캐리어 용량 - 현재 아이템 무게 , 현재 아이템 + 1)
 * <p>
 * <p>
 * # 둘 중 큰 값 반환
 * return max ( 현재 아이템을 선택 안 할때 절박도, 현재 아이템을 선택 할때 절박도 )
 * <p>
 * }
 * https://likefree.tistory.com/8
 */
public class TravelBagTest {

    static int cache[][] = new int[1001][100];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();

        List<String> items = null;
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt();
            int w = scanner.nextInt();

            List<Stuff> stuffs = new ArrayList<Stuff>();
            items = new ArrayList<String>();

            for (int j = 0; j < n; j++) {
                String name = scanner.next();
                int weight = scanner.nextInt();
                int hope = scanner.nextInt();
                Stuff stuff = new Stuff(name, weight, hope);
                stuffs.add(stuff);
            }

            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k < 100; k++) {
                    cache[j][k] = -1;
                }
            }

            int point = 0;
            int hope = findMaxHope(stuffs, w, point);
            getItemList(stuffs, w, point, items);

            System.out.println(hope + " " + items.size());
            for (int j = 0; j < items.size(); j++) {
                System.out.println(items.get(j));
            }
        }
    }

    private static void getItemList(List<Stuff> stuffs, int w, int point, List<String> items) {
        if( point == stuffs.size() ) {
            return;
        }

        if( w <= 0 ) {
            return;
        }

        // 두 값이 다르다면  , 최대 절박도를 얻을 수 있다.
        if (findMaxHope(stuffs, w, point) == findMaxHope(stuffs, w, point+1))
            getItemList(stuffs, w, point + 1, items);
        else
        {
            items.add(stuffs.get(point).getName());
            getItemList(stuffs, w - stuffs.get(point).getWeight() , point + 1, items);
        }
    }

    private static int findMaxHope(List<Stuff> stuffs, int w, int point) {
        // 기저부분 

        if( point == stuffs.size() ) {
            return 0;
        }

        if( w <= 0 ) {
            return 0;
        }

        if( cache[w][point] != -1) {
            return cache[w][point];
        }

        // hope는 절박도 
        int hope = 0;

        // 현재 아이템을 선택하지 않는 경우 ( 무게가 무거워 베낭에 담을 수 없을 시 )
        hope = findMaxHope(stuffs, w, point+1);

        // 현재 아이템을 선택할 경우 

        if( w >= stuffs.get(point).getWeight() ) {
            int rhope = ( findMaxHope(stuffs, w - stuffs.get(point).weight , point+1) ) + stuffs.get(point).hope ;

            if( rhope > hope ) 
                hope = rhope;
        }

        cache[w][point] = hope;

        return hope;
    }

    static class Stuff {

        String name;
        int weight;
        int hope;

        public Stuff(String name, int weight, int hope) {
            this.name = name;
            this.weight = weight;
            this.hope = hope;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getHope() {
            return hope;
        }

        public void setHope(int hope) {
            this.hope = hope;
        }
    }

}
