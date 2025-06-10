package io.pinkspider.hash;

import java.util.HashMap;

// 완주하지 못한 선수
public class Solution19 {

    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> completionMap = new HashMap<>();

        for (String s : completion) {
            completionMap.put(s, completionMap.getOrDefault(s, 0) + 1);
        }

        for (String s : participant) {
            if (completionMap.getOrDefault(s, 0) == 0) {
                return s;
            }
            completionMap.put(s, completionMap.get(s) - 1);
        }
        return null;
    }
}
