package com.hackerrack.hashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ‘geometric progression’에 주목해야 한다. 뜻은 등비수열이다. (A, B, C가 있을 때 B = A * r, C = B * r = A * r * r 이다. 따라서 A = B / r 이고 B = C / r 이다.)
 */
public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {

        long ans = 0;

        // 모든 숫자는 첫번째 위치에 올 수 있으므로 아무런 조건 없이 구하는 수
       Map<Long, Long> mapForStart = new HashMap<>();

        // 현재 값이 처음에 왔을 경우의 수를 구하는 Map<Long, Long> mapForStart와 중간에 왔을 경우의 수
        Map<Long, Long> mapForMiddle = new HashMap<>();

        for (Long num : arr) {
            // geometric progression(등비수열)
            if(num % r == 0) {          // 나머지가 0이면
                long prev = num / r;    // 몫 구하기
                Long cntForEnd = mapForMiddle.get(prev);
                // 현재 값을 r로 나눈 몫이(= $prev) 중간에 있었던 적이 있으면
                if(cntForEnd != null)
                    ans += cntForEnd;

                Long cntForMiddle = mapForStart.get(prev);
                // 현재 값을 r로 나눈 몫이(= $prev) 처음에 있었던 적이 있으면
                if(cntForMiddle != null)
                    mapForMiddle.put(num, mapForMiddle.getOrDefault(num, 0L) + cntForMiddle);
            }

            mapForStart.put(num, mapForStart.getOrDefault(num, 0L) +1);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Long> arr = new ArrayList<>();
//        arr.add(1L);
//        arr.add(3L);
//        arr.add(9L);
//        arr.add(9L);
//        arr.add(27L);
//        arr.add(81L);
//
//        long r = 3L; // 2

        arr.add(1L);
        arr.add(2L);
        arr.add(2L);
        arr.add(4L);

        long r = 2L; // 2

        System.out.println(new CountTriplets().countTriplets(arr, r));
    }
}
