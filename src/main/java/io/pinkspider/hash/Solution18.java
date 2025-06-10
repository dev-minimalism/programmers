package io.pinkspider.hash;

import java.util.HashSet;

// 두 개의 수로 특정값 만들기
public class Solution18 {

    public static boolean solution(int[] arr, int target) {

        boolean result = false;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            if (hashSet.contains(target - i)) {
                return true;
            }
            hashSet.add(i);
        }

        return false;
    }
}
