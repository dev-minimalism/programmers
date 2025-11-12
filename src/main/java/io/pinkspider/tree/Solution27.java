package io.pinkspider.tree;

import java.util.HashMap;

// 다단계 칫솔 판매
public class Solution27 {

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> total = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int money = amount[i] * 100;

            while (money > 0 && !sellerName.equals("-")) {
                total.put(sellerName, total.getOrDefault(sellerName, 0) + money - (money / 10));
                sellerName = parent.get(sellerName);
                money /= 10;
            }
        }

        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}
