package io.pinkspider.hash;

import java.util.ArrayList;
import java.util.HashMap;

// 할인행사
public class Solution20 {

    public static int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length - 9; i++) {

            HashMap<String, Integer> discountMap = new HashMap<>();

            for (int j = i; j < discount.length + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
                }
            }

            if (discountMap.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }

    public static int other_solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < want.length; i++) {
            while (number[i]-- > 0) {
                list.add(want[i]);
            }
        }

        for (int i = 0; i < discount.length - list.size() + 1; i++) {
            ArrayList<String> l = (ArrayList<String>) list.clone();
            for (int j = i; j < i + list.size(); j++) {
                if (l.contains(discount[j])) {
                    l.remove(discount[j]);
                } else {
                    break;
                }
            }
            answer += l.size() == 0 ? 1 : 0;
        }

        return answer;
    }
}
